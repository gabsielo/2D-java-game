package game;

import javax.swing.*;

public class InventoryManager {

    private JButton sellButton;
    private JButton buyButton;
    private Game game;
    GameView view;
   public JPanel mainPanel;
    private JPanel itemsPanel;


    public InventoryManager(GameView view, Game game){
        this.game = game;
        this.view= view;

        itemsPanel.add(new InventoryGUIItem("jetpack","data/jetpack.png"));
        itemsPanel.add(new InventoryGUIItem("pistol","data/pistol.png"));
        
    }


    public JPanel getMainPanel(){

        return mainPanel;

    }

}