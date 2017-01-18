import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.border.*;

public class advancedSearch implements ActionListener {
    private JFrame frmAdvancedSearch = new JFrame("Search Mobile Window");

    private JPanel backImage = new JPanel();

    private JLabel lblAddModel = new JLabel("Form to Search Mobile");
    private JLabel lblMobileID = new JLabel("Mobile ID");
    private JLabel lblName = new JLabel("Name");
    private JLabel lblCompany = new JLabel("Company");
    private JLabel lblType = new JLabel("Type");
    private JLabel lblLaunchDate = new JLabel("Launch Date");
    private JLabel lblDispSize = new JLabel("Display Size");
    private JLabel lblResolution = new JLabel("Resolution");
    private JLabel lblOS = new JLabel("OS");
    private JLabel lblCPU = new JLabel("CPU");
    private JLabel lblMemory = new JLabel("Memory");
    private JLabel lblRAM = new JLabel("RAM");
    private JLabel lblCameraFront = new JLabel("Camera (Front)");
    private JLabel lblCameraBack = new JLabel("Camera (Back)");
    private JLabel lblBattery = new JLabel("Battery");
    private JLabel lblBluetooth = new JLabel("Bluetooth");

    private JComboBox cbMobileID = new JComboBox();
    private JComboBox cbName = new JComboBox();
    private JComboBox cbCompany = new JComboBox();
    private JComboBox cbType = new JComboBox();
    private JComboBox cbLaunchDate = new JComboBox();
    private JComboBox cbDispSize = new JComboBox<>();
    private JComboBox cbResolution = new JComboBox();
    private JComboBox cbOS = new JComboBox();
    private JComboBox cbCPU = new JComboBox();
    private JComboBox cbBattery = new JComboBox();
    private JComboBox cbMemory = new JComboBox();
    private JComboBox cbRAM = new JComboBox();
    private JComboBox cbCameraFront = new JComboBox();
    private JComboBox cbCameraBack = new JComboBox();
    private JComboBox cbBluetooth = new JComboBox();

    private JButton btnBack = new JButton("Back");
    private JButton btnSearch = new JButton("Search");
    private JButton btnReset = new JButton("Reset");

    Vector<String> MobileID = new Vector();
    Vector<String> Name = new Vector();
    Vector<String> Company = new Vector();
    Vector<String> Type = new Vector();
    Vector<String> LaunchDate = new Vector();
    Vector<String> DispSize = new Vector();
    Vector<String> Resolution = new Vector();
    Vector<String> OS = new Vector();
    Vector<String> CPU = new Vector();
    Vector<String> Memory = new Vector();
    Vector<String> RAM = new Vector();
    Vector<String> CameraFront = new Vector();
    Vector<String> CameraBack = new Vector();
    Vector<String> Battery = new Vector();
    Vector<String> Bluetooth = new Vector();

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

