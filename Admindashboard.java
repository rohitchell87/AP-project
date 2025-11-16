package edu.univ.erp.ui.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {
    private JLabel statusLabel;

    public AdminDashboard() {
        setTitle("Admin Dashboard - University ERP");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // User Management Menu
        JMenu userMenu = new JMenu("User Management");
        JMenuItem addUserItem = new JMenuItem("Add User");
        JMenuItem viewUsersItem = new JMenuItem("View Users");
        userMenu.add(addUserItem);
        userMenu.add(viewUsersItem);

        // Course Management Menu
        JMenu courseMenu = new JMenu("Course Management");
        JMenuItem addCourseItem = new JMenuItem("Add Course");
        JMenuItem viewCoursesItem = new JMenuItem("View Courses");
        courseMenu.add(addCourseItem);
        courseMenu.add(viewCoursesItem);

        // System Menu
        JMenu systemMenu = new JMenu("System");
        JMenuItem maintenanceItem = new JMenuItem("Maintenance Mode");
        JMenuItem logoutItem = new JMenuItem("Logout");
        systemMenu.add(maintenanceItem);
        systemMenu.add(new JSeparator());
        systemMenu.add(logoutItem);

        menuBar.add(userMenu);
        menuBar.add(courseMenu);
        menuBar.add(systemMenu);
        setJMenuBar(menuBar);

        // Main content area
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome Administrator!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(Color.BLUE);
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Quick actions panel
        JPanel quickActionsPanel = new JPanel(new FlowLayout());
        quickActionsPanel.add(new JLabel("Quick Actions: "));

        JButton addUserBtn = new JButton("Add User");
        JButton addCourseBtn = new JButton("Add Course");
        JButton maintenanceBtn = new JButton("Maintenance Mode");

        quickActionsPanel.add(addUserBtn);
        quickActionsPanel.add(addCourseBtn);
        quickActionsPanel.add(maintenanceBtn);

        mainPanel.add(quickActionsPanel, BorderLayout.NORTH);

        // Status bar at bottom
        statusLabel = new JLabel(" Ready | Maintenance Mode: OFF | Users: 0 | Courses: 0");
        statusLabel.setBorder(BorderFactory.createEtchedBorder());
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        add(mainPanel);

        // Add button actions
        addUserBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Add User feature will be implemented here!");
            statusLabel.setText(" Add User dialog opened");
        });

        addCourseBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Add Course feature will be implemented here!");
            statusLabel.setText(" Add Course dialog opened");
        });

        maintenanceBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Maintenance mode toggled!");
            statusLabel.setText(" Maintenance mode changed");
        });

        logoutItem.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Return to login window
                new LoginWindow().setVisible(true);
                this.dispose();
            }
        });
    }

    // Test method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminDashboard().setVisible(true);
        });
    }
}
