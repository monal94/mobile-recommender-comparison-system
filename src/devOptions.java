import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class devOptions {
    private JFrame frmDevOptions = new JFrame("Developer Options");
    private JLabel backImage = new JLabel(new ImageIcon("imgs\\developer.jpg"));
    private JLabel lblWelcome = new JLabel("WELCOME TO");
    private JButton btnAddNewModel = new JButton("ADD/EDIT MOBILE");
    private JButton btnSignOut = new JButton("SIGN OUT!");
    private JButton btnAddSeller = new JButton("ADD/EDIT SELLER");

    public devOptions() {
        frmDevOptions.setResizable(false);
        frmDevOptions.setBounds(100, 100, 500, 300);
        frmDevOptions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDevOptions.setLocationRelativeTo(null);

        frmDevOptions.add(backImage);
        backImage.setLayout(null);

        lblWelcome.setFont(new Font("CALIBRI", Font.CENTER_BASELINE, 38));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setBounds(105, 75, 400, 50);
        backImage.add(lblWelcome);

        btnAddNewModel.setIcon(new ImageIcon("imgs\\addmobile.png"));
        btnAddNewModel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmDevOptions.dispose();
                new addMobile();
            }
        });
        btnAddNewModel.setBounds(60, 180, 170, 40);
        backImage.add(btnAddNewModel);

        btnAddSeller.setIcon(new ImageIcon("imgs\\addseller.png"));
        btnAddSeller.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmDevOptions.dispose();
                new addSeller();
            }
        });
        btnAddSeller.setBounds(260, 180, 170, 40);
        backImage.add(btnAddSeller);

        btnSignOut.setIcon(new ImageIcon("imgs\\signout.png"));
        btnSignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmDevOptions.dispose();
                new devLogin();
            }
        });
        btnSignOut.setBounds(15, 15, 125, 30);
        backImage.add(btnSignOut);

        frmDevOptions.setVisible(true);
    }
}
