
package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker
    implements StepListener {

    private GameView view;
    private Soldier soldier;

    public Tracker(GameView view, Soldier soldier){
        this.view = view;
        this.soldier = soldier;
    }



    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

        view.setCentre(new Vec2(soldier.getPosition()));

    }


}
   