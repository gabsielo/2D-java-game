package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;

public class MouseHandler implements MouseListener {

    private GameWorld world;
    private GameView view;
    //mouse handler is gonna drop bombs till I  get bullets working
     BodyImage bombImage = new BodyImage("data/unexplodedBomb.PNG", 2F);
    public MouseHandler(GameWorld w, GameView v){
        world = w;
        view = v;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //create balls and add them to world
        Shape circleShape = new CircleShape(1f);
        DynamicBody ball = new DynamicBody(world, circleShape);
        ball.addImage(bombImage);
        //get the mouse coordinates
        Point mousePoint = e.getPoint();
        //transform them to world coordinates
        Vec2 worldPoint = view.viewToWorld(mousePoint);
        //position the ball
        ball.setPosition(worldPoint);
    }

    //we have to implement the other methods to satisfy
    //the interface, but we can leave them empty.

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}