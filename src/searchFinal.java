import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class searchFinal {
    private JFrame frmSearchFinal = new JFrame("RESULT SET");

    private Vector<String> Seller = new Vector();

    static String connectionUrl = "jdbc:mysql://localhost:3306/test";
    static String dbUser = "root";
    static String dbPwd = "";

    private String modelNO;

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

    public searchFinal(String ModelNo, String Seller) {
        modelNO = ModelNo;
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frmSearchFinal.setSize(screenSize.width, screenSize.height);
        frmSearchFinal.setResizable(false);
        frmSearchFinal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchFinal.setLocationRelativeTo(null);

        Vector columnNames = new Vector();
        Vector data = new Vector();
        String sql;

        sql = "SELECT * FROM (sells NATURAL JOIN seller) INNER JOIN mobile ON sells.MOBILE_ID = mobile.MOBILE_ID WHERE sells.MOBILE_ID = '" + ModelNo + "' and sells.SELLER_ID =  '" + Seller + "'";

        try {

            Statement stmt = conn.createStatement();
            
            rs = stmt.executeQuery(sql);
            rsTemp = rs;
            
            ResultSetMetaData md = rs.getMetaData();
            
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }
            
            this.Seller.add("Select");

            while (rs.next()) {
                this.Seller.add(rsTemp.getString("SELLER_ID"));
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


        table = new JTable(data, columnNames) {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.getTableHeader().setResizingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            tableColumn.setMinWidth(100);
        }

        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frmSearchFinal.add(scrollPane);

        frmSearchFinal.setVisible(true);
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
