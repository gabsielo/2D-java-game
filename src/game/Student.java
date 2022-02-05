package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

public class Student extends DynamicBody {
    private static int credits;


    private static final Shape studentShape = new BoxShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    public Student(World world) {
        super(world, studentShape);
        addImage(image);
        credits=0;
    }

    // accessor and mutator for methods
    public int getCredits(){return credits;}
    public void increaseCredits(int amount){credits = credits+ amount;}
    public void decreaseCredits(int amount){credits =credits- amount;}


}
