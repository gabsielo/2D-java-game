package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;



public class EnemyCollisionListener implements CollisionListener {

    private Soldier soldier;

    public EnemyCollisionListener(Soldier soldier){
        this.soldier = soldier;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Terrorist) {
            soldier.setHealthLevel (soldier.getHealthLevel()-1);
            e.getOtherBody().destroy();
        }
    }
}