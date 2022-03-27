package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel{
    Image background;
    int targetCredits = 1500;

    public Level1(Game game){
   super(game);

        background = new ImageIcon("data/blueBackground.JPG").getImage();
        //9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-8, -1f), 0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(8, 0.5f), 30);

        for (int i=5; i<5; i++)
        new Chicken(this, new Vec2(i*2,5));
        new Chicken(this, new Vec2(5,5));
        for (int i=0; i<5; i++){


            Chicken KFC1 =new Chicken(this, new Vec2(i*3f,7));
        }


        //SET POSITIONS
        getSpikeBall().setPosition(new Vec2(1,1));
        getSoldier().setPosition(new Vec2(-9, 9));
    }

    @Override
    public boolean isComplete() {
        if (Soldier.getCredits()>=1500)
        {return  true;}
        else
        { return false;}
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
