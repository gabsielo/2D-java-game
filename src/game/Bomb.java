package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Bomb implements ActionListener {
 private static final BodyImage bombImage =
         new BodyImage("data/unexplodedBomb.png", 2f);

 private static final BodyImage explosionImage =
         new BodyImage("data/explosion.png", 6f);

      private static SoundClip wickSound;
      private static SoundClip explosionSound;
      private static SoundClip shaqBoomSound;
 static {
  try {
   wickSound = new SoundClip("data/fuse3Secs.mp3");
   wickSound.setVolume(0.3);

  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
   System.out.println(e);
  }
  try {
   explosionSound = new SoundClip("data/thermalImploder.mp3");

  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
   System.out.println(e);
  }
  try {
   shaqBoomSound = new SoundClip("data/shaqBoom.mp3");

  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
   System.out.println(e);
  }shaqBoomSound.setVolume(1.99);
 }


 private DynamicBody bomb;
 private DynamicBody explosion;
 private int counter;

 public Bomb(World world, Vec2 pos, int detonationTime) {

  bomb = new DynamicBody(world, new CircleShape(1));
  bomb.addImage(bombImage);
  bomb.setPosition(pos);
  counter=0;

wickSound.play();

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
   wickSound.stop();
   Timer t2 = new Timer(800, this);
   t2.setRepeats(false);
   t2.start();
   explosion.addCollisionListener(new ExplosionCollision());


  }
  else if (counter ==1){
 //  explosionSound.play();

   shaqBoomSound.play();
   explosion.destroy();
   wickSound.stop();



  }
  counter++;
 }
}
