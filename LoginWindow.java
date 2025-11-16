package edu.univ.erp.ui.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("University ERP - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JLabel titleLabel = new JLabel("University ERP System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        formPanel.add(new JLabel(""));
        messageLabel = new JLabel(" ");
        messageLabel.setForeground(Color.RED);
        formPanel.add(messageLabel);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Button panel
        loginButton = new JButton("Login");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listener
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        add(mainPanel);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Please enter both username and password", true);
            return;
        }

        // Simple hardcoded login for testing
        if (username.equals("admin") && password.equals("admin123")) {
            showMessage("Login successful!", false);
            // Open Admin Dashboard and close login window
            SwingUtilities.invokeLater(() -> {
                new AdminDashboard().setVisible(true);
                this.dispose(); // Close login window
            });
        }
         else if (username.equals("student1") && password.equals("stu123")) {
            showMessage("Login successful! Opening student dashboard...", false);
            JOptionPane.showMessageDialog(this, "Welcome Student!");
        } else if (username.equals("instructor1") && password.equals("inst123")) {
            showMessage("Login successful! Opening instructor dashboard...", false);
            JOptionPane.showMessageDialog(this, "Welcome Instructor!");
        } else {
            showMessage("Invalid username or password", true);
        }
    }

    private void showMessage(String message, boolean isError) {
        messageLabel.setText(message);
        messageLabel.setForeground(isError ? Color.RED : Color.GREEN);

        // Clear message after 3 seconds
        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText(" ");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        // SIMPLEST FIX: Remove the look and feel code entirely
        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
            }
        });
    }
}
