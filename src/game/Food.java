package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;



public class Food extends StaticBody
implements Destroyable{

    private static SoundClip eatSound;

    /* temp redundant 24/3/22
        //make platform Image here

        BodyImage chickenImage = new BodyImage("data/Food.jpeg", 0.5f);
        */
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
    private static final Shape foodShape = new BoxShape(0.5f, 0.5f);


    // constructor
    public Food(World world, Vec2 position) {
        // "world here is an object of the GameWorld class"
        super(world, foodShape);
        setPosition(position);
        //addImage(wallImage);

    }

    @Override
    public void destroy() {

         //   not needed 27/3 eatSound.play();
            super.destroy();
           //not needed 27/3 Soldier.increaseCredits(10);



    }
}
