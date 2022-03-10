package game;

import city.cs.engine.BodyImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;

public class Ball {

//fields/objects for the class thats gonna be made on 11/3/22
    BodyImage bombImage = new BodyImage("data/unexplodedBomb.PNG", 2F);
    Shape circleShape = new CircleShape(1f);

    /*    code i havent sorted through yet at 11:28 10/3/22
    public void mousePressed(MouseEvent e) {
        //create balls and add them to world
        DynamicBody ball = new DynamicBody(world, circleShape);
        ball.addImage(bombImage);
        //get the mouse coordinates
        Point mousePoint = e.getPoint();
        //transform them to world coordinates
        Vec2 worldPoint = view.viewToWorld(mousePoint);
        //position the ball
        ball.setPosition(worldPoint);
    }
     */

    //mouse handler is gonna drop bombs till I  get bullets working

}
