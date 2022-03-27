
package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level3 extends GameLevel{
    private SoundClip gameMusic;
    Image background;
    int targetCredits =3000;
    public SoundClip getGameMusic(){return gameMusic;}
    public Level3(Game game) {
        super(game);
        background = new ImageIcon("data/councilEstate.jpeg").getImage();

        try {
            gameMusic = new SoundClip("data/nextUp.mp3");   // Open an audio input stream
            gameMusic.setVolume(0.9);
            gameMusic.loop();                            // Set it to continuous playback (looping)

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        //    9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-3, -5f), 0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(3, 2f), 30);
        new Chicken(this, new Vec2(9,3));
        new Chicken(this, new Vec2(5,5));

        int j=0;
        while ( j<10)
        {
            for (int i = 0; i < 10; i++) {
                Zoot zoot1 = new Zoot(this, new Vec2(i*4 * 1f, j));
                Zoot zoot2 = new Zoot(this, new Vec2(-i*4 * 1f, -j+5));
                Zoot zoot3 = new Zoot(this, new Vec2(i*4 * 1f, -j+5));
                Zoot zoot4 = new Zoot(this, new Vec2(-i*4 * 1f, j));
            }
            j++;
        };

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