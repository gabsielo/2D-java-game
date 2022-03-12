package game;
import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;
import java.math.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SoldierController implements KeyListener {

    private static final float WALKING_SPEED = 7;
    private Soldier soldier;
    // broken 11/3/22 private Terorist osama = world.getOsama();
  public SoldierController(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        //key pressed left and a
        if (code == KeyEvent.VK_LEFT||code == KeyEvent.VK_A) {
            soldier.walkLeft(-WALKING_SPEED);
            soldier.removeAllImages();
            soldier.addImage(new BodyImage("data/soldierLeft.PNG",4f));

        }
        //key pressed right and d
        else if (code == KeyEvent.VK_RIGHT||code == KeyEvent.VK_D) {
            soldier.startWalking(WALKING_SPEED);

        //jump
        } else if (code == KeyEvent.VK_UP||code == KeyEvent.VK_W){
            soldier.jump(15);
        }
        else if (code== KeyEvent.VK_Q){soldier.shoot();}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        ///key release left and a
        if (code == KeyEvent.VK_LEFT||code == KeyEvent.VK_A) {
            soldier.stopWalking();
        }
        //key release right and d
        else if (code == KeyEvent.VK_RIGHT||code == KeyEvent.VK_D) {
            soldier.stopWalking();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
