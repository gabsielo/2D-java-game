package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;





    public class BulletCollision implements CollisionListener {
    //    private DynamicBody projectile;

       public BulletCollision(    //DynamicBody projectile
       ) {
      //   projectile= this.projectile;
        }

        @Override
        public void collide(CollisionEvent collisionEvent) {

            if (collisionEvent.getOtherBody() instanceof Terrorist)
                collisionEvent.getOtherBody().destroy();

            else if (collisionEvent.getOtherBody() instanceof SpikeBall)
                collisionEvent.getOtherBody().destroy();

            else if (collisionEvent.getOtherBody() instanceof Food)
                collisionEvent.getOtherBody().destroy();

            else if (collisionEvent.getOtherBody() instanceof Zoot)
                collisionEvent.getOtherBody().destroy();
            else if (collisionEvent.getOtherBody() instanceof Destroyable)
                collisionEvent.getOtherBody().destroy();
        }

    }




