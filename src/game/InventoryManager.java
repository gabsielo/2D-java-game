package game;

import javax.swing.*;

public class InventoryManager {

    private JButton sellButton;
    private JButton buyButton;
    private Game game;
    GameView view;
   public JPanel mainPanel;


    public InventoryManager(GameView view, Game game){
        this.game = game;
        this.view= view;

    }


    public JPanel getMainPanel(){

        return mainPanel;

    }

}