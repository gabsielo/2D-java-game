package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

public class Soldier extends Walker {
    public static int credits;


    private static final Shape soldierShape = new PolygonShape(1.5f,-1.86f, -0.53f,-1.87f, -0.79f,0.69f, -0.03f,1.71f, 1.16f,1.3f, 1.56f,-1.84f);
   // soldier image
    private static  BodyImage soldierImage =
            new BodyImage("data/soldierRight.jpeg", 4f);

        //soldier image palava
        //soldier image getter
        public BodyImage getSoldierImage(){return soldierImage;}

            // flip soldier images
         public static void flipSoldierImageLeft(){ soldierImage =
              new BodyImage( "data/soldierLeft.jpg",4f);};
        public static void flipSoldierImageRight(){ soldierImage =
            new BodyImage( "data/soldierRight.jpeg",4f);}


    public Soldier(World world) {
        super(world, soldierShape);
        addImage(soldierImage);
        credits=0;}

    // accessor and mutator for credits (PROBABLY REDUNDANT)
    public int getCredits(){return credits;}
    public void increaseCredits(int amount){credits = credits+ amount;}
    public void decreaseCredits(int amount){credits = credits- amount;}

    //collsion methods (work in progress)
    private int healthLevel;
        public void setHealthLevel(int healthLevel){
            this.healthLevel = healthLevel;
        //print message when a new book is read; it'll be useful later
        System.out.println(" you  got hit " + healthLevel+ "health left");
         }
        public int getHealthLevel(){
         return healthLevel;
         }


}
