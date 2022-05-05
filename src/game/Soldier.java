package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import java.util.List;



/**
 * @author      Gabriel Maharaj gabriel.maharaj@city.ac.uk
 * @version     version 1.0.46
 * @since       1.0.3
 */




public class Soldier extends Walker {
    public static int credits;
    private String direction;
    private final Backpack backpack;
    private final AttachedImage aImage;
    private static SoundClip skra;
    private static SoundClip boom;



    /**
     *srka is the sound that will play when the soldier shoots
     *
     */
    //skra static experiment 23/3/21 edit: its working
    static {
        try {
            skra = new SoundClip("data/shaqSkra.mp3");   // Open an audio input stream
          //  skra.play();                              // Set it to  play
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }



    /**
     *projectile image is what the picture that the projectile from the soldier will look like
     *
     */
    BodyImage projectileImage = new BodyImage("data/unexplodedBomb.png",0.9f);


    /**
     * soldier shape iss the shape for the hit box that objects of the soldier class will use
     */
    private static final Shape soldierShape = new PolygonShape(1.5f, -1.86f, -0.53f, -1.87f, -0.79f, 0.69f, -0.03f, 1.71f, 1.16f, 1.3f, 1.56f, -1.84f);



    // soldier image
    /**
     * leftSoldierImage is the image that the soldier will take when walking or facing left
     *
     */
    private static final BodyImage leftSoldierImage =
            new BodyImage("data/soldierLeft.png", 4f);

    /**
     * rightSoldierImage is the image that the soldier will take when walking or facing right
     */

    private static final BodyImage rightSoldierImage =
            new BodyImage("data/soldierRight.png", 4f);


    /**
     * soldier startwalking
     * <p>
     * the soldier moves in the direction specified by the user of the program through the soldier controller
     *
     * @param speed
     * @return void
     */
    @Override
    public void startWalking(float speed) {
        super.startWalking(speed);
        if (speed < 0 && direction.equals("right")) {
            List<AttachedImage> allImages= this.getImages();
            for (AttachedImage im : allImages);
            aImage.flipHorizontal();
            direction = "left";
        } else if (speed > 0 && direction.equals("left")) {
            List<AttachedImage> allImages= this.getImages();
            for (AttachedImage im : allImages);
            aImage.flipHorizontal();
            direction = "right";
        }}




      /*  if (speed <0){
            this.removeAllImages();
            this.addImage(leftSoldierImage);
            direction ="left";}
            else{
                this.removeAllImages();
            this.addImage(rightSoldierImage);
                direction= "right";
            }
*/
    /**
     * walkLeft
     * <p>
     * the soldier moves in the direction specified by the user of the program through the soldier controller
     *
     * @param {float speed is the  velocity that the soldier will travel at}
     * @return the method doesn't return anything
     */

        public void walkLeft ( float Speed){
            this.startWalking(Speed);
            this.removeAllImages();
            this.addImage(new BodyImage("data/soldierLeft.png", 4));
        }


        //soldier image palava
        //soldier image getter
      /*

      CURRENTLY REDUNDANT
      public BodyImage getSoldierImage(){return soldierImage;}

            // flip soldier images
         public static void flipSoldierImageLeft(){ soldierImage =
              new BodyImage( "data/soldierLeft.png",4f);};
        public static void flipSoldierImageRight(){ soldierImage =
            new BodyImage( "data/soldierRight.png",4f);}
*/
        // constructor CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONTSTRUCTOR


    /**
     * Soldier constructor
     * <p>
     * an object of the soldier class is created.
     *
     * @param world
     *
     */


    public Soldier(World world) {
            super(world, soldierShape);
            aImage = addImage(leftSoldierImage);

            credits = 0;
            setHealthLevel(1000);
            direction = "left";
            backpack = new Backpack();


        }
        // CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR

        // accessor and mutator for credits (PROBABLY REDUNDANT)

    /**
     * get credits
     * <p>
     * the number of  credits the player has is returned
     *
     *
     * @return credits
     */

    public static int getCredits () {
            return credits;
        }

    /**
     * increaseCredits
     * <p>
     * increases the number of soldiers credits by a specified amount
     *
     * @param {an integer credits is the parameter}
     * @return nothing
     */
        public static void increaseCredits(int amount){
            credits = credits + amount;
        }
    /**
     * decreasesCredits
     * <p>
     * decreases the number of soldiers credits by a specified amount
     *
     * @param {an integer credits is the parameter}
     * @return nothing
     */
        public static void decreaseCredits ( int amount){
            credits = credits - amount;
        }


    /**
     * setCredits
     * <p>
     * sets number of soldiers credits to a specified amount
     *
     * @param {and integer credits is the parameter}
     * @return nothing
     */


        public  void setCredits( int credits){
        Soldier.credits = credits;}

     //    making new health as static




    /**
     *sets HealthLevel
     * <p>
     * sets soldier's health  to a specified amount
     * and prints the soldiers current health level to the console
     *
     * @param healthLevel

     */

    public void setHealthLevel ( int healthLevel){
        Soldier.healthLevel = healthLevel;
        System.out.println(healthLevel + "health left");
    }

    /**
     * healthLevel is a numerical representation of the soldiers health
     *
     */
    private static int healthLevel;


    /**
     *returns HealthLevel
     * <p>
     * returns the value of the soldiers health

     *
     *
     * @return  healthLevel
     *
     */

    public static int getHealthLevel () {
        return healthLevel;
    }

    /**
     * increaseHealthLevel
     * <p>
     * increases the number of soldiers health by a specified amount
     *
     * @param amount
     * @return
     */
    public static void increaseHealthLevel(int amount){
        healthLevel = healthLevel + amount;
    }

    /**
     * decreasesHealthLevel
     * <p>
     * decreases the number of soldiers credits by a specified amount
     *
     * @param {an integer credits is the parameter}
     * @return nothing
     */
    public static void decreaseHealthLevel ( int amount){
        healthLevel = healthLevel - amount;
    }


    /*
     // becoming redundant 30/3/22
      as I make healthlevel a static variable
      keeping just incase i need it non static again ( unlikely)
        // Health level methods

        private int healthLevel;


        //set health level

        public void setHealthLevel ( int healthLevel){
            this.healthLevel = healthLevel;
            System.out.println(healthLevel + "health left");
        }

        // healthLevel getter
        public int getHealthLevel () {
            return healthLevel;
        }
        //decreaseHealthLevel
        public void decreaseHealthLevel ( int healthAmount){
            healthLevel = healthLevel - healthAmount;
            System.out.println(" you  got hit " + healthLevel + "health left");
        }
        // increase healthLevel
        public void increaseHealthLevel ( int healthAmount){
            healthLevel = healthLevel + healthAmount;
        }
        */


        // making shoot method


    /**
     * soldier shoots
     * <p>
     * a small dynamic body is shot away from the soldier
     *
     *
     */
        public void shoot () {

            skra.play();
            Soldier.increaseCredits(10);

            DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));

