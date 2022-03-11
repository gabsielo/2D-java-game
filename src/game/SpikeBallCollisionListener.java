package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;



public class SpikeBallCollisionListener implements CollisionListener {

    private SpikeBall spikeBall;

    public SpikeBallCollisionListener(SpikeBall spikeBall) {
        this.spikeBall = spikeBall;
    }



    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Wall)
        {
            spikeBall.reverseSpikeBallWalkingSpeed();
            spikeBall.startWalking(spikeBall.getSpikeBallWalkingSpeed());
        }
        else if (e.getOtherBody() instanceof Terrorist )
        {
            spikeBall.reverseSpikeBallWalkingSpeed();
            spikeBall.startWalking(spikeBall.getSpikeBallWalkingSpeed());
        }

    }
}

