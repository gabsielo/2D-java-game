package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

public class Soldier extends Walker {
    public static int credits;


    private static final Shape soldierShape = new BoxShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/soldier.jpeg", 4f);

    public Soldier(World world) {
        super(world, soldierShape);
        addImage(image);
        credits=0;}

    // accessor and mutator for methods
    public int getCredits(){return credits;}
    public void increaseCredits(int amount){credits = credits+ amount;}
    public void decreaseCredits(int amount){credits = credits- amount;}


}
