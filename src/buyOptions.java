import javax.swing.*;
import java.awt.event.*;

public class buyOptions implements ActionListener {
    private JFrame frmBuyOptions = new JFrame("Buy The Selected Mobile");

    private JLabel backImage = new JLabel(new ImageIcon("imgs//capture.jpg"));

    private JTextField txtModelNo = new JTextField();

    private JButton btnModelNo = new JButton("Model Number");
    private JButton btnSeeSellers = new JButton("See Sellers");
    private JButton btnReset = new JButton("Reset");
    private JButton btnBack = new JButton("Back");

    public buyOptions() {
        frmBuyOptions.setResizable(false);
        frmBuyOptions.setBounds(100, 100, 450, 300);
        frmBuyOptions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBuyOptions.setLocationRelativeTo(null);

        frmBuyOptions.add(backImage);
        backImage.setLayout(null);

        txtModelNo.setBounds(240, 70, 140, 25);
        backImage.add(txtModelNo);
        txtModelNo.setColumns(10);
        txtModelNo.setVisible(false);

        btnModelNo.addActionListener(this);
        btnModelNo.setBounds(45, 70, 140, 28);
        backImage.add(btnModelNo);

        btnSeeSellers.setIcon(new ImageIcon("imgs//seller.png"));
        btnSeeSellers.addActionListener(this);
        btnSeeSellers.setBounds(20, 220, 150, 28);
        backImage.add(btnSeeSellers);

        btnReset.setIcon(new ImageIcon("imgs//reset.png"));
        btnReset.addActionListener(this);
        btnReset.setBounds(180, 220, 110, 28);
        backImage.add(btnReset);

        btnBack.setIcon(new ImageIcon("imgs//back.png"));
        btnBack.addActionListener(this);
        btnBack.setBounds(300, 220, 110, 28);
        backImage.add(btnBack);

        frmBuyOptions.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == btnBack) {
            frmBuyOptions.dispose();
            new search();
        }

        if (e.getSource() == btnModelNo) {
            txtModelNo.setVisible(true);
        }

        if (e.getSource() == btnReset) {
            txtModelNo.setText("");
            txtModelNo.setVisible(false);
        }

        if (e.getSource() == btnSeeSellers) {
            String retMobileID;
            retMobileID = txtModelNo.getText();
            new searchSeller(retMobileID);
        }
    }

}
