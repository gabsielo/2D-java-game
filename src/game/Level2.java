package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel{

Image background;
int targetCredits =3000;

    public Level2(Game game) {
     super(game);
        background = new ImageIcon("data/councilEstate.jpeg").getImage();

        //    9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-3, -5f), 0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(3, 2f), 30);
        new Chicken(this, new Vec2(9,3));
        new Chicken(this, new Vec2(5,5));
        for (int i=0; i<10; i++){


            Chicken KFC1 =new Chicken(this, new Vec2(i*0.5f,i+4));
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
