package game;
//line 63 and 64 temporarily redundant
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;

/**
 * Your main game entry point
 */
public class Game {

/* Gabriel Maharaj gabriel.maharaj@city.ac.uk
    adck757 */






    /** Initialise a new Game. */


    // make soundClip field
    private SoundClip gameMusic;
    GameLevel currentLevel;
    private static Game game;
    GameView view;
    SoldierController controller;

    public Game() {


        //maeke a soundclip object before the world is created gonna
        // try put this in game world to see if it fixes the glitch
        /*
        this has been moved into the game world constructor and now it actually works there bc placing the music code
        here just leads to the song playing for a split second and then pausing straight after
         */

        //1. make an empty game world

        currentLevel = new Level1(this);



        TestTimerActionListener actionListener = new TestTimerActionListener(currentLevel);
        Timer t= new Timer(1000,actionListener);
        t.start();





        //3. make a view to look into the game world
        //UserView view = new UserView(world, 500, 500);
        view = new GameView(currentLevel, 500, 500);



        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);
        //add controller
        controller = new SoldierController(currentLevel.getSoldier());
        this.controller= controller;
        view.addKeyListener(controller);
        //add mouse buisiness
        view.addMouseListener(new GiveFocus(view));
        view.addMouseListener(new DirectionalShooting(currentLevel.getSoldier(),view));
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
        currentLevel.start();
    }


    /** Run the game. */
    public static void main(String[] args) {

       new Game();

    }
public void goToNextLevel(){



        if (currentLevel instanceof Level1) {

            System.out.println("transition to next level");
            currentLevel.stop();
            //temporarly fixing the music transition bc currentLevel.stop(); doesnt work 26/3
            ((Level1) currentLevel).getGameMusic().stop();

            currentLevel = new Level2(this);
           // tried to fix with this line but couldn't 26/3  currentLevel = this.currentLevel;
            view.setWorld(currentLevel);
            currentLevel.start();
            controller.updateSoldier(currentLevel.getSoldier());

        }
        else if (currentLevel instanceof Level2){
            System.out.println("Game done");
            System.exit(0);
        }
}


}
