package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

public class Soldier extends Walker {
    public static int credits;


    private static final Shape soldierShape = new BoxShape(1,2);
   // soldier image
    private static  BodyImage soldierImage =
            new BodyImage("data/soldierRight.jpeg", 4f);

        //soldier image palava
        //soldier image getter


         public static void flipSoldierImageLeft(){ soldierImage =
              new BodyImage( "data/soldierLeft.jpg",4f);};
        public static void flipSoldierImageRight(){ soldierImage =
            new BodyImage( "data/soldierRight.jpeg",4f);}


    public Soldier(World world) {
        super(world, soldierShape);
        addImage(soldierImage);
        credits=0;}

    // accessor and mutator for methods
    public int getCredits(){return credits;}
    public void increaseCredits(int amount){credits = credits+ amount;}
    public void decreaseCredits(int amount){credits = credits- amount;}


}
