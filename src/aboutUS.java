import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class aboutUS {

    private JFrame frmAboutUs = new JFrame("About Us");
    private JPanel pnlAboutUs = new JPanel();
    private JLabel lblAboutUs = new JLabel("ABOUT US");
    private JLabel lblBackImage = new JLabel("");
    private JLabel lblHiteshSaini = new JLabel("Hitesh Saini - 276/CO/12");
    private JLabel lblMohdNaveed = new JLabel("Mohd Naveed - 296/CO/12");
    private JLabel lblMonalJain = new JLabel("Monal Jain - 299/CO/12");

    private JButton btnBack = new JButton("Back");

    public aboutUS() {
        frmAboutUs.add(pnlAboutUs);
        frmAboutUs.setResizable(false);
        frmAboutUs.setBounds(100, 100, 300, 450);
        frmAboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAboutUs.setLocationRelativeTo(null);

        pnlAboutUs.setBackground(Color.WHITE);
        pnlAboutUs.setLayout(null);

        lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
        lblAboutUs.setFont(new Font("ROBOTO", Font.BOLD, 35));
        lblAboutUs.setBounds(10, 11, 274, 65);
        pnlAboutUs.add(lblAboutUs);

        lblBackImage.setIcon(new ImageIcon("imgs\\nsit.jpg"));
        lblBackImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblBackImage.setBounds(10, 87, 274, 123);
        pnlAboutUs.add(lblBackImage);

        lblMonalJain.setFont(new Font("ROBOTO", Font.PLAIN, 14));
        lblMonalJain.setBounds(65, 230, 275, 25);
        pnlAboutUs.add(lblMonalJain);

        lblMohdNaveed.setFont(new Font("ROBOTO", Font.PLAIN, 14));
        lblMohdNaveed.setBounds(65, 260, 275, 25);
        pnlAboutUs.add(lblMohdNaveed);

        lblHiteshSaini.setFont(new Font("ROBOTO", Font.PLAIN, 14));
        lblHiteshSaini.setBounds(65, 290, 275, 25);
        pnlAboutUs.add(lblHiteshSaini);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAboutUs.dispose();
                new start();
            }
        });
        btnBack.setBounds(100, 350, 100, 35);
        btnBack.setForeground(Color.BLUE);
        btnBack.setIcon(new ImageIcon("imgs\\back.png"));
        pnlAboutUs.add(btnBack);

        frmAboutUs.setVisible(true);

    }
}
