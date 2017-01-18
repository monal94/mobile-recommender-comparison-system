import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class searchResult {
    private JFrame frmResult = new JFrame("RESULT SET");

    static String connectionUrl = "jdbc:mysql://localhost:3306/test";
    static String dbUser = "root";
    static String dbPwd = "";

    static Connection conn;

    private ResultSet rs;

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

    public searchResult(String ModelNo, String Company) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frmResult.setSize(screenSize.width, screenSize.height);
        frmResult.setResizable(false);
        frmResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmResult.setLocationRelativeTo(null);

        Vector columnNames = new Vector();
        Vector data = new Vector();
        String sql;

        if(ModelNo.equals("") && !Company.equals(""))
            sql = "SELECT * FROM mobile WHERE COMPANY =  '" + Company + "'" ;

        else if(!ModelNo.equals("") && Company.equals(""))
            sql = "SELECT * FROM mobile WHERE MOBILE_ID =  '" + ModelNo + "'" ;

        else if(!ModelNo.equals("") && !Company.equals(""))
            sql = "SELECT * FROM mobile WHERE MOBILE_ID =  '" + ModelNo + "' AND COMPANY = '" + Company + "'" ;

        else
            sql = "SELECT * FROM mobile";

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }

            while (rs.next()) {
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
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frmResult.add(scrollPane);

        frmResult.setVisible(true);
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
