package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;



public class TerroristCollisionListener implements CollisionListener {

    private final Terrorist osama;
    public TerroristCollisionListener(Terrorist osama) {
        this.osama = osama;
    }



    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Wall)
        {
            osama.reverseTerroristWalkingSpeed();
            osama.startWalking(osama.getTerroristWalkingSpeed());
        }
       // else if (e.getOtherBody() instanceof SpikeBall )
      //  {
      //      osama.reverseTerroristWalkingSpeed();
      //      osama.startWalking(osama.getTerroristWalkingSpeed());
      //  }
        else if (e.getOtherBody() instanceof Walker )
        {
            osama.reverseTerroristWalkingSpeed();
            osama.startWalking(osama.getTerroristWalkingSpeed());
        }
    }


}