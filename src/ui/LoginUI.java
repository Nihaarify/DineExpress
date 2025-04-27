/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import ui.MenuUI;  


/**
 *
 * @author Nihaarthika
 */
public class LoginUI extends JFrame{
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;

    public LoginUI() {
        setTitle("Dine Express - Login");
        setSize(400, 600);
        setLocationRelativeTo(null); // Center screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 245, 230)); // light background

        // Title
        JLabel title = new JLabel("🍽️ Dine Express");
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Slogan
        JLabel slogan = new JLabel("Hot Meals, On Wheels");
        slogan.setFont(new Font("SansSerif", Font.ITALIC, 14));
        slogan.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Input fields
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        usernameField.setMaximumSize(new Dimension(200, 30));
        passwordField.setMaximumSize(new Dimension(200, 30));

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(255, 102, 51)); // orange
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        // Status label
        statusLabel = new JLabel(" ");
        statusLabel.setForeground(Color.RED);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to panel
        panel.add(Box.createVerticalStrut(20));
        panel.add(title);
        panel.add(slogan);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(loginButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(statusLabel);

        add(panel);

        // Button action
        loginButton.addActionListener(e -> checkLogin());
    }

    private void checkLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean valid = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    valid = true;
                    break;
                }
            }

            if (valid) {
                statusLabel.setText("Login successful!");
                JOptionPane.showMessageDialog(this, "Welcome " + username + "!");
                dispose(); // Close this window
                new MenuUI(); // Launch the menu screen
// 👉 TODO: Open restaurant list screen (next step)
            } else {
                statusLabel.setText("Invalid credentials!");
            }

        } catch (IOException ex) {
            statusLabel.setText("Error reading users file.");
        }
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI().setVisible(true));
    }
}

    

