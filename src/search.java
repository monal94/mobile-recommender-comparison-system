import javax.swing.*;
import java.awt.event.*;

public class search implements ActionListener {

    private JFrame frmSearch = new JFrame("SEARCH FOR PHONE!");

    private JLabel backImage = new JLabel(new ImageIcon("imgs//searchm1.jpg"));

    private JButton btnBack = new JButton("Back");
    private JButton btnBasicSearch = new JButton("Search by Model/Company");
    private JButton btnAdvancedSearch = new JButton("Advanced Search");
    private JButton btnBuy = new JButton("Buy");

    public search() {
        frmSearch.setResizable(false);
        frmSearch.setBounds(100, 100, 496, 331);
        frmSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearch.setLocationRelativeTo(null);

        frmSearch.add(backImage);
        backImage.setLayout(null);

        btnBack.setIcon(new ImageIcon("imgs\\back.png"));
        btnBack.addActionListener(this);
        btnBack.setBounds(10, 11, 89, 23);
        backImage.add(btnBack);

        btnBasicSearch.setIcon(new ImageIcon("imgs\\search1.png"));
        btnBasicSearch.addActionListener(this);
        btnBasicSearch.setBounds(100, 195, 220, 30);
        backImage.add(btnBasicSearch);

        btnAdvancedSearch.setIcon(new ImageIcon("imgs\\adsearch.png"));
        btnAdvancedSearch.addActionListener(this);
        btnAdvancedSearch.setBounds(100, 230, 220, 30);
        backImage.add(btnAdvancedSearch);
        
        btnBuy.setIcon(new ImageIcon("imgs\\buy.png"));
        btnBuy.addActionListener(this);
        btnBuy.setBounds(100, 265, 220, 30);
        backImage.add(btnBuy);

        frmSearch.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        frmSearch.dispose();

        if (e.getSource() == btnBack)
            new start();

        if (e.getSource() == btnBasicSearch)
            new basicSearch();

        if (e.getSource() == btnAdvancedSearch)
            new advancedSearch();
        
        if (e.getSource() == btnBuy)
            new buyOptions();
    }
}
