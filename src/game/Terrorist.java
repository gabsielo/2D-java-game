package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Terrorist extends Walker
implements Destroyable{

private static SoundClip Boom;
private static SoundClip yo;


    // boom static
    static {
        try {
            yo = new SoundClip("data/shaqYo.mp3");   // Open an audio input stream
            //  boom.play();                              // Set it to  play
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
        yo.setVolume(1.6);
    }


    // enemy health level declaration and methods
     private int enemyHealthLevel;
     //getter and setter
     public void setEnemyHealthLevel(int enemyHealthLevel) {
        this.enemyHealthLevel = enemyHealthLevel;
    }
    public int getEnemyHealthLevel() {
        return enemyHealthLevel;
    }


    private static final Shape soldierShape = new BoxShape(1,2);
    // soldier image
    private static BodyImage TerroristImage =
            new BodyImage("data/terroristRight.png", 4f);

    //Terrorist image palaver
    //Terrorist image getter
    public BodyImage getTerroristImage(){return TerroristImage;}

    // flip terrorist images
    public static void flipTerroristImageLeft(){ TerroristImage =
            new BodyImage( "data/TerroristRight.png",4f);};
    public static void flipTerroristImageRight(){ TerroristImage =
            new BodyImage( "data/TerroristLeft.png",4f);}

    //constructor
    public Terrorist(World world) {
        super(world, soldierShape);
        addImage(TerroristImage);
        enemyHealthLevel=10;}

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
        healthLevel = healthLevel-healthAmount;
    };

    // increase healthLevel
    public void increaseHealthLevel(int healthAmount){
        healthLevel = healthLevel+healthAmount;
    }

        // Walking speed and getter and setter methods
        // Terrorist Walking Speed getter and Setter
        private static int TerroristWalkingSpeed = 3;

    public int getTerroristWalkingSpeed() {
        return TerroristWalkingSpeed;
    }
    public void setTerroristWalkingSpeed (int terroristWalkingSpeed) {
        TerroristWalkingSpeed = terroristWalkingSpeed;
    }
    public void reverseTerroristWalkingSpeed(){TerroristWalkingSpeed= (TerroristWalkingSpeed*-1);}

    @Override
    public void destroy(){

        yo.play();
        super.destroy();
        Soldier.increaseCredits(100);
    }

}