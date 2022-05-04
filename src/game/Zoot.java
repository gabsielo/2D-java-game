
package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Zoot extends StaticBody
implements Destroyable {

    private static SoundClip smokeTreesSound;
    private static final BoxShape zootShape  = new BoxShape(1f,0.125f);


    static {

        try {
            smokeTreesSound = new SoundClip("data/smokeTrees.mp3");   // Open an audio input stream
            //  skra.play();                              // Set it to  play
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }


    //make platform Image here

    BodyImage zootImage = new BodyImage("data/zoot.png", 2f);


    // make  platformShape here
    Shape foodShape = new BoxShape(3f, 1f);


    // constructor
    public Zoot(World world, Vec2 position) {
        super(world, zootShape);

        // "world here is an object of the GameWorld class"
        setPosition(position);
        addImage(zootImage);
        //setAngleDegrees(degrees);
        }


        @Override
        public void destroy() {

            smokeTreesSound.play();
            super.destroy();
            Soldier.increaseCredits(1);

        }
    }

