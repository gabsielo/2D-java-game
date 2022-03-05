package game;

import city.cs.engine.*;

public class Terrorist extends Walker {
    public static int credits;


    private static final Shape soldierShape = new BoxShape(1,2);
    // soldier image
    private static BodyImage TerroristImage =
            new BodyImage("data/terroristRight.png", 4f);

    //soldier image palava
    //soldier image getter
    public BodyImage getTerroristImage(){return TerroristImage;}

    // flip terrorist images
    public static void flipTerroristImageLeft(){ TerroristImage =
            new BodyImage( "data/TerroristRight.png",4f);};
    public static void flipTerroristImageRight(){ TerroristImage =
            new BodyImage( "data/TerroristLeft.png",4f);}


    public Terrorist(World world) {
        super(world, soldierShape);
        addImage(TerroristImage);
        credits=0;}

    // accessor and mutator for methods
    public int getCredits(){return credits;}
    public void increaseCredits(int amount){credits = credits+ amount;}
    public void decreaseCredits(int amount){credits = credits- amount;}


}