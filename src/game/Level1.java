package game;

import org.jbox2d.common.Vec2;

public class Level1 extends GameLevel{

    public Level1(){

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

        /* doesnt work for (int i=5; i<5; i++){

            Chicken KFC1 =new Chicken(this, new Vec2(i*3f,5));
        }
            */
    }
}
