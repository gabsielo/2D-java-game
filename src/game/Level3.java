
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
 private final Game game;
    public SoundClip getGameMusic(){return gameMusic;}
    private Soldier soldier;


    public Level3(Game game) {
        super(game);
        background = new ImageIcon("data/fieldFiltered.jpg").getImage();
        this.game=game;


        try {
            gameMusic = new SoundClip("data/uraniumfever.mp3");   // Open an audio input stream
            gameMusic.setVolume(0.3);
            gameMusic.loop();                            // Set it to continuous playback (looping)

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }


        //    9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-3, 15), 0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(3, 20f), 30);

        Platform platform3 = new Platform(this, new Vec2(-7, 4), 0);
        Platform platform4 = new Platform(this, new Vec2(-4, 2), 0);
        Platform rightSidePlatform5 = new Platform(this, new Vec2(9, -4), 0);
        Platform groundForLavaPitPlatform6 = new Platform(this,new Vec2(14,-17.5f),0);

        new Chicken(this, new Vec2(9, 3));
        new Chicken(this, new Vec2(5, 5));


      //  BigBoss bigBoss= new BigBoss(this,game);
      // a  bigBoss.setPosition(new Vec2(0,-1));
        //SET POSITIONS
        //getSpikeBall().setPosition(new Vec2(1, -11));
      //  getSoldier().setPosition(new Vec2(-9, 9));

          //make lava pit
        LavaPit lavaPit2 = new LavaPit(this,(new Vec2(14,-13)));

        HalfWall wall2 = new HalfWall(this, new Vec2(11, -5));

    }

    @Override
    public boolean isComplete() {
        return Soldier.getCredits() >= 15000;
    }

    @Override
    public Image getBackground() {
        return background;

    }
    @Override
    public String getName() {
        return "Level3";
    }


    @Override
    public void populate(){
        super.populate();
        //    9/3/22 12:00 making the platforms from the newly encapsulated platform class instead


        new Chicken(this, new Vec2(9, 3));
        new Chicken(this, new Vec2(5, 5));


        BigBoss bigBoss= new BigBoss(this,game);
        bigBoss.setPosition(new Vec2(0,-1));
        //SET POSITIONS
        getSpikeBall().setPosition(new Vec2(1, -11));
        getSoldier().setPosition(new Vec2(-9, 9));

        //make lava pit
        LavaPit lavaPit2 = new LavaPit(this,(new Vec2(14,-13)));

        HalfWall wall2 = new HalfWall(this, new Vec2(11, -5));

        this.soldier= getSoldier();
    }

}
