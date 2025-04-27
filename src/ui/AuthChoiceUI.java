/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Nihaarthika
 */

public class AuthChoiceUI extends JFrame {

    public AuthChoiceUI() {
        setTitle("Dine Express - Choose");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Load background image
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("login.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 400, 600);
        background.setLayout(null); // allow placing items on top

        // Welcome text
        JLabel welcome = new JLabel("Welcome to Dine Express");
        welcome.setFont(new Font("Arial", Font.BOLD, 18));
        welcome.setForeground(Color.WHITE);
        welcome.setBounds(80, 100, 300, 30);
        background.add(welcome);

        // Login button
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(125, 200, 150, 40);
        loginBtn.setBackground(new Color(0, 153, 255));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 16));
        background.add(loginBtn);

        // SignUp button
        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(125, 260, 150, 40);
        signUpBtn.setBackground(new Color(255, 102, 0));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setFont(new Font("Arial", Font.BOLD, 16));
        background.add(signUpBtn);

        // Action listeners (add your page launching logic here)
        loginBtn.addActionListener(e -> {
            new LoginUI().setVisible(true);
            dispose();
        });

        signUpBtn.addActionListener(e -> {
             new SignUpUI().setVisible(true);

            dispose();
        });

        // Add background as last step
        setContentPane(background);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AuthChoiceUI().setVisible(true);
        });
    }
}

    

