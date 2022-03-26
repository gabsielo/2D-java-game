package game;

import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel{


int targetCredits =3000;

    public Level2(Game game) {
     super(game);
        //    9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-3, -5f), 0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(3, 2f), 30);
        new Chicken(this, new Vec2(9,3));
        new Chicken(this, new Vec2(5,5));
        for (int i=0; i<5; i++){


            Chicken KFC1 =new Chicken(this, new Vec2(i*3f,7+i));
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

}
