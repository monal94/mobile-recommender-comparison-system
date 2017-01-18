import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class searchSeller implements ActionListener {

    private JFrame frmSearchSeller = new JFrame("RESULT SET");

    private JLabel lblSellers = new JLabel("Please Select the Seller ID corresponding to favourable seller");

    private JButton btnSelectSeller = new JButton("Select Seller");

    private JComboBox cbSellers;

    private Vector<String> Seller = new Vector();

    static String connectionUrl = "jdbc:mysql://localhost:3306/test";
    static String dbUser = "root";
    static String dbPwd = "";
    private String inModelNo;

    static Connection conn;

    private ResultSet rs;
    private ResultSet rsTemp;

    private JTable table;

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

    public searchSeller(String ModelNo) {
        inModelNo = ModelNo;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frmSearchSeller.setSize(screenSize.width, screenSize.height);
        frmSearchSeller.setResizable(false);
        frmSearchSeller.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchSeller.setLocationRelativeTo(null);

        lblSellers.setBounds(400, 700, 550, 25);
        lblSellers.setFont(new Font("ROBOTO", Font.BOLD, 15));
        frmSearchSeller.add(lblSellers);

        btnSelectSeller.setBounds(550, 652, 140, 25);
        btnSelectSeller.addActionListener(this);
        frmSearchSeller.add(btnSelectSeller);

        Vector columnNames = new Vector();
        Vector data = new Vector();

        String sql;

        if (ModelNo.equals(""))
            sql = "SELECT * FROM sells NATURAL JOIN seller";

        else
            sql = "SELECT * FROM sells NATURAL JOIN seller WHERE sells.MOBILE_ID =  '" + ModelNo + "' ";

        try {

            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rsTemp = rs;

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }

            Seller.add("Select");

            while (rs.next()) {
                Seller.add(rsTemp.getString("SELLER_ID"));
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));

                }

                data.addElement(row);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        cbSellers = new JComboBox(Seller);
        cbSellers.setBounds(400, 650, 140, 28);
        frmSearchSeller.add(cbSellers);

        table = new JTable(data, columnNames) {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frmSearchSeller.add(scrollPane);

        frmSearchSeller.setVisible(true);
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSelectSeller) {
            frmSearchSeller.dispose();
            String retSeller;

            retSeller = (String) cbSellers.getSelectedItem();
            new searchFinal(inModelNo, retSeller);

        }
    }

}
