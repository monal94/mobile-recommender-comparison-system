import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.border.*;

public class addMobile implements ActionListener {
    private JFrame frmAddMobile = new JFrame("New Mobile Window");

    private JPanel backImage = new JPanel();

    private JLabel lblAddModel = new JLabel("Form to Add New Mobile");
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

    private JTextField txtMobileID = new JTextField();
    private JTextField txtName = new JTextField();
    private JTextField txtCompany = new JTextField();

    private JComboBox cbType = new JComboBox();

    private JTextField txtLaunchDate = new JTextField();
    private JTextField txtDispSize = new JTextField();
    private JTextField txtResolution = new JTextField();
    private JTextField txtOS = new JTextField();
    private JTextField txtCPU = new JTextField();
    private JTextField txtBattery = new JTextField();
    private JTextField txtMemory = new JTextField();
    private JTextField txtRAM = new JTextField();
    private JTextField txtCameraFront = new JTextField();
    private JTextField txtCameraBack = new JTextField();
    private JTextField txtBluetooth = new JTextField();

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

    public addMobile() {
        frmAddMobile.setResizable(false);
        frmAddMobile.setBounds(100, 100, 1200, 600);
        frmAddMobile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAddMobile.setLocationRelativeTo(null);

        frmAddMobile.add(backImage);
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

        txtMobileID.setColumns(20);
        txtMobileID.setBounds(160, 50, 150, 18);
        backImage.add(txtMobileID);

        txtName.setColumns(20);
        txtName.setBounds(160, 70, 150, 18);
        backImage.add(txtName);

        txtCompany.setColumns(20);
        txtCompany.setBounds(160, 90, 150, 18);
        backImage.add(txtCompany);

        final DefaultComboBoxModel type = new DefaultComboBoxModel();
        type.addElement("");
        type.addElement("Smart Phone");
        type.addElement("Multimedia Phone");
        type.addElement("Feature Phone");
        cbType = new JComboBox(type);
        cbType.setSelectedIndex(0);
        cbType.setBounds(160, 110, 150, 18);
        backImage.add(cbType);

        txtLaunchDate.setColumns(20);
        txtLaunchDate.setBounds(160, 130, 150, 18);
        backImage.add(txtLaunchDate);

        txtDispSize.setColumns(20);
        txtDispSize.setBounds(160, 150, 150, 18);
        backImage.add(txtDispSize);

        txtResolution.setColumns(20);
        txtResolution.setBounds(160, 170, 150, 18);
        backImage.add(txtResolution);

        txtOS.setColumns(20);
        txtOS.setBounds(160, 190, 150, 18);
        backImage.add(txtOS);

        txtCPU.setColumns(20);
        txtCPU.setBounds(160, 210, 150, 18);
        backImage.add(txtCPU);

        txtMemory.setColumns(20);
        txtMemory.setBounds(160, 230, 150, 18);
        backImage.add(txtMemory);

        txtRAM.setColumns(20);
        txtRAM.setBounds(160, 250, 150, 18);
        backImage.add(txtRAM);

        txtCameraFront.setColumns(20);
        txtCameraFront.setBounds(160, 270, 150, 18);
        backImage.add(txtCameraFront);

        txtCameraBack.setColumns(20);
        txtCameraBack.setBounds(160, 290, 150, 18);
        backImage.add(txtCameraBack);

        txtBattery.setColumns(20);
        txtBattery.setBounds(160, 310, 150, 18);
        backImage.add(txtBattery);

        txtBluetooth.setColumns(20);
        txtBluetooth.setBounds(160, 330, 150, 18);
        backImage.add(txtBluetooth);

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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane ScrollPane2 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScrollPane2.setBounds(380, 50, 800, 500);
        table.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        refreshTable();
        backImage.add(ScrollPane2);

        frmAddMobile.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            Statement stmt = conn.createStatement();

            String MobileID = txtMobileID.getText();
            String Name = txtName.getText();
            String Company = txtCompany.getText();
            String Type = (String) cbType.getSelectedItem();
            String LaunchDate = txtLaunchDate.getText();
            String DispSize = txtDispSize.getText();
            String Resolution = txtResolution.getText();
            String OS = txtOS.getText();
            String CPU = txtCPU.getText();
            String Memory = txtMemory.getText();
            String RAM = txtRAM.getText();
            String CameraFront = txtCameraFront.getText();
            String CameraBack = txtCameraBack.getText();
            String Battery = txtBattery.getText();
            String Bluetooth = txtBluetooth.getText();

            if (e.getSource() == btnReset) {
                resetAll();
            } else if (e.getSource() == btnBack) {
                frmAddMobile.dispose();
                new devOptions();
            } else if (MobileID.isEmpty())
                JOptionPane.showMessageDialog(null, "Mobile ID cannot be blank!", "ERROR!!!", JOptionPane.ERROR_MESSAGE);

            else if (e.getSource() == btnSubmit) {
                stmt.executeUpdate("INSERT INTO mobile VALUES('" + MobileID + "','" + Name + "','" + Company + "','" + Type + "','" + LaunchDate + "','" + DispSize + "', '" + Resolution + "','" + OS + "','" + CPU + "','" + Memory + "','" + RAM + "','" + CameraFront + "','" + CameraBack + "','" + Battery + "','" + Bluetooth + "')");

                JOptionPane.showMessageDialog(null, "Successfully inserted into the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
                resetAll();

            } else if (e.getSource() == btnModify) {
                String str = "UPDATE mobile SET NAME=?, COMPANY=?, TYPE=?,LAUNCH_DATE=?, DISP_SIZE=?, RESOLUTION=?, OS=?, CPU=?, MEMORY=?, RAM=?, CAMERA_FRONT=?, CAMERA_BACK=?, BATTERY=?, BLUETOOTH=? WHERE MOBILE_ID=?";

                PreparedStatement psmt = conn.prepareStatement(str);

                psmt.setString(1, Name);
                psmt.setString(2, Company);
                psmt.setString(3, Type);
                psmt.setString(4, LaunchDate);
                psmt.setString(5, DispSize);
                psmt.setString(6, Resolution);
                psmt.setString(7, OS);
                psmt.setString(8, CPU);
                psmt.setString(9, Memory);
                psmt.setString(10, RAM);
                psmt.setString(11, CameraFront);
                psmt.setString(12, CameraBack);
                psmt.setString(13, Battery);
                psmt.setString(14, Bluetooth);
                psmt.setString(15, MobileID);

                psmt.executeUpdate();


                JOptionPane.showMessageDialog(null, "Successfully modified into the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
                resetAll();

            } else if (e.getSource() == btnSearch) {
                rs = stmt.executeQuery("SELECT * FROM mobile WHERE MOBILE_ID= '" + MobileID + "'");

                if (rs.next()) {
                    Name = rs.getString("NAME");
                    Company = rs.getString("COMPANY");
                    Type = rs.getString("TYPE");
                    LaunchDate = rs.getString("LAUNCH_DATE");
                    DispSize = rs.getString("DISP_SIZE");
                    Resolution = rs.getString("RESOLUTION");
                    OS = rs.getString("OS");
                    CPU = rs.getString("CPU");
                    Memory = rs.getString("MEMORY");
                    RAM = rs.getString("RAM");
                    CameraFront = rs.getString("CAMERA_FRONT");
                    CameraBack = rs.getString("CAMERA_BACK");
                    Battery = rs.getString("BATTERY");
                    Bluetooth = rs.getString("BLUETOOTH");

                    txtName.setText(Name);
                    txtCompany.setText(Company);
                    cbType.setSelectedItem(Type);
                    txtLaunchDate.setText(LaunchDate);
                    txtDispSize.setText(DispSize);
                    txtResolution.setText(Resolution);
                    txtOS.setText(OS);
                    txtCPU.setText(CPU);
                    txtMemory.setText(Memory);
                    txtRAM.setText(RAM);
                    txtCameraFront.setText(CameraFront);
                    txtCameraBack.setText(CameraBack);
                    txtBattery.setText(Battery);
                    txtBluetooth.setText(Bluetooth);
                }

                JOptionPane.showMessageDialog(null, "Successfully retrieved from the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == btnDelete) {
                stmt.executeUpdate("DELETE from mobile where MOBILE_ID='" + MobileID + "'");

                JOptionPane.showMessageDialog(null, "Successfully deleted from the database", "Success!!!", JOptionPane.INFORMATION_MESSAGE);
                resetAll();
            }

            if (conn != null) {
                conn.close();
                conn = null;
            }
            refreshTable();
        } catch (SQLException sqle) {
            System.out.println("SQL Exception thrown: " + sqle);
        }
    }

    public void resetAll() {
        txtMobileID.setText("");
        txtName.setText("");
        txtCompany.setText("");
        cbType.setSelectedIndex(0);
        txtLaunchDate.setText("");
        txtDispSize.setText("");
        txtResolution.setText("");
        txtOS.setText("");
        txtCPU.setText("");
        txtMemory.setText("");
        txtRAM.setText("");
        txtCameraFront.setText("");
        txtCameraBack.setText("");
        txtBattery.setText("");
        txtBluetooth.setText("");
    }

    public void refreshTable() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM mobile");

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