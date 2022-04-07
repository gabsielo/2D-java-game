package game;
import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;


public class LavaPit extends StaticBody implements SensorListener, StepListener{

    private static final Shape pitShape = new BoxShape(3, 1f);
    private Sensor pitSensor;
    private GhostlyFixture pitView;
    private BodyImage lavaPitImage = new BodyImage("data/LavaPit.png",2.5f);
    private Soldier soldier;
    private GameLevel world;
    private boolean inLava;


    public LavaPit(GameLevel w) {
        super(w);
        pitSensor = new Sensor(this, pitShape);
        pitSensor.addSensorListener(this);

        this.addImage(lavaPitImage);
       // pitView = new GhostlyFixture(this,pitShape);
        //this.setFillColor(Color.RED);
        world = (GameLevel) w;
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

            // my soldiers health methods are not this one and are static so ill just keep this in the rare
            // off chance ill need to make health an instance variable rather than class variable
            //student.setHealth(student.getHealth()-1)

            Soldier.decreaseHealthLevel(1);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
