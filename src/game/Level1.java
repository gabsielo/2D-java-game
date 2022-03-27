package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1 extends GameLevel{
    Image background;
    int targetCredits = 1500;
    private SoundClip gameMusic;
    //temporarily just making sure the music stops when level 2 starts i cant workout how to  fix the rest 26/3
    public SoundClip getGameMusic(){return gameMusic;}
    public Level1(Game game){
   super(game);


        try {
            gameMusic = new SoundClip("data/LetsLurk.mp3");   // Open an audio input stream
            gameMusic.setVolume(0.3);
            gameMusic.loop();                            // Set it to continuous playback (looping)

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        background = new ImageIcon("data/blueBackground.JPG").getImage();
        //9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-8, -1f), 0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(8, 0.5f), 30);

        for (int i=5; i<5; i++)
        new Chicken(this, new Vec2(i*2,5));
        new Chicken(this, new Vec2(5,5));
        for (int i=0; i<5; i++){


            Chicken KFC1 =new Chicken(this, new Vec2(i*3f,7));
        }


        //SET POSITIONS
        getSpikeBall().setPosition(new Vec2(1,1));
        getSoldier().setPosition(new Vec2(-9, 9));
    }

    @Override
    public boolean isComplete() {
        if (Soldier.getCredits()>=1500)
        {return  true;}
        else
        { return false;}
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
