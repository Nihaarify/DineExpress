/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Nihaarthika
 */

public class WelcomeScreen extends JFrame {
    
    public WelcomeScreen() {
        setTitle("Dine Express - Welcome");
        setSize(400, 600); // Adjust as needed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Load background image
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("images/welcome.png"));
        JLabel bgLabel = new JLabel(bgIcon);
        bgLabel.setLayout(null);  // Absolute layout to place button freely

        // Create "Get Started" button
        JButton getStartedBtn = new JButton("Get Started");
        getStartedBtn.setBounds(120, 500, 150, 40); // Position on image
        getStartedBtn.setBackground(new Color(255, 102, 0));
        getStartedBtn.setForeground(Color.WHITE);
        getStartedBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        getStartedBtn.setFocusPainted(false);
        getStartedBtn.setBorder(BorderFactory.createEmptyBorder());

           getStartedBtn.addActionListener(e -> {
           new AuthChoiceUI().setVisible(true);
           dispose(); // closes welcome screen

 });

        // Add button to image label
        bgLabel.add(getStartedBtn);
        setContentPane(bgLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomeScreen().setVisible(true);
        });
    }
}

    

