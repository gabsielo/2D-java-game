
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SpikeBall extends Walker {

    int spikeBallWalkingSpeed =3;


    // enemy health level declaration and methods
    private int enemyHealthLevel;
    //getter and setter
    public void setEnemyHealthLevel(int enemyHealthLevel) {
        this.enemyHealthLevel = enemyHealthLevel;
    }
    public int getEnemyHealthLevel() {
        return enemyHealthLevel;
    }


    // make ball shape
    private static CircleShape ballShape = new CircleShape(1.5f);

    // soldier image
    private static BodyImage spikeBallImage =
            new BodyImage("data/spikeBall.png", 4f);

    //Terrorist image palaver
    //Terrorist image getter
    public BodyImage getTerroristImage(){return spikeBallImage;}

    // flip  images
    public static void flipTerroristImageLeft(){ spikeBallImage =
            new BodyImage( "data/spikeBall.png",3f);};
    public static void flipTerroristImageRight(){ spikeBallImage =
            new BodyImage( "data/spikeBall.png",3f);}

    //constructor
    public SpikeBall(World world, Vec2 position) {
        super(world, ballShape);

        this.setPosition(position);
        this.addImage(spikeBallImage);
        enemyHealthLevel=10;
    }

    // Health level methods

    private int healthLevel;


    //set health level

    public void setHealthLevel(int healthLevel){
        this.healthLevel = healthLevel;
        System.out.println( healthLevel + "health left");}

    // healthLevel getter
    public int getHealthLevel(){
        return healthLevel;
    }
    //decreaseHealthLevel
    public void decreaseHealthLevel(int healthAmount){
        healthLevel= healthLevel-healthAmount;
    };

    // increase healthLevel
    public void increaseHealthLevel(int healthAmount){
        healthLevel = healthLevel+healthAmount;
    }

    // Walking speed and getter and setter methods
    // Terrorist Walking Speed getter and Setter
    private static int SpikeBallWalkingSpeed = 2;

    public int getSpikeBallWalkingSpeed() {
        return SpikeBallWalkingSpeed;
    }
    public void setSpikeBallWalkingSpeed(int spikeBallWalkingSpeed) {
        SpikeBallWalkingSpeed  = spikeBallWalkingSpeed;
    }
    public void reverseSpikeBallWalkingSpeed(){SpikeBallWalkingSpeed = SpikeBallWalkingSpeed*-1;}


}