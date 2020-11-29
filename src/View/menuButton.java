package View;

import javax.swing.*;
import java.awt.*;

public class menuButton extends JButton {

    menuButton(){
        this.setPreferredSize(new Dimension(150, 25));
        this.setBackground(new Color(0x555555));
        this.setFocusable(false);
        this.setForeground(new Color(0xE0E0E0));
        this.setText("-----");
        this.setBorder(BorderFactory.createEtchedBorder());
    }

    menuButton(String setText){
        this();
        this.setText(setText);
    }

}
