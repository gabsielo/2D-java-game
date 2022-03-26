package game;
//line 63 and 64 temporarily redundant
import city.cs.engine.*;

import javax.swing.*;

/**
 * Your main game entry point
 */
public class Game {
/* Gabriel Maharaj gabriel.maharaj@city.ac.uk
    adck757 */


      /*doesnt work
    //try to getsoldier healthlevel into foreground in  game view 10/3/22 17:00
     private GameWorld
    TheGameWorld;
    public GameWorld getTheGameWorld() {
        return TheGameWorld;
    }
          */


    /** Initialise a new Game. */

    /* erronous 10/3/22 tryna make world in field
    private GameWorld  world1;

    public GameWorld getWorld1() {
        return world1;
    }
*/
    // make soundClip field
    private SoundClip gameMusic;



    public Game() {


        //maeke a soundclip object before the world is created gonna
        // try put this in game world to see if it fixes the glitch
        /*
        this has been moved into the game world constructor and now it actually works there bc placing the music code
        here just leads to the song playing for a split second and then pausing straight after
         */

        //1. make an empty game world
          GameLevel world = new GameLevel();
          // erronous 10/3/22 world1 = world;


        TestTimerActionListener actionListener = new TestTimerActionListener(world);
        Timer t= new Timer(1000,actionListener);
        t.start();





        //3. make a view to look into the game world
        //UserView view = new UserView(world, 500, 500);
        GameView view = new GameView(world, 500, 500);



        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);
        //add controller
        SoldierController controller = new SoldierController(world.getSoldier());
        view.addKeyListener(controller);
        //add mouse buisiness
        view.addMouseListener(new GiveFocus(view));
        view.addMouseListener(new DirectionalShooting(world.getSoldier(),view));
        //MouseHandler mouseHandler = new MouseHandler(world, view);
     //   view.addMouseListener(mouseHandler);
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
       //  JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