    public advancedSearch() {
        frmAdvancedSearch.setResizable(false);
        frmAdvancedSearch.setBounds(100, 100, 1200, 600);
        frmAdvancedSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdvancedSearch.setLocationRelativeTo(null);

        frmAdvancedSearch.add(backImage);
        backImage.setLayout(null);

        lblAddModel.setFont(new Font("ROBOTO", Font.BOLD, 16));
        lblAddModel.setBounds(140, 11, 220, 31);
        backImage.add(lblAddModel);

        lblMobileID.setBounds(50, 50, 100, 20);
        backImage.add(lblMobileID);

        lblName.setBounds(50, 70, 100, 20);
        backImage.add(lblName);

        lblCompany.setBounds(50, 90, 100, 20);
        backImage.add(lblCompany);

        lblType.setBounds(50, 110, 100, 20);
        backImage.add(lblType);

        lblLaunchDate.setBounds(50, 130, 100, 20);
        backImage.add(lblLaunchDate);

        lblDispSize.setBounds(50, 150, 100, 20);
        backImage.add(lblDispSize);

        lblResolution.setBounds(50, 170, 100, 20);
        backImage.add(lblResolution);

        lblOS.setBounds(50, 190, 100, 20);
        backImage.add(lblOS);

        lblCPU.setBounds(50, 210, 100, 20);
        backImage.add(lblCPU);

        lblMemory.setBounds(50, 230, 100, 20);
        backImage.add(lblMemory);

        lblRAM.setBounds(50, 250, 100, 20);
        backImage.add(lblRAM);

        lblCameraFront.setBounds(50, 270, 100, 20);
        backImage.add(lblCameraFront);

        lblCameraBack.setBounds(50, 290, 100, 20);
        backImage.add(lblCameraBack);

        lblBattery.setBounds(50, 310, 100, 20);
        backImage.add(lblBattery);

        lblBluetooth.setBounds(50, 330, 100, 20);
        backImage.add(lblBluetooth);

        try {
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            Statement stmt = conn.createStatement();

            {
                rs = stmt.executeQuery("SELECT DISTINCT MOBILE_ID FROM mobile");
                MobileID.add("");
                while (rs.next()) {
                    MobileID.add(rs.getString("MOBILE_ID"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT NAME FROM mobile");
                Name.add("");
                while (rs.next()) {
                    Name.add(rs.getString("NAME"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT COMPANY FROM mobile");
                Company.add("");
                while (rs.next()) {
                    Company.add(rs.getString("COMPANY"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT TYPE FROM mobile");
                Type.add("");
                while (rs.next()) {
                    Type.add(rs.getString("TYPE"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT LAUNCH_DATE FROM mobile");
                LaunchDate.add("");
                while (rs.next()) {
                    LaunchDate.add(rs.getString("LAUNCH_DATE"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT DISP_SIZE FROM mobile");
                DispSize.add("");
                while (rs.next()) {
                    DispSize.add(rs.getString("DISP_SIZE"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT RESOLUTION FROM mobile");
                Resolution.add("");
                while (rs.next()) {
                    Resolution.add(rs.getString("RESOLUTION"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT OS FROM mobile");
                OS.add("");
                while (rs.next()) {
                    OS.add(rs.getString("OS"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT CPU FROM mobile");
                CPU.add("");
                while (rs.next()) {
                    CPU.add(rs.getString("CPU"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT MEMORY FROM mobile");
                Memory.add("");
                while (rs.next()) {
                    Memory.add(rs.getString("MEMORY"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT RAM FROM mobile");
                RAM.add("");
                while (rs.next()) {
                    RAM.add(rs.getString("RAM"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT CAMERA_FRONT FROM mobile");
                CameraFront.add("");
                while (rs.next()) {
                    CameraFront.add(rs.getString("CAMERA_FRONT"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT CAMERA_BACK FROM mobile");
                CameraBack.add("");
                while (rs.next()) {
                    CameraBack.add(rs.getString("CAMERA_BACK"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT BATTERY FROM mobile");
                Battery.add("");
                while (rs.next()) {
                    Battery.add(rs.getString("BATTERY"));
                }
            }

            {
                rs = stmt.executeQuery("SELECT DISTINCT BLUETOOTH FROM mobile");
                Bluetooth.add("");
                while (rs.next()) {
                    Bluetooth.add(rs.getString("BLUETOOTH"));
                }
            }

            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException sqle) {
            System.out.println("SQL Exception thrown: " + sqle);
        }

        cbMobileID = new JComboBox(MobileID);
        cbName = new JComboBox(Name);
        cbCompany = new JComboBox(Company);
        cbType = new JComboBox(Type);
        cbLaunchDate = new JComboBox(LaunchDate);
        cbDispSize = new JComboBox(DispSize);
        cbResolution = new JComboBox(Resolution);
        cbOS = new JComboBox(OS);
        cbCPU = new JComboBox(CPU);
        cbMemory = new JComboBox(Memory);
        cbRAM = new JComboBox(RAM);
        cbCameraFront = new JComboBox(CameraFront);
        cbCameraBack = new JComboBox(CameraBack);
        cbBattery = new JComboBox(Battery);
        cbBluetooth = new JComboBox(Bluetooth);

        cbMobileID.setBounds(160, 50, 150, 18);
        backImage.add(cbMobileID);

        cbName.setBounds(160, 70, 150, 18);
        backImage.add(cbName);

        cbCompany.setBounds(160, 90, 150, 18);
        backImage.add(cbCompany);

        cbType.setBounds(160, 110, 150, 18);
        backImage.add(cbType);

        cbLaunchDate.setBounds(160, 130, 150, 18);
        backImage.add(cbLaunchDate);

        cbDispSize.setBounds(160, 150, 150, 18);
        backImage.add(cbDispSize);

        cbResolution.setBounds(160, 170, 150, 18);
        backImage.add(cbResolution);

        cbOS.setBounds(160, 190, 150, 18);
        backImage.add(cbOS);

        cbCPU.setBounds(160, 210, 150, 18);
        backImage.add(cbCPU);

        cbMemory.setBounds(160, 230, 150, 18);
        backImage.add(cbMemory);

        cbRAM.setBounds(160, 250, 150, 18);
        backImage.add(cbRAM);

        cbCameraFront.setBounds(160, 270, 150, 18);
        backImage.add(cbCameraFront);

        cbCameraBack.setBounds(160, 290, 150, 18);
        backImage.add(cbCameraBack);

        cbBattery.setBounds(160, 310, 150, 18);
        backImage.add(cbBattery);

        cbBluetooth.setBounds(160, 330, 150, 18);
        backImage.add(cbBluetooth);

        btnBack.setIcon(new ImageIcon("imgs\\back.png"));
        btnBack.addActionListener(this);
        btnBack.setBounds(10, 11, 89, 23);
        backImage.add(btnBack);

        btnSearch.setIcon(new ImageIcon("imgs\\search.gif"));
        btnSearch.addActionListener(this);
        btnSearch.setBounds(120, 450, 120, 40);
        backImage.add(btnSearch);

        btnReset.setIcon(new ImageIcon("imgs\\reset.png"));
        btnReset.addActionListener(this);
        btnReset.setBounds(120, 510, 120, 40);
        backImage.add(btnReset);

        table = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane ScrollPane2 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScrollPane2.setBounds(380, 50, 800, 500);
        table.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        refreshTable();
        backImage.add(ScrollPane2);

        frmAdvancedSearch.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnReset) {
                resetAll();
            } else if (e.getSource() == btnBack) {
                frmAdvancedSearch.dispose();
                new search();
            } else if (e.getSource() == btnSearch) {
                refreshTable();
                JOptionPane.showMessageDialog(null, "Successfully searched from the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
            }

            if (conn != null) {
                conn.close();
                conn = null;
            }

        } catch (SQLException sqle) {
            System.out.println("SQL Exception thrown: " + sqle);
        }
    }

    public void resetAll() {
        cbMobileID.setSelectedIndex(0);
        cbName.setSelectedIndex(0);
        cbCompany.setSelectedIndex(0);
        cbType.setSelectedIndex(0);
        cbLaunchDate.setSelectedIndex(0);
        cbDispSize.setSelectedIndex(0);
        cbResolution.setSelectedIndex(0);
        cbOS.setSelectedIndex(0);
        cbCPU.setSelectedIndex(0);
        cbMemory.setSelectedIndex(0);
        cbRAM.setSelectedIndex(0);
        cbCameraFront.setSelectedIndex(0);
        cbCameraBack.setSelectedIndex(0);
        cbBattery.setSelectedIndex(0);
        cbBluetooth.setSelectedIndex(0);
    }

    public void refreshTable() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            Statement stmt = conn.createStatement();
            String sql;

            String rtMobileID = (String) cbMobileID.getSelectedItem();
            String rtName = (String) cbName.getSelectedItem();
            String rtCompany = (String) cbCompany.getSelectedItem();
            String rtType = (String) cbType.getSelectedItem();
            String rtLaunchDate = (String) cbLaunchDate.getSelectedItem();
            String rtDispSize = (String) cbDispSize.getSelectedItem();
            String rtResolution = (String) cbResolution.getSelectedItem();
            String rtOS = (String) cbOS.getSelectedItem();
            String rtCPU = (String) cbCPU.getSelectedItem();
            String rtMemory = (String) cbMemory.getSelectedItem();
            String rtRAM = (String) cbRAM.getSelectedItem();
            String rtCameraFront = (String) cbCameraFront.getSelectedItem();
            String rtCameraBack = (String) cbCameraBack.getSelectedItem();
            String rtBattery = (String) cbBattery.getSelectedItem();
            String rtBluetooth = (String) cbBluetooth.getSelectedItem();

            if (rtMobileID.equals(""))
                rtMobileID = "%";

            if (rtName.equals(""))
                rtName = "%";

            if (rtCompany.equals(""))
                rtCompany = "%";

            if (rtType.equals(""))
                rtType = "%";

            if (rtLaunchDate.equals(""))
                rtLaunchDate = "%";

            if (rtDispSize.equals(""))
                rtDispSize = "%";

            if (rtResolution.equals(""))
                rtResolution = "%";

            if (rtOS.equals(""))
                rtOS = "%";

            if (rtCPU.equals(""))
                rtCPU = "%";

            if (rtMemory.equals(""))
                rtMemory = "%";

            if (rtRAM.equals(""))
                rtRAM = "%";

            if (rtCameraFront.equals(""))
                rtCameraFront = "%";

            if (rtCameraBack.equals(""))
                rtCameraBack = "%";

            if (rtBattery.equals(""))
                rtBattery = "%";

            if (rtBluetooth.equals(""))
                rtBluetooth = "%";

            sql = "SELECT * FROM mobile WHERE MOBILE_ID LIKE '" + rtMobileID + "' AND NAME LIKE '" + rtName + "' AND COMPANY LIKE '" + rtCompany + "' AND TYPE LIKE '" + rtType + "' AND LAUNCH_DATE LIKE '" + rtLaunchDate + "' AND DISP_SIZE LIKE '" + rtDispSize + "' AND RESOLUTION LIKE '" + rtResolution + "' AND OS LIKE '" + rtOS + "' AND CPU LIKE '" + rtCPU + "'AND MEMORY LIKE '" + rtMemory + "' AND RAM LIKE '" + rtRAM + "' AND CAMERA_FRONT LIKE '" + rtCameraFront + "' AND CAMERA_BACK LIKE '" + rtCameraBack + "' AND BATTERY LIKE '" + rtBattery + "' AND BLUETOOTH LIKE '" + rtBluetooth + "' ";

            rs = stmt.executeQuery(sql);

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

        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            tableColumn.setMinWidth(100);
        }
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