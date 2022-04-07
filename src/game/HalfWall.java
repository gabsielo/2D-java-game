package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class HalfWall extends StaticBody{


    //make wallImage here
    BodyImage halfWallImage = new BodyImage("data/brickWall.JPG",10f);
    // make  wallShape here
    private static final Shape wallShape = new BoxShape(0.25f, 5);





    // constructor
    public HalfWall(World world, Vec2 position) {
        // "world here is an object of the GameWorld class"
        super(world, wallShape);
        setPosition(position);
        addImage(halfWallImage);

    }




}
