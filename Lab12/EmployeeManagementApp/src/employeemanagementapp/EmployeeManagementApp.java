package employeemanagementapp;
public class EmployeeManagementApp extends JFrame
{

    public static void main(String[] args)
    {
        // Initialize Swing components
        // ...

        // Create and configure the database connection (Replace with your database credentials)
        String dbUrl = "jdbc:mysql://localhost:3306/your_db_name";
        String dbUser = "your_db_username";
        String dbPassword = "your_db_password";
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Handle button click events and perform database operations
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertEmployee();
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmployee();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        // Set up the layout and add components to the JFrame
        // ...
    }

    private void insertEmployee() {
        String name = txtName.getText();
        String id = txtID.getText();
        int age = Integer.parseInt(txtAge.getText());
        String gender = txtGender.getText();
        int deptNo = Integer.parseInt(txtDeptNo.getText());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Employee (Name, ID, Age, Gender, DepartmentNo) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, gender);
            preparedStatement.setInt(5, deptNo);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee record inserted successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to insert employee record.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchEmployee() {
        // Implement search functionality to retrieve and display employee records based on ID
        // ...
    }

    private void updateEmployee() {
        // Implement update functionality to modify an existing employee record
        // ...
    }

    private void deleteEmployee() {
        // Implement delete functionality to remove a selected employee record
        // ...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagementApp().setVisible(true);
            }
        });
    }
}
    }
    
}
