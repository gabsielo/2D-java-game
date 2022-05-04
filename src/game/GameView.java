package game;

//imports
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;


public class GameView extends UserView {

private final Soldier soldier;
GameLevel currentLevel;
private final GameLevel gameLevel;
private final Game game;


    public GameView(Game game, GameLevel w, int width, int height) {
        super(w, width, height);
        currentLevel = w;
        soldier = w.getSoldier();
        this.gameLevel=w;
        this.game =game;
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
        super.paintForeground(g);
        Font font1 = new Font("Arial",Font.BOLD,20);

                g.setFont(font1);
        g.setColor(Color.orange);
              g.drawString("health: "+ Soldier.getHealthLevel()+" credits: " + Soldier.getCredits(),10,90
              );
        g.setFont(font1);
        g.setColor(Color.red);
        g.drawString("collect 1500 credits press 'B''E'T' ",10,70
        );


        if (game.isGameOver()){


            Font font2 = new Font("Arial",Font.BOLD,60);

            g.setFont(font2);
            g.setColor(Color.green);
            g.drawString("GameOver",this.getWidth()/4,this.getHeight()/2);

        }
    }
    public void setGameOver(boolean over){
      //  gameOver=over;
    }

    }

