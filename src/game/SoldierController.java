package game;
import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*    CONTROLLER

soldier movement   WASD and arrow keys
Item change - Q, Item use E,
Bomb Drop B


 */

public class SoldierController implements KeyListener {

    private static final float WALKING_SPEED = 7;
    private Soldier soldier;
    private final Game game;

    // broken 11/3/22 private Terrorist osama = world.getOsama();
    public SoldierController(Soldier soldier, Game game) {
        this.soldier = soldier;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        //key pressed left and a
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            soldier.startWalking(-WALKING_SPEED);
            //    soldier.walkLeft(-WALKING_SPEED);
            //   soldier.removeAllImages();
            //  soldier.addImage(new BodyImage("data/soldierLeft.PNG",4f));

        }
        //key pressed right and d
        else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            soldier.startWalking(WALKING_SPEED);

            //jump
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            soldier.jump(15);
        } else if (code == KeyEvent.VK_Q) {
            soldier.getBackpack().toggle();
        } else if (code == KeyEvent.VK_E) {
            soldier.getBackpack().getCurrentItem().operate();
        } else if (code == KeyEvent.VK_B) {
            soldier.dropBomb();
        } else if (code == KeyEvent.VK_T) {
            game.toggleMenu();
        } else if (code == KeyEvent.VK_1) {

            HighScoreReader reader = new HighScoreReader("data/score.txt");
            try {
                reader.readScores();
                reader.sortByScore();
                reader.displayScores(5);
            } catch (IOException ee) {
                ee.printStackTrace();
            }

        }
    else if (code == KeyEvent.VK_2){
        try {
            GameSaverLoader.save("data/save.txt", game.currentLevel);
        }catch(IOException ee){
            ee.printStackTrace();

        }
        }
    else if (code == KeyEvent.VK_L){
try{
        GameLevel loadedLevel = GameSaverLoader.load("data/save.txt",game);
        game.setLevel(loadedLevel);
}catch (IOException ee){
    ee.printStackTrace();
}

        }



    }

        @Override
        public void keyReleased(KeyEvent e){
            int code = e.getKeyCode();
            ///key release left and a
            if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
                soldier.stopWalking();
            }
            //key release right and d
            else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
                soldier.stopWalking();
            }

        }

        @Override
        public void keyTyped(KeyEvent e){

        }

        public void updateSoldier(Soldier newSoldier){

            soldier = newSoldier;

        }


    }
