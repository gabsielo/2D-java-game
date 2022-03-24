package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Food extends StaticBody{

/* temp redundant 24/3/22
    //make platform Image here

    BodyImage chickenImage = new BodyImage("data/Food.jpeg", 0.5f);
    */

    // make  platformShape here
     private static final Shape foodShape = new BoxShape(0.5f, 0.5f);




    // constructor
    public Food (World world, Vec2 position) {
        // "world here is an object of the GameWorld class"
        super(world, foodShape);
        setPosition(position);
        //addImage(wallImage);

    }


}
