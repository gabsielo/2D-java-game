package game;
import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SoldierController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private Soldier soldier;

    public SoldierController(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            soldier.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) {
            soldier.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_UP){
            soldier.jump(15);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            soldier.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            soldier.stopWalking();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
