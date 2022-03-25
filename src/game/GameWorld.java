package game;
//imports
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//class
public class GameWorld extends World {


    private Terrorist osama;
    private Soldier soldier;
    private SoundClip gameMusic;


    public GameWorld() {
        super();

        /*  Probably  redundant
        BodyImage spikeBallImage;
        spikeBallImage = new BodyImage("data/spikeBall.png", 3f);

        */
        try {
            gameMusic = new SoundClip("data/LetsLurk.mp3");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continuous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

            // make the ground
            Shape shape = new BoxShape(11, 0.5f);
            StaticBody ground = new StaticBody(this, shape);

            BodyImage groundImage = new BodyImage("data/ground.JPG", 2f);
            ground.setPosition(new Vec2(0f, -11.5f));
            ground.addImage(groundImage);

            // make the character
            soldier = new Soldier(this);

            soldier.setPosition(new Vec2(-9, 9));
            soldier.setAlwaysOutline(true);
            soldier.setLinearVelocity(new Vec2(0, 9));
            soldier.increaseCredits(15);


            // make a Terrorist
            osama = new Terrorist(this);
            osama = osama;
            osama.startWalking(osama.getTerroristWalkingSpeed() - 1);

            // trying to make 2nd terrorrist
            Terrorist a = new Terrorist(this);
            a.setPosition(new Vec2(2, -11));
            a.startWalking(2);

            //try to make chickenbucket
            new Chicken(this, new Vec2(5,5));


            // testing the new wall constructor 8/3/22 22:40

            Wall wall1 = new Wall(this, new Vec2(-11, -1));
            //   NOT NEEDED OR GOOD FOR GAME wall1.addCollisionListener(new TerroristCollisionListener(osama));
            Wall wall2 = new Wall(this, new Vec2(11, -1));
            //adding collisionlistener to wall2 in progress-NOT NEEDED OR GOOD FOR THE GAME
            //   wall2.addCollisionListener(new TerroristCollisionListener(osama));

            //**move** here the rest of the code from Gave.java that
            //populates the World - add platforms, Student, etc.
            //(don't add anything related to the view)
            // make a suspended platform

            //9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
            Platform platform1 = new Platform(this, new Vec2(-8, -1f), 0);
            //make the second suspended platform
            Platform platform2 = new Platform(this, new Vec2(8, 0.5f), 30);


            //make the ball
            //experiment adding image for ball
            //make spikeBall
            SpikeBall spikeball1 = new SpikeBall(this, new Vec2(5, 5));
            spikeball1.startWalking(spikeball1.getSpikeBallWalkingSpeed() + 1);

      /*   OLD SPIKEBALL  CODE REDUNDANT  CircleShape ballShape = new CircleShape(1.5f);
        DynamicBody ball = new DynamicBody(this, ballShape);
        ball.setPosition(new Vec2(8, 0.9f));
        ball.addImage(spikeBallImage);
       */


            //add enemy collision listener for the soldier
            SoldierCollisionListener EnemyCollision = new SoldierCollisionListener(soldier);
            soldier.addCollisionListener(EnemyCollision);
            // add wall collision listener for Enemy
            TerroristCollisionListener osamaWallCollision = new TerroristCollisionListener(osama);
            osama.addCollisionListener(osamaWallCollision);
            //and spikeball collsion listener
            SpikeBallCollisionListener spikeBallCollision = new SpikeBallCollisionListener(spikeball1);
            spikeball1.addCollisionListener(spikeBallCollision);
            // abu collision listener
            TerroristCollisionListener abuWallCollision = new TerroristCollisionListener(a);
            a.addCollisionListener(abuWallCollision);
            soldier.getBackpack().addItem(new Pistol(soldier));
            soldier.getBackpack().addItem(new Jetpack(soldier));

        }
        //accessor soldier

        public Soldier getSoldier () {
            return soldier;
        }
        public Terrorist getOsama () {
            return osama;
        }


    }

