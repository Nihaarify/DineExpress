/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nihaarthika
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfirmationUI extends JFrame {

    public ConfirmationUI(String paymentMethod, String name, String phone, String email, String address, String pincode) {
        setTitle("Order Confirmed!");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("🎉 Order Placed Successfully!");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // Center panel for info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Dummy delivery names and random delivery time
        String[] names = {"Rahul", "Priya", "Vikram", "Anjali", "Karthik", "Sneha"};
        String deliveryPerson = names[new Random().nextInt(names.length)];
        String deliveryPhone = "+91 98" + (100000 + new Random().nextInt(900000)); // Dummy number
        int estimatedTime = 20 + new Random().nextInt(11); // 20-30 mins

        // Create labels
        JLabel nameLabel = new JLabel("👤 Name: " + name);
        JLabel phoneLabel = new JLabel("📱 Phone: " + phone);
        JLabel emailLabel = new JLabel("📧 Email: " + email);
        JLabel methodLabel = new JLabel("💳 Payment Method: " + paymentMethod);
        JLabel addressLabel = new JLabel("<html>📍 Address:<br>" + address.replaceAll("\n", "<br>") + "<br>Pincode: " + pincode + "</html>");
        JLabel deliveryLabel = new JLabel("👨‍🍳 Delivery by: " + deliveryPerson);
        JLabel deliveryPhoneLabel = new JLabel("📞 Delivery Contact: " + deliveryPhone);
        JLabel timeLabel = new JLabel("⏱️ Estimated Time: " + estimatedTime + " minutes");

        // Style and add to panel
        JLabel[] labels = {nameLabel, phoneLabel, emailLabel, methodLabel, addressLabel, deliveryLabel, deliveryPhoneLabel, timeLabel};

        for (JLabel lbl : labels) {
            lbl.setFont(new Font("SansSerif", Font.PLAIN, 16));
            lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            infoPanel.add(lbl);
            infoPanel.add(Box.createVerticalStrut(10));
        }

        // Done button
        JButton doneBtn = new JButton("Done");
        doneBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        doneBtn.setBackground(new Color(52, 152, 219));
        doneBtn.setForeground(Color.WHITE);
        doneBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Thank you for ordering with Dine Express!");
            dispose();
        });

        infoPanel.add(Box.createVerticalStrut(20));
        infoPanel.add(doneBtn);

        add(infoPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
