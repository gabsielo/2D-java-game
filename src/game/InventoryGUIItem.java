package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryGUIItem extends JPanel implements MouseListener {
    private Image icon;
    private String type;
    private boolean selected;

    public InventoryGUIItem(String type, String imagePath){
        this.type = type;
        this.selected=false;

        icon = new ImageIcon(imagePath).getImage();
        this.setPreferredSize(new Dimension(50,50));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!selected){
            g.setColor(Color.gray);

        }
        else {
            g.setColor(Color.pink);

        }
        g.fillRect(0,0,50,50);
        g.drawImage(icon,0,0,30,30,null);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
    selected=!selected;

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
