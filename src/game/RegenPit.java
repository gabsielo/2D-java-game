package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;


public class RegenPit extends StaticBody implements SensorListener, StepListener {

    private static final Shape pitShape = new BoxShape(3, 1f);
    private Sensor pitSensor;
    private GhostlyFixture pitView;
    private BodyImage regenPitImage = new BodyImage("data/RegenPit.png", 2.5f);
    private Soldier soldier;
    private GameLevel world;
    private boolean inRegen;

    /* add position to lava pit constructor parameter
    set po

     */

    public RegenPit(GameLevel w, Vec2 position) {
        super(w);
        pitSensor = new Sensor(this, pitShape);
        this.setPosition(position);

        pitSensor.addSensorListener(this);

        this.addImage(regenPitImage);
        // pitView = new GhostlyFixture(this,pitShape);
        //this.setFillColor(Color.RED);
        world = (GameLevel) w;
        this.soldier = world.getSoldier();
        this.inRegen = false;
        w.addStepListener(this);


    }


    @Override
    public void beginContact(SensorEvent sensorEvent) {

        inRegen = true;

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

        inRegen = false;

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        // This method runs regardless of what is in the lava pit this means enemies in lava will also decrease
        //soldier health

        if (inRegen) {


            Soldier.increaseHealthLevel(1);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}