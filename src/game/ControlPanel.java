package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ControlPanel {

    public JPanel mainPanel;
    private JButton GrowButton;
    private JButton shrinkButton;
    private JButton settingsButton;
    private JButton inventoryButton;
    private final Game game;
    private final GameView view;


    public ControlPanel(GameView v, Game game){
        view = v;
        this.game=game;

        GrowButton.addActionListener(new ActionListener() {
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
      /*  quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });*/

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





    /*/ main panel accessor
    public JPanel getMainPanel(){

        return mainPanel;

    }
*/

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


}
