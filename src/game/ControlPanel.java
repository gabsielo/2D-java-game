package game;

import javax.swing.*;

public class ControlPanel {

    private JPanel mainPanel;
    private JButton growButton;
    private JButton shrinkButton;
    private JButton quitButton;

    GameView view;

    public ControlPanel(GameView v){
        view = v;
    }





    // main panel accessor
    public JPanel getMainPanel(){

        return mainPanel;

    }


}
