package game;
//line 63 and 64 temporarily redundant
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    DirectionalShooting directionalShoot;
    GameView wideView;
    private boolean gameOver;
    private boolean menuVisible;
    private ControlPanel controlPanel;
    private SettingsPanel settingsPanel;
    private JFrame frame;
    private InventoryManager  inventoryManager;



    public Game() {

       gameOver=false;
       menuVisible= true;


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
        view = new GameView(this,currentLevel, 800, 600);

        // make a second zoomed out view
        wideView = new GameView(this,currentLevel,500,100);
        wideView.setZoom(3);


        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);
        //add controller
        controller = new SoldierController(currentLevel.getSoldier(), this);
        // 28/3/ tryna add directional shooting to other levels
        directionalShoot = new DirectionalShooting(currentLevel.getSoldier(),view);
        //
        view.addKeyListener(controller);
        //add mouse buisiness
        view.addMouseListener(new GiveFocus(view));

        view.addMouseListener(new DirectionalShooting(currentLevel.getSoldier(),view));
        //MouseHandler mouseHandler = new MouseHandler(world, view);
         //   view.addMouseListener(mouseHandler);
        //4. create a Java window (frame) and add the game
        //   view to it
         frame = new JFrame("City Game");

        frame.add(view);//add normal view
        // when I add wide view to south, I can't see anything but when I add it to North, I can see it, ask charles?
        frame.add(wideView,BorderLayout.NORTH); //add bottom wide view

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



        //making control panel for game
        controlPanel = new ControlPanel(view,this);
        frame.add(controlPanel.getMainPanel(),BorderLayout.WEST);

        settingsPanel = new SettingsPanel(view,this);

        inventoryManager = new InventoryManager(view, this);












        //DEBUGGER DEBUGGER DEBUGGER DEBUGGER

        //optional: uncomment this to make a debugging view
         // JFrame debugView = new DebugViewer(currentLevel, 500, 500);

       /*    REDUNDANT 31/3/22
        // make a button
        JButton button = new JButton("ButtonLabel");
        frame.add(button,BorderLayout.EAST);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(view);
                frame.pack();
            }
        });
         */
        Tracker tracker = new Tracker(view,currentLevel.getSoldier());
        currentLevel.addStepListener(tracker);
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

            ((Level1) currentLevel).getGameMusic().stop();

            currentLevel = new Level2(this);

            view.setWorld(currentLevel);
            wideView.setWorld(currentLevel);
            wideView.setZoom(3);

            currentLevel.start();
            controller.updateSoldier(currentLevel.getSoldier());
            //tryna fix bullets in multiple levels 26/3

            directionalShoot.updateSoldier(currentLevel.getSoldier());
            view.addMouseListener(new DirectionalShooting(currentLevel.getSoldier(),view));
            Tracker trackerLevel1 = new Tracker(view,currentLevel.getSoldier());
            currentLevel.addStepListener(trackerLevel1);
        }

    else if (currentLevel instanceof Level2) {

        System.out.println("transition to next level");
        currentLevel.stop();

        ((Level2) currentLevel).getGameMusic().stop();

        currentLevel = new Level3(this);

        view.setWorld(currentLevel);
        currentLevel.start();
            wideView.setWorld(currentLevel);
            wideView.setZoom(3);
        controller.updateSoldier(currentLevel.getSoldier());
      //  directionalShoot.updateSoldier(currentLevel.getSoldier());
            view.addMouseListener(new DirectionalShooting(currentLevel.getSoldier(),view));
        //    JFrame debugView = new DebugViewer(currentLevel, 500, 500);
            Tracker trackerLevel2 = new Tracker(view,currentLevel.getSoldier());
            currentLevel.addStepListener(trackerLevel2);

    }

    else if (currentLevel instanceof Level3){
            System.out.println("Game done");

            System.exit(0);

        }
}

    public boolean isGameOver(){
        return gameOver;
    }

    public void setGameOver(boolean over){
        gameOver=over;
    };
    public void toggleMenu(){
        System.out.println("menu toggled");
        if(menuVisible){
          //hide menu
            frame.remove(controlPanel.getMainPanel());
            menuVisible=false;
            frame.pack();
           // currentLevel.start();
        }
        else {
            // show menu
            frame.add(controlPanel.getMainPanel(),BorderLayout.WEST);
            menuVisible = true;
            frame.pack();
          //  currentLevel.stop();
        }
    };


    public void transitionToSettings(){
        frame.remove(controlPanel.getMainPanel());
        frame.add(settingsPanel.mainPanel,BorderLayout.WEST);
        frame.pack();
    }
    public void transitionToMain(){
        frame.remove(settingsPanel.getMainPanel());
        frame.add(controlPanel.getMainPanel(),BorderLayout.WEST);
        frame.pack();
    }
    public void transitionToInventory(){
        frame.remove(controlPanel.getMainPanel());
        frame.add(inventoryManager.mainPanel,BorderLayout.WEST);
        frame.pack();
    }

}
