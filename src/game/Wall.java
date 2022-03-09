package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Wall {


//make wallImage here
    BodyImage wallImage = new BodyImage("data/brickWall.JPG",20f);
// make  wallShape here
    Shape wallShape = new BoxShape(0.5f, 10);





    // constructor
    public Wall(World world, Vec2 position) {
        // "world here is an object of the GameWorld class"
      StaticBody wall = new StaticBody(world, wallShape);
      wall.setPosition(position);
       wall.addImage(wallImage);


       }




}
/*

 */