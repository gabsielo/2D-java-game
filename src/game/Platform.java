package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Platform {


    //make platform Image here
    BodyImage platformImage = new BodyImage("data/platform.JPG", 1f);
    // make  platformShape here
    Shape platformShape = new BoxShape(3f, 0.5f);


    // constructor
    public Platform(World world, Vec2 position,float degrees) {
        // "world here is an object of the GameWorld class"
        StaticBody platform = new StaticBody(world, platformShape);
        platform.setPosition(position);
        platform.addImage(platformImage);
        platform.setAngleDegrees(degrees);
    }

   /*  trying to make rotation method for platform
   public void setAngleDegrees(){ platform.bodyDef.angle = 0.25f * b2_pi;}
   // the body's angle in radians.

    */
}


/*    Old platform code
// make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -1f));

        //make the second suspended platform
        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(8, 0.5f));
        platform2.setAngleDegrees(30);
 */