            projectile.addCollisionListener(new BulletCollision());
            projectile.addImage(projectileImage);

            if (direction.equals("left")) {
                projectile.setPosition(new Vec2(this.getPosition().x - 1, this.getPosition().y));
                projectile.setLinearVelocity(new Vec2(-25, 3));

            } else if (direction.equals("right")) {
                projectile.setPosition(new Vec2(this.getPosition().x + 1, this.getPosition().y));
                projectile.setLinearVelocity(new Vec2(25, 3));

            }


        }

    /**
     * soldier shoots
     * <p>
     * a small dymanic body is shot away from the soldier
     * in the direction that the mouse is clicked
     * @param  t
     *
     */
        public void shoot (Vec2 t){
          //  skra.setVolume(1.6);
            skra.play();
            DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
            projectile.addImage(projectileImage);
            Vec2 dir = t.sub(this.getPosition());
            projectile.setPosition(this.getPosition().add(dir.mul(0.1f)));
            dir.normalize();

            projectile.setLinearVelocity(dir.mul(40));
            Soldier.increaseCredits(10);
           // projectile.addCollisionListener(new ExplosionCollision());
            projectile.addCollisionListener(new BulletCollision());
        }
    /**
     * soldier drops grenade
     * <p>
     * a small dymanic body is shot away from the soldier
     *
     * g
     */
        public void dropBomb(){

            new Bomb(this.getWorld(),this.getPosition(),3000);
        }


    /**
     * returns backpack object
     * <p>
     * accesssor method for the back pack object
     *
     *
     */
        //backpack accessor
        public Backpack getBackpack () {
            return backpack;
        }

    /**
     *the direction the charachter moves in is returned
     * @return direction
     */
    public String getDirection () {

            return direction;
        }
    }
