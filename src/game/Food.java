package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * @author      Gabriel Maharaj gabriel.maharaj@city.ac.uk
 * @version     version 1.0.46
 * @since       1.0.9
 *
 */

public abstract class Food extends StaticBody
implements Destroyable{
    /**
     *sound to signify the consrumption of a food item.
     */
    private static SoundClip eatSound;


    // DOESN'T WORK public abstract Shape foodShape;

    /**
     *foodShape-hit box of the items in the food class
     */
     private static final Shape foodShape = new BoxShape(0.5f, 0.5f);

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
   // private static final Shape foodShape = new BoxShape(0.5f, 0.5f);




    /**
     * food constructor
     * <p>
     * an object of the food class is created.
     *
     * @param world
     * @param position
     *
     * @return the method doesn't return anything as it's a constructor
     */

    // constructor
    public Food(World world, Vec2 position) {

        // "world here is an object of the GameWorld class"
        super(world, foodShape);
        setPosition(position);
        //addImage(wallImage);
    }


    /**
     * destroy method destroys the food
     */
    @Override
    public void destroy() {

         //   not needed 27/3 eatSound.play();
            super.destroy();
           //not needed 27/3 Soldier.increaseCredits(10);



    }
}
