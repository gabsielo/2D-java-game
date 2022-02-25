package game;
//imports
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;


//class
public class GameWorld extends World {

    Soldier soldier;
    public GameWorld() {
        super();

        BodyImage spikeBallImage;
        spikeBallImage = new BodyImage("data/spikeBall.png", 3f);

        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make the character
         soldier = new Soldier(this);
        soldier.setPosition(new Vec2(7, -9));
        soldier.setAlwaysOutline(true);
        soldier.setLinearVelocity(new Vec2(0, 9));
        soldier.increaseCredits(15);


        //**move** here the rest of the code from Gave.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)
        // make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -1f));

        //make the second suspended platform
        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(8, 0.5f));
        platform2.setAngleDegrees(30);

        //make the ball
        //experiment adding image for ball



        CircleShape ballShape = new CircleShape(1.5f);
        DynamicBody ball = new DynamicBody(this, ballShape);
        ball.setPosition(new Vec2(8, 0.9f));
        ball.addImage(spikeBallImage);


        //make the wall1 (left wall)
        Shape wallShape = new BoxShape(0.5f, 10);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-10, -1));


        //make the wall2( right wall2)
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(10, -1));

    }
//accessor soldier

    public Soldier getSoldier() {
        return soldier;
    }
}

