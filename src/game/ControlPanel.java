package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {

    private JPanel mainPanel;
    private JButton growButton;
    private JButton shrinkButton;
    private JButton quitButton;
    private JButton newGameButton;
    private JButton settingsButton;
    private JButton inventoryButton;
    private Game game;
    GameView view;


    public ControlPanel(GameView v, Game game){
        view = v;


        growButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                view.setZoom((float) (view.getZoom()+0.5));

            }
        });
        shrinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.setZoom((float) (view.getZoom()-0.5));

            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //transition to settings menu
                game.transitionToSettings();

            }
        });
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInventory();

            }
        });
    }





    // main panel accessor
    public JPanel getMainPanel(){

        return mainPanel;

    }


}
