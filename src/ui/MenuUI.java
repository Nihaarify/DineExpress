/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import ui.CartUI;


/**
 *
 * @author Nihaarthika
 */
public class MenuUI extends JFrame {

    private JPanel menuPanel;
    private ArrayList<String> cart = new ArrayList<>();

    public MenuUI() {
        setTitle("Dine Express Menu");
        setSize(450, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Search bar panel (centered)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField searchBar = new JTextField("Search...", 20);
        searchBar.setFont(new Font("SansSerif", Font.PLAIN, 16));
        topPanel.add(searchBar);
        add(topPanel, BorderLayout.NORTH);
                // View Cart button
        JButton viewCartButton = new JButton("🛒 View Cart");
        viewCartButton.setBackground(new Color(255, 102, 51));
        viewCartButton.setForeground(Color.WHITE);
        viewCartButton.setFocusPainted(false);
        viewCartButton.setFont(new Font("SansSerif", Font.BOLD, 14));

        // Handle click
        viewCartButton.addActionListener(e -> new CartUI(cart));

        topPanel.add(viewCartButton);


        // Menu Panel - 2 column grid
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 2, 10, 10));
        menuPanel.setBackground(Color.white);
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Add food items
        String[][] items = {
            {"idli.png", "Idly", "₹40"},
            {"upma.png", "Upma", "₹35"},
            {"sambar_rice.png", "Sambar Rice", "₹60"},
            {"curd_rice.png", "Curd Rice", "₹50"},
            {"appam.png", "Aapam", "₹45"},
            {"pongal.png", "Pongal", "₹40"},
            {"veg_meals.png", "Veg Meals", "₹90"},
            {"paratha.png", "Paratha", "₹55"},
            {"chole_bhature.png", "Chole Bhature", "₹70"},
            {"poha.png", "Poha", "₹40"},
            {"rajma_chawal.png", "Rajma Chawal", "₹80"},
            {"dal_makhani.png", "Dal Makhani", "₹85"},
            {"kadai_paneer.png", "Kadai Paneer", "₹110"},
            {"chicken_curry.png", "Chicken Curry", "₹130"},
        };

        for (String[] item : items) {
            addMenuItem(item[0], item[1], item[2]);
        }

        setVisible(true);
    }

    private void addMenuItem(String imagePath, String name, String price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setPreferredSize(new Dimension(180, 180));
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Load and scale image
        ImageIcon icon = new ImageIcon("resources/" + imagePath);
        Image scaled = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setForeground(new Color(0, 128, 0));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addBtn = new JButton("🛒 Add");
        addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        addBtn.addActionListener(e -> showCartPopup(name, price));

        itemPanel.add(Box.createVerticalStrut(10));
        itemPanel.add(imageLabel);
        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);
        itemPanel.add(Box.createVerticalStrut(5));
        itemPanel.add(addBtn);

        // Fade-in animation
        itemPanel.setOpaque(false);
        Timer timer = new Timer(10, new ActionListener() {
            float alpha = 0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                itemPanel.setOpaque(true);
                itemPanel.repaint();
                if (alpha >= 1f) ((Timer) e.getSource()).stop();
            }
        });
        timer.start();

        menuPanel.add(itemPanel);
    }

    private void showCartPopup(String itemName, String price) {
        cart.add(itemName + " - " + price);
        JOptionPane.showMessageDialog(this,
                itemName + " added to cart!",
                "Cart Updated",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuUI());
    }
}
