package ui;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author Nihaarthika
 */

public class SignUpUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;

    public SignUpUI() {
        setTitle("Dine Express - Sign Up");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 255, 240));

        JLabel title = new JLabel("🍽️ Dine Express - Sign Up");
        title.setFont(new Font("Serif", Font.BOLD, 22));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        usernameField.setMaximumSize(new Dimension(200, 30));
        passwordField.setMaximumSize(new Dimension(200, 30));

        JButton signUpButton = new JButton("Create Account");
        signUpButton.setBackground(new Color(60, 179, 113));
        signUpButton.setForeground(Color.WHITE);

        statusLabel = new JLabel(" ");
        statusLabel.setForeground(Color.RED);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(20));
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("New Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("New Password:"));
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(signUpButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(statusLabel);

        add(panel);

        signUpButton.addActionListener(e -> saveUser());
    }

    private void saveUser() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please fill all fields.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + "," + password);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Account created! You can now login.");
            dispose(); // Close this window
            new LoginUI().setVisible(true); // Open login screen
        } catch (IOException e) {
            statusLabel.setText("Error saving user.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUpUI().setVisible(true));
    }
}
