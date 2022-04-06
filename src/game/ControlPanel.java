package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {

    private JPanel mainPanel;
    private JButton growButton;
    private JButton shrinkButton;
    private JButton quitButton;

    GameView view;

    public ControlPanel(GameView v){
        view = v;


        growButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                view.setZoom((float) (view.getZoom()+0.3));

            }
        });
        shrinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.setZoom((float) (view.getZoom()-0.3));

            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }





    // main panel accessor
    public JPanel getMainPanel(){

        return mainPanel;

    }


}
