package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;



public class SoldierCollisionListener implements CollisionListener {


    private final Soldier soldier;


    public SoldierCollisionListener(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Terrorist) {
            Soldier.decreaseHealthLevel(1);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof SpikeBall) {
            Soldier.decreaseHealthLevel(2);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Food) {
            Soldier.increaseHealthLevel(2);
            e.getOtherBody().destroy();

        } else if (e.getOtherBody() instanceof Zoot) {
            Soldier.increaseHealthLevel(2);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Cerberus) {
            Soldier.decreaseHealthLevel(2);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof BigBoss) {
            Soldier.decreaseHealthLevel(2);
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof Gangster) {
            Soldier.decreaseHealthLevel(2);
            e.getOtherBody().destroy();
        }

    }
}