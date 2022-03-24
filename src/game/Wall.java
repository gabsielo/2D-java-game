package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Wall extends StaticBody{


//make wallImage here
    BodyImage wallImage = new BodyImage("data/brickWall.JPG",20f);
// make  wallShape here
    private static final Shape wallShape = new BoxShape(0.5f, 10);





    // constructor
    public Wall(World world, Vec2 position) {
        // "world here is an object of the GameWorld class"
      super(world, wallShape);
      setPosition(position);
      addImage(wallImage);

    }




}
/*

 */