package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;



public class TerroristCollisionListener implements CollisionListener {

    private Terrorist osama;








    public TerroristCollisionListener(Terrorist osama) {
        this.osama = osama;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Walker)
        {
            osama.startWalking(osama.getTerroristWalkingSpeed()*-1);
        }
        /*else if (e.getOtherBody() instanceof )
        {
            osama.startWalking(osama.getTerroristWalkingSpeed()*-1);
        }
           */
    }


}