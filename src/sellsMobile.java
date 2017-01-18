import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.border.*;

public class sellsMobile implements ActionListener {
    private JFrame frmAddSeller = new JFrame("New Seller Window");

    private JPanel backImage = new JPanel();

    private JLabel lblAddSeller = new JLabel("Form To Add Mobile To Selling List");
    private JLabel lblSellerID = new JLabel("Seller ID");
    private JLabel lblMobileID = new JLabel("Mobile ID");
    private JLabel lblPrice = new JLabel("Price");

    private JTextField txtSellerID = new JTextField();
    private JTextField txtMobileID = new JTextField();
    private JTextField txtPrice = new JTextField();

    private JButton btnBack = new JButton("Back");
    private JButton btnSubmit = new JButton("Submit");
    private JButton btnModify = new JButton("Modify");
    private JButton btnSearch = new JButton("Search");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnReset = new JButton("Reset");

    private JTable table;

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

    public sellsMobile() {
        frmAddSeller.setResizable(false);
        frmAddSeller.setBounds(100, 100, 1200, 600);
        frmAddSeller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAddSeller.setLocationRelativeTo(null);

        frmAddSeller.add(backImage);
        backImage.setLayout(null);

        lblAddSeller.setFont(new Font("ROBOTO", Font.BOLD, 16));
        lblAddSeller.setBounds(140, 11, 300, 31);
        backImage.add(lblAddSeller);

        lblSellerID.setBounds(53, 70, 100, 20);
        backImage.add(lblSellerID);

        lblMobileID.setBounds(53, 100, 100, 20);
        backImage.add(lblMobileID);

        lblPrice.setBounds(53, 130, 100, 20);
        backImage.add(lblPrice);

        txtSellerID.setColumns(150);
        txtSellerID.setBounds(160, 70, 180, 20);
        backImage.add(txtSellerID);

        txtMobileID.setColumns(150);
        txtMobileID.setBounds(160, 100, 180, 20);
        backImage.add(txtMobileID);

        txtPrice.setColumns(150);
        txtPrice.setBounds(160, 130, 180, 20);
        backImage.add(txtPrice);

        btnBack.setForeground(Color.BLUE);
        btnBack.setIcon(new ImageIcon("imgs\\back.png"));
        btnBack.addActionListener(this);
        btnBack.setBounds(10, 11, 89, 23);
        backImage.add(btnBack);

        btnSubmit.setIcon(new ImageIcon("imgs\\submit.gif"));
        btnSubmit.addActionListener(this);
        btnSubmit.setBounds(135, 390, 120, 40);
        backImage.add(btnSubmit);

        btnModify.setIcon(new ImageIcon("imgs\\modify.png"));
        btnModify.addActionListener(this);
        btnModify.setBounds(60, 450, 120, 40);
        backImage.add(btnModify);

        btnSearch.setIcon(new ImageIcon("imgs\\search.gif"));
        btnSearch.addActionListener(this);
        btnSearch.setBounds(210, 450, 120, 40);
        backImage.add(btnSearch);

        btnDelete.setIcon(new ImageIcon("imgs\\delete.png"));
        btnDelete.addActionListener(this);
        btnDelete.setBounds(60, 510, 120, 40);
        backImage.add(btnDelete);

        btnReset.setIcon(new ImageIcon("imgs\\reset.png"));
        btnReset.addActionListener(this);
        btnReset.setBounds(210, 510, 120, 40);
        backImage.add(btnReset);

        table = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane ScrollPane3 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScrollPane3.setBounds(380, 50, 800, 500);
        table.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        refreshTable();
        backImage.add(ScrollPane3);

        frmAddSeller.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            Statement stmt = conn.createStatement();

            String SellerID = txtSellerID.getText();
            String MobileID = txtMobileID.getText();
            String Price = txtPrice.getText();

            if (e.getSource() == btnReset) {
                resetAll();
            } else if (e.getSource() == btnBack) {
                frmAddSeller.dispose();
                new SellerPage();
            } else if (SellerID.isEmpty() && MobileID.isEmpty())
                JOptionPane.showMessageDialog(null, "Seller ID cannot be blank!", "ERROR!!!", JOptionPane.ERROR_MESSAGE);

            else if (e.getSource() == btnSubmit) {
                stmt.executeUpdate("INSERT INTO sells VALUES('" + SellerID + "','" + MobileID + "','" + Price + "')");

                JOptionPane.showMessageDialog(null, "Successfully inserted into the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
                resetAll();
            } else if (e.getSource() == btnModify) {

                String str = "UPDATE sells SET PRICE=? WHERE SELLER_ID=? AND MOBILE_ID=?";

                PreparedStatement psmt = conn.prepareStatement(str);

                psmt.setString(1, Price);
                psmt.setString(2, SellerID);
                psmt.setString(3, MobileID);

                psmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully modified into the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
                resetAll();
            } else if (e.getSource() == btnSearch) {
                rs = stmt.executeQuery("SELECT * FROM sells WHERE SELLER_ID= '" + SellerID + "' AND MOBILE_ID = '" + MobileID + "'");

                if (rs.next()) {
                    Price = rs.getString("PRICE");
                    txtPrice.setText(Price);
                }

                JOptionPane.showMessageDialog(null, "Successfully retrieved from the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            } else if (e.getSource() == btnDelete) {
                stmt.executeUpdate("DELETE from sells where MOBILE_ID='" + MobileID + "'");

                JOptionPane.showMessageDialog(null, "Successfully deleted from the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
                resetAll();
            } else if (conn != null) {
                conn.close();
                conn = null;
            }
            refreshTable();
        } catch (SQLException sqle) {
            System.out.println("SQL Exception thrown: " + sqle);
        }
    }


    public void resetAll() {
        txtSellerID.setText("");
        txtMobileID.setText("");
        txtPrice.setText("");
    }

    public void refreshTable() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM sells");

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                model.addColumn(md.getColumnName(i));
            }

            while (rs.next()) {
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }
                model.addRow(row);
            }

            conn.close();
        } catch (Exception e) {
        }
        table.setModel(model);
    }

    private static class HeaderRenderer implements TableCellRenderer {

        DefaultTableCellRenderer renderer;

        public HeaderRenderer(JTable table) {
            renderer = (DefaultTableCellRenderer)
                    table.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col);
        }
    }
}
