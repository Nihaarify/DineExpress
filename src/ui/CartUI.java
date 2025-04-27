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
import java.awt.event.*;
import java.util.ArrayList;
import ui.PaymentUI;


public class CartUI extends JFrame {

    private DefaultListModel<String> cartModel;
    private JList<String> cartList;
    private JLabel totalLabel;

    public CartUI(ArrayList<String> cartItems) {
        setTitle("🛒 Your Cart - Dine Express");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        cartModel = new DefaultListModel<>();
        for (String item : cartItems) {
            cartModel.addElement(item);
        }

        cartList = new JList<>(cartModel);
        JScrollPane scrollPane = new JScrollPane(cartList);

        JButton removeButton = new JButton("❌ Remove Selected");
        removeButton.addActionListener(e -> removeSelectedItem());

        totalLabel = new JLabel("Total: ₹" + calculateTotal(), JLabel.CENTER);
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        totalLabel.setForeground(Color.BLUE);

        JPanel bottomPanel = new JPanel();
bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

// Proceed to Payment button
JButton paymentButton = new JButton("✅ Proceed to Payment");
paymentButton.setBackground(new Color(46, 204, 113)); // green
paymentButton.setForeground(Color.WHITE);
paymentButton.setFocusPainted(false);
paymentButton.setAlignmentX(Component.CENTER_ALIGNMENT);

paymentButton.addActionListener(e -> {
    if (cartModel.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Cart is empty!", "Oops", JOptionPane.WARNING_MESSAGE);
    } else {
        // Extract cart items from model
        ArrayList<String> itemsToPay = new ArrayList<>();
        for (int i = 0; i < cartModel.size(); i++) {
            itemsToPay.add(cartModel.getElementAt(i));
        }

        dispose(); // Close Cart UI
        new PaymentUI(itemsToPay); // Go to payment
    }
});

bottomPanel.add(Box.createVerticalStrut(10));
bottomPanel.add(removeButton);
bottomPanel.add(Box.createVerticalStrut(10));
bottomPanel.add(totalLabel);
bottomPanel.add(Box.createVerticalStrut(10));
bottomPanel.add(paymentButton);
bottomPanel.add(Box.createVerticalStrut(10));

        
        

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void removeSelectedItem() {
        int selectedIndex = cartList.getSelectedIndex();
        if (selectedIndex != -1) {
            cartModel.remove(selectedIndex);
            totalLabel.setText("Total: ₹" + calculateTotal());
        }
    }

    private int calculateTotal() {
        int total = 0;
        for (int i = 0; i < cartModel.size(); i++) {
            String item = cartModel.getElementAt(i);
            String[] parts = item.split("₹");
            if (parts.length == 2) {
                try {
                    total += Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return total;
    }

    // For testing only: You can remove this main method once everything is integrated
    public static void main(String[] args) {
        ArrayList<String> sampleCart = new ArrayList<>();
        sampleCart.add("Idly - ₹40");
        sampleCart.add("Poha - ₹35");
        sampleCart.add("Chicken Curry - ₹120");

        SwingUtilities.invokeLater(() -> new CartUI(sampleCart));
    }
    }
