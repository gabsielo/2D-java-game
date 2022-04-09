package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InventoryManager {

    private JButton sellButton;
    private JButton buyButton;
    private Game game;
    GameView view;
   public JPanel inventoryMainPanel;
    private JPanel itemsPanel;

    private static SoundClip kaching;

    static {
        try {
            kaching = new SoundClip("data/kaching.mp3");   // Open an audio input stream
            //  skra.play();                              // Set it to  play
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }


    public InventoryManager(GameView view, Game game){
        this.game = game;
        this.view= view;

        itemsPanel.add(new InventoryGUIItem("jetpack","data/jetpack.png"));
        itemsPanel.add(new InventoryGUIItem("pistol","data/pistol.png"));

        buyButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                Soldier.decreaseCredits(100);
                kaching.play();

            }
        });
    }


    public JPanel getMainPanel(){

        return inventoryMainPanel;

    }

}