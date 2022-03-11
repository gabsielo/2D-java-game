package game;

//imports
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;


public class GameView extends UserView {

private Soldier soldier;

    private Image background;
    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        this.background = new ImageIcon("data/blueBackground.JPG").getImage();
        soldier = world.getSoldier();
    }




    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Font font = new Font("Arial",Font.BOLD,20);

                g.setFont(font);
        g.setColor(Color.orange);
              g.drawString("health: "+soldier.getHealthLevel()+" credits: " + soldier.getCredits(),10,90);



        ;}
    }

