package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Chicken extends Food{


    //make platform Image here

    BodyImage chickenImage = new BodyImage("data/chicken.png", 2f);


    // make  platformShape here
    Shape foodShape = new BoxShape(1f, 1f);


    // constructor
    public Chicken (World world, Vec2 position) {
        super(world,position);

        // "world here is an object of the GameWorld class"
        setPosition(position);
        addImage(chickenImage);
       //setAngleDegrees(degrees);
    }
    }

