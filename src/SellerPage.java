import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SellerPage {
    private JFrame frmSellerPage = new JFrame("SELLER Options");
    private JLabel backImage = new JLabel();
    private JLabel lblWelcome = new JLabel("WELCOME SELLER");
    private JButton btnAddNewModel = new JButton("ADD MOBILE TO SELL");
    private JButton btnSignOut = new JButton("BACK");
    private JButton btnAddSeller = new JButton("REGISTER YOURSELF");

    public SellerPage() {
        frmSellerPage.setResizable(false);
        frmSellerPage.setBounds(100, 100, 500, 300);
        frmSellerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSellerPage.setLocationRelativeTo(null);

        frmSellerPage.add(backImage);
        backImage.setLayout(null);

        lblWelcome.setFont(new Font("CALIBRI", Font.CENTER_BASELINE, 38));
        lblWelcome.setForeground(Color.BLACK);
        lblWelcome.setBounds(105, 75, 400, 50);
        backImage.add(lblWelcome);

        btnAddNewModel.setIcon(new ImageIcon("imgs\\addmobile.png"));
        btnAddNewModel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmSellerPage.dispose();
                new sellsMobile();
            }
        });
        btnAddNewModel.setBounds(260, 180, 200, 40);
        backImage.add(btnAddNewModel);

        btnAddSeller.setIcon(new ImageIcon("imgs\\addseller.png"));
        btnAddSeller.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmSellerPage.dispose();
                new sellerAddsSeller();
            }
        });
        btnAddSeller.setBounds(30, 180, 200, 40);
        backImage.add(btnAddSeller);

        btnSignOut.setIcon(new ImageIcon("imgs\\back.png"));
        btnSignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmSellerPage.dispose();
                new start();
            }
        });
        btnSignOut.setBounds(15, 15, 125, 30);
        backImage.add(btnSignOut);

        frmSellerPage.setVisible(true);
    }
}
