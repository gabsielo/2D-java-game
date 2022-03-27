package game;

//imports
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;


public class GameView extends UserView {

private Soldier soldier;
GameLevel currentLevel;



    public GameView(GameLevel w, int width, int height) {
        super(w, width, height);
        currentLevel = w;
        soldier = w.getSoldier();


    }





    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(currentLevel.getBackground(), 0, 0, this);

    }

    @Override
    public void setWorld(World w)
    {   super.setWorld(w);

        currentLevel = (GameLevel)w;

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Font font = new Font("Arial",Font.BOLD,20);

                g.setFont(font);
        g.setColor(Color.orange);
              g.drawString("health: "+soldier.getHealthLevel()+" credits: " + soldier.getCredits(),10,90
              );
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("collect 1500 credits press 'B' ",10,70
        );

              ;}
    }

