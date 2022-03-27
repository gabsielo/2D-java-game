package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Chicken extends Food {


    //make platform Image here

    BodyImage chickenImage = new BodyImage("data/chicken.png", 2f);
    private static SoundClip eatSound;


    static {
        try {
            eatSound = new SoundClip("data/eat.mp3");   // Open an audio input stream
            //  skra.play();                              // Set it to  play
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }


    // make  platformShape here
    Shape foodShape = new BoxShape(1f, 1f);


    // constructor
    public Chicken(World world, Vec2 position) {
        super(world, position);

        // "world here is an object of the GameWorld class"
        setPosition(position);
        addImage(chickenImage);
        //setAngleDegrees(degrees);
    }

    @Override
    public void destroy() {

        eatSound.play();
        super.destroy();
        Soldier.increaseCredits(100);
    }
}

