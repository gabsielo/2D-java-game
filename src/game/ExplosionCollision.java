package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;

public class ExplosionCollision implements CollisionListener {

    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Terrorist)
        collisionEvent.getOtherBody().destroy();
       else if (collisionEvent.getOtherBody() instanceof SpikeBall)
            collisionEvent.getOtherBody().destroy();

        else if (collisionEvent.getOtherBody() instanceof Destroyable)
            collisionEvent.getOtherBody().destroy();
    }
}
