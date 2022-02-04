package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {
/*Mason Greenwood */

    /** Initialise a new Game. */
    public Game() {

        //1. make an empty game world
        World world = new World();

        //2. populate it with bodies (ex: platforms, collectibles, characters)

        //make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(world, platformShape);
        platform1.setPosition(new Vec2(-8, -1f));

        //make the second suspended platform
        StaticBody platform2 = new StaticBody(world, platformShape);
        platform2.setPosition(new Vec2(8, 0.5f));
        platform2.setAngleDegrees(30);

        //make the wall1 (left wall)
        Shape wallShape = new BoxShape(0.5f,10);
        StaticBody wall1= new StaticBody(world,wallShape);
        wall1.setPosition(new Vec2(-10,-1));


        //make the wall2( right wall2)
        StaticBody wall2 = new StaticBody(world,wallShape);
        wall2.setPosition(new Vec2(10,-1));


        //make a character (with an overlaid image)
        Shape studentShape = new BoxShape(1,2);
        DynamicBody student = new DynamicBody(world, studentShape);
        student.setPosition(new Vec2(4,-5));
        student.addImage(new BodyImage("data/student.png", 5));
        student.setAlwaysOutline(true);
;

        //3. make a view to look into the game world
        UserView view = new UserView(world, 500, 500);


        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
     //    JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
