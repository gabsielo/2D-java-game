package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2 extends GameLevel {
    private SoundClip gameMusic;
    Image background;
    int targetCredits = 3000;

    public SoundClip getGameMusic() {
        return gameMusic;
    }

    public Level2(Game game) {
        super(game);


        background = new ImageIcon("data/councilEstate.jpeg").getImage();


        try {
            gameMusic = new SoundClip("data/lightWorkClean.mp3");   // Open an audio input stream
            gameMusic.setVolume(0.3);
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
        new Chicken(this, new Vec2(9, 3));
        new Chicken(this, new Vec2(5, 5));
        for (int i = 0; i < 10; i++) {


            Chicken KFC1 = new Chicken(this, new Vec2(i * 0.5f, i + 4));
        }

        //add wall
        // Wall wall2 = new Wall(this, new Vec2(11, -1));
        //changing to half wall
        HalfWall wall2 = new HalfWall(this, new Vec2(11, -11));
        Platform groundForRegenPitPlatform6 = new Platform(this, new Vec2(14, -15f), 0);


        int j = 0;
        while (j < 10) {
            for (int i = 0; i < 10; i++) {
                Zoot zoot1 = new Zoot(this, new Vec2(i * 4 * 1f, j));
                zoot1.setAngleDegrees(i * j * j * j % 40);
                Zoot zoot2 = new Zoot(this, new Vec2(-i * 4 * 1f, -j + 5));
                zoot2.setAngleDegrees(180 - (i * j * j * j % 40));
                Zoot zoot3 = new Zoot(this, new Vec2(i * 4 * 1f, -j + 5));
                zoot3.setAngleDegrees(i * j * j * j % 40);
                Zoot zoot4 = new Zoot(this, new Vec2(-i * 4 * 1f, j));
                zoot4.setAngleDegrees(180 - (i * j * j * j % 40));
            }
            j++;
        }
        ;

        RegenPit regenPit = new RegenPit(this, (new Vec2(14, -11)));
        regenPit.setPosition(new Vec2(14, -11));

        //SET POSITIONS
        //  getSpikeBall().setPosition(new Vec2(1,-11));
        //  getSoldier().setPosition(new Vec2(-9, -11));

        Gangster bis = new Gangster(this);
        bis.setPosition(new Vec2(4, -11));
        Gangster blanco = new Gangster(this);
        blanco.setPosition(new Vec2(0, -11));


    }


    @Override
    public boolean isComplete() {
        if (Soldier.getCredits() >= 1500) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Image getBackground() {
        return background;

    }

    @Override
    public String getName() {
        return "Level2";
    }

    @Override
    public void populate() {
        super.populate();
        //    9/3/22 12:00 making the platforms from the newly encapsulated platform class instead
        Platform platform1 = new Platform(this, new Vec2(-3, -5f), 0);
        //make the second suspended platform
        Platform platform2 = new Platform(this, new Vec2(3, 2f), 30);
        new Chicken(this, new Vec2(9, 3));
        new Chicken(this, new Vec2(5, 5));
        for (int i = 0; i < 10; i++) {


            Chicken KFC1 = new Chicken(this, new Vec2(i * 0.5f, i + 4));
        }

        //add wall
        // Wall wall2 = new Wall(this, new Vec2(11, -1));
        //changing to half wall
        HalfWall wall2 = new HalfWall(this, new Vec2(11, -11));
        Platform groundForRegenPitPlatform6 = new Platform(this, new Vec2(14, -15f), 0);


        int j = 0;
        while (j < 10) {
            for (int i = 0; i < 10; i++) {
                Zoot zoot1 = new Zoot(this, new Vec2(i * 4 * 1f, j));
                zoot1.setAngleDegrees(i * j * j * j % 40);
                Zoot zoot2 = new Zoot(this, new Vec2(-i * 4 * 1f, -j + 5));
                zoot2.setAngleDegrees(180 - (i * j * j * j % 40));
                Zoot zoot3 = new Zoot(this, new Vec2(i * 4 * 1f, -j + 5));
                zoot3.setAngleDegrees(i * j * j * j % 40);
                Zoot zoot4 = new Zoot(this, new Vec2(-i * 4 * 1f, j));
                zoot4.setAngleDegrees(180 - (i * j * j * j % 40));
            }
            j++;
        }
        ;

        RegenPit regenPit = new RegenPit(this, (new Vec2(14, -11)));
        regenPit.setPosition(new Vec2(14, -11));

        //SET POSITIONS
        getSpikeBall().setPosition(new Vec2(1, -11));
        getSoldier().setPosition(new Vec2(-9, -11));

        Gangster bis = new Gangster(this);
        bis.setPosition(new Vec2(4, -11));
        Gangster blanco = new Gangster(this);
        blanco.setPosition(new Vec2(0, -11));


    }


}
