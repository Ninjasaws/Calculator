package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    /*
    // GUI Ideas,
    Pop out txt results,
    copy to clipboard button,
    appear/disappear button for menu
    Option to have numpad popout? ehh or not have one at all

    0x6b6b6b
    0x555555
    0x404040
     */

    Frame(){

        this.setTitle("Handy Dandy Calculator");
        this.setSize(new Dimension(800,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainBackground = new JPanel(new BorderLayout());
        mainBackground.setBackground(new Color(0x494949));

        JPanel menu = new JPanel(new FlowLayout(FlowLayout.CENTER, 3,10));
        JPanel submenu1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3,10));
        JPanel submenu2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3,10));
        JPanel submenu3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3,10));

        menuButton saveB = new menuButton("Save Results");
        menuButton helpB = new menuButton("Help Page");
        menuButton fileB = new menuButton("Input File");

        menuButton button1 = new menuButton("Data Types");
        menuButton button2 = new menuButton(" +     -     *     / ");
        menuButton button3 = new menuButton("Data Units");
        menuButton button4 = new menuButton("Bandwidth Usage");
        menuButton button5 = new menuButton("Up-Download Time");
        menuButton button6 = new menuButton("Website Bandwidth");


        // Submenu labels!
        JLabel subText1 = new JLabel("Binary / Decimal / Hex ");
        subText1.setForeground(new Color(0xE0E0E0));
        JLabel subText2 = new JLabel("Website DataUnits");
        subText2.setForeground(new Color(0xE0E0E0));
        JLabel subText3 = new JLabel("Supportive");
        subText3.setForeground(new Color(0xE0E0E0));


        submenu1.add(subText1);
        submenu1.add(button1);
        submenu1.add(button2);

        submenu2.add(subText2);
        submenu2.add(button3);
        submenu2.add(button4);
        submenu2.add(button5);
        submenu2.add(button6);

        submenu3.add(subText3);
        submenu3.add(fileB);
        submenu3.add(saveB);
        submenu3.add(helpB);

        // Submenu sizes and looks
        menu.setPreferredSize(new Dimension(170,30));
        submenu1.setPreferredSize(new Dimension(160,105));
        submenu2.setPreferredSize(new Dimension(160,175));
        submenu3.setPreferredSize(new Dimension(160,140));
        menu.setBackground(new Color(0x404040));
        submenu1.setBackground(new Color(0x404040));
        submenu2.setBackground(new Color(0x404040));
        submenu3.setBackground(new Color(0x404040));

        menu.add(submenu1);
        menu.add(submenu2);
        menu.add(submenu3);

        mainBackground.add(menu,BorderLayout.WEST);

        this.add(mainBackground);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
