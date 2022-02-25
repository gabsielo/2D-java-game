package game;

//imports
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;



public class GameView extends UserView {

    private Image background;
    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        this.background = new ImageIcon("data/blueBackground.jpg").getImage();

    }




    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }


    }

