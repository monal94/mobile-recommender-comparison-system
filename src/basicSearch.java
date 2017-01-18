import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class basicSearch implements ActionListener {
    private JFrame frmBasicSearch = new JFrame("Search by Model or Company");

    private JLabel backImage = new JLabel(new ImageIcon("imgs//capture.jpg"));
    private JLabel lblSearch = new JLabel("Search By");

    private JTextField txtSearchNo = new JTextField();

    private JComboBox cbSearchCompany;

    private JButton btnSearchNo = new JButton("Model Number");
    private JButton btnSearchCompany = new JButton("Company");
    private JButton btnSearch = new JButton("Search");
    private JButton btnReset = new JButton("Reset");
    private JButton btnBack = new JButton("Back");

    private Vector<String> Company = new Vector();

    static String connectionUrl = "jdbc:mysql://localhost:3306/test";
    static String dbUser = "root";
    static String dbPwd = "";

    static Connection conn;

    private ResultSet rs;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException cnf) {
            System.out.println("Driver could not be loaded: " + cnf);
        }
    }

    public basicSearch() {
        frmBasicSearch.setResizable(false);
        frmBasicSearch.setBounds(100, 100, 450, 300);
        frmBasicSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBasicSearch.setLocationRelativeTo(null);

        frmBasicSearch.add(backImage);
        backImage.setLayout(null);

        lblSearch.setBounds(160, 10, 150, 25);
        lblSearch.setFont(new Font("ROBOTO", Font.BOLD, 25));
        backImage.add(lblSearch);

        txtSearchNo.setBounds(240, 70, 140, 25);
        backImage.add(txtSearchNo);
        txtSearchNo.setColumns(10);
        txtSearchNo.setVisible(false);

        try {
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            Statement stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT DISTINCT COMPANY FROM mobile");

            Company.add("");

            while (rs.next()) {
                Company.add(rs.getString("COMPANY"));
            }

            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQL Exception thrown: " + sqle);
        }

        cbSearchCompany = new JComboBox(Company);
        cbSearchCompany.setBounds(240, 120, 140, 25);
        backImage.add(cbSearchCompany);
        cbSearchCompany.setVisible(false);

        btnSearchNo.addActionListener(this);
        btnSearchNo.setBounds(45, 70, 140, 28);
        backImage.add(btnSearchNo);

        btnSearchCompany.addActionListener(this);
        btnSearchCompany.setBounds(45, 120, 140, 28);
        backImage.add(btnSearchCompany);

        btnSearch.setIcon(new ImageIcon("imgs//search.gif"));
        btnSearch.addActionListener(this);
        btnSearch.setBounds(50, 220, 110, 28);
        backImage.add(btnSearch);

        btnReset.setIcon(new ImageIcon("imgs//reset.png"));
        btnReset.addActionListener(this);
        btnReset.setBounds(170, 220, 110, 28);
        backImage.add(btnReset);

        btnBack.setIcon(new ImageIcon("imgs//back.png"));
        btnBack.addActionListener(this);
        btnBack.setBounds(290, 220, 110, 28);
        backImage.add(btnBack);

        frmBasicSearch.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == btnBack) {
            frmBasicSearch.dispose();
            new search();
        }


        if (e.getSource() == btnSearchNo) {
            txtSearchNo.setVisible(true);
        }

        if (e.getSource() == btnSearchCompany) {
            cbSearchCompany.setVisible(true);
        }

        if (e.getSource() == btnReset) {
            cbSearchCompany.setSelectedIndex(0);
            txtSearchNo.setText("");
            cbSearchCompany.setVisible(false);
            txtSearchNo.setVisible(false);
        }

        if (e.getSource() == btnSearch) {
            String retMobileID;
            String retCompany;
            retMobileID = txtSearchNo.getText();
            retCompany = (String) cbSearchCompany.getSelectedItem();
            new searchResult(retMobileID, retCompany);
        }
    }

}
