package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;


public class LavaPit extends StaticBody implements SensorListener, StepListener{

    private static final Shape pitShape = new BoxShape(3, 1f);
    private final Sensor pitSensor;
    private GhostlyFixture pitView;
    private final BodyImage lavaPitImage = new BodyImage("data/LavaPit.png",2.5f);
    private final Soldier soldier;
    private final GameLevel world;
    private boolean inLava;

    /* add position to lava pit constructor parameter
    set po

     */

    public LavaPit(GameLevel w, Vec2 position) {
        super(w);
        pitSensor = new Sensor(this, pitShape);
        this.setPosition(position);

        pitSensor.addSensorListener(this);

        this.addImage(lavaPitImage);
       // pitView = new GhostlyFixture(this,pitShape);
        //this.setFillColor(Color.RED);
        world = w;
        this.soldier = world.getSoldier();
        this.inLava= false;
        w.addStepListener(this);
    }


    @Override
    public void beginContact(SensorEvent sensorEvent) {

        inLava= true;

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

        inLava= false;

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        // This method runs regardless of what is in the lava pit this means enemies in lava will also decrease
        //soldier health

        if (inLava){



            Soldier.decreaseHealthLevel(1);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
