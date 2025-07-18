// Ryan Monnier
// CSD 420 - Module 10
// 18-July-2025

// at a glance I really like swing. javaFX always seems to be such a headache

import java.awt.*; //layout manager
import java.sql.*;
import javax.swing.*;

public class FanEditor extends JFrame {

    // swing UI components
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;
    private JLabel statusLabel;

    // given creds
    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private final String USER = "student1";
    private final String PASS = "pass";

    public FanEditor() {
        super("Fan Editor");

        // swing layout seems way easier than dealing with HBox and VBox and all that
        setLayout(new GridLayout(6, 2, 5, 5)); //6 rows, 2 columns, 5px horizontal/vertical gaps

        // ID input
        add(new JLabel(" ID:"));
        idField = new JTextField(10);
        add(idField);

        // name inputs
        add(new JLabel(" First Name:"));
        firstNameField = new JTextField(25);
        add(firstNameField);
        add(new JLabel(" Last Name:"));
        lastNameField = new JTextField(25);
        add(lastNameField);

        // team
        add(new JLabel(" Favorite Team:"));
        favoriteTeamField = new JTextField(25);
        add(favoriteTeamField);

        // display/update buttons
        displayButton = new JButton("Display");
        updateButton = new JButton("Update");

        add(displayButton);
        add(updateButton);

        // status
        statusLabel = new JLabel(" ");
        add(statusLabel);

        // button actions
        displayButton.addActionListener(e -> displayFan());
        updateButton.addActionListener(e -> updateFan());

        // window settings
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayFan() {
        String idText = idField.getText().trim();

        // make sure theres an actual ID entered
        if (idText.isEmpty()) {
            statusLabel.setText("Please enter an ID.");
            return;
        }

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(idText));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
                statusLabel.setText("Record successfully loaded.");
            } else {
                statusLabel.setText("No record found.");
                firstNameField.setText("?? Invalid ??");
                lastNameField.setText("?? ID ??");
                favoriteTeamField.setText("?? Silly ??");
            }

            rs.close();
            ps.close();
        } catch (Exception ex) {
            statusLabel.setText("Error retrieving data.");
            ex.printStackTrace();
        }
    }

    private void updateFan() {
        String idText = idField.getText();
        String first = firstNameField.getText();
        String last = lastNameField.getText();
        String team = favoriteTeamField.getText();

        if (idText.isEmpty() || first.isEmpty() || last.isEmpty() || team.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String updateSQL = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(updateSQL);
            ps.setString(1, first);
            ps.setString(2, last);
            ps.setString(3, team);
            ps.setInt(4, Integer.parseInt(idText));

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                statusLabel.setText("Update successful.");
            } else {
                statusLabel.setText("Update failed. ID not found.");
            }

            ps.close();
        } catch (Exception ex) {
            statusLabel.setText("Error updating record.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FanEditor());
    }
}


// don't forget to compile with:
// javac -cp .:mysql-connector-j-9.3.0.jar FanEditor.java
// and run with:
// java -cp .:mysql-connector-j-9.3.0.jar FanEditor