/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 *
 * @author Nihaarthika
 */
public class PaymentUI extends JFrame {
    private JRadioButton gpayBtn, codBtn;
    private JTextField nameField, phoneField, emailField, pincodeField;
    private JTextArea addressArea;

    public PaymentUI(ArrayList<String> cartItems) {
        setTitle("Dine Express - Payment");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Choose Payment Method");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        gpayBtn = new JRadioButton("GPay");
        codBtn = new JRadioButton("Cash on Delivery");
        ButtonGroup group = new ButtonGroup();
        group.add(gpayBtn);
        group.add(codBtn);
        gpayBtn.setSelected(true);

        JPanel paymentPanel = new JPanel(new GridLayout(2, 1));
        paymentPanel.add(gpayBtn);
        paymentPanel.add(codBtn);

        // Customer Details
        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        pincodeField = new JTextField();
        addressArea = new JTextArea(3, 20);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);

        // Confirm Button
        JButton confirmBtn = new JButton("Confirm Payment");
        confirmBtn.setBackground(new Color(46, 204, 113));
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.addActionListener(this::handleConfirm);

        // Adding all components
        panel.add(title);
        panel.add(Box.createVerticalStrut(10));
        panel.add(paymentPanel);
        panel.add(Box.createVerticalStrut(20));

        panel.add(new JLabel("👤 Name:"));
        panel.add(nameField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("📱 Phone Number:"));
        panel.add(phoneField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("📧 Email:"));
        panel.add(emailField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("📍 Address:"));
        panel.add(new JScrollPane(addressArea));
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("🏷️ Pincode:"));
        panel.add(pincodeField);
        panel.add(Box.createVerticalStrut(20));

        panel.add(confirmBtn);

        add(panel);
        setVisible(true);
    }

    private void handleConfirm(ActionEvent e) {
        String method = gpayBtn.isSelected() ? "GPay" : "Cash on Delivery";
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String address = addressArea.getText().trim();
        String pincode = pincodeField.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || pincode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Missing Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        dispose();
        new ConfirmationUI(method, name, phone, email, address, pincode);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaymentUI(new ArrayList<>()));
    }
}

    

