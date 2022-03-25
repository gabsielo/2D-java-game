package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bomb implements ActionListener {
 private static final BodyImage bombImage =
         new BodyImage("data/unexplodedBomb.png", 2f);

 private static final BodyImage explosionImage =
         new BodyImage("data/explosion.png", 6f);

 private DynamicBody bomb;
 private DynamicBody explosion;
 private int counter;

 public Bomb(World world, Vec2 pos, int detonationTime) {

  bomb = new DynamicBody(world, new CircleShape(1));
  bomb.addImage(bombImage);
  bomb.setPosition(pos);
  counter=0;

  Timer t = new Timer(detonationTime, this);
  t.setRepeats(false);
  t.start();


 }

 @Override
 public void actionPerformed(ActionEvent e) {
  System.out.println("BOOM");
  if (counter==0) {
   bomb.destroy();


   explosion = new DynamicBody(bomb.getWorld(), new CircleShape(3));
   explosion.addImage(explosionImage);
   explosion.setPosition(bomb.getPosition());
   Timer t2 = new Timer(800, this);
   t2.setRepeats(false);
   t2.start();
  }
  else if (counter ==1){
   explosion.destroy();
  }
  counter++;
 }
}
