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


        // testing the new wall constructor 8/3/22 22:40

        Wall wall1= new Wall(this, new Vec2(-11,-1));
        Wall wall2 = new Wall(this, new Vec2(11,-1));



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


        // make an enemy
        Terrorist Osama = new Terrorist(this);

        //**move** here the rest of the code from Gave.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)
        // make a suspended platform

        //9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-8,-1f),0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(8, 0.5f),30);




        //make the ball
        //experiment adding image for ball



        CircleShape ballShape = new CircleShape(1.5f);
        DynamicBody ball = new DynamicBody(this, ballShape);
        ball.setPosition(new Vec2(8, 0.9f));
        ball.addImage(spikeBallImage);



        //add enemy collsion listener for the soldier
        EnemyCollisionListener enemyCollision = new EnemyCollisionListener(soldier);
        soldier.addCollisionListener(enemyCollision);
    }
       //accessor soldier

       public Soldier getSoldier() {
        return soldier;
    }
}

