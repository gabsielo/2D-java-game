package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

public class Pistol extends BackpackItem{

    public Pistol(Soldier soldier) {
        super(soldier);

        image = new BodyImage("data/pistol.png",1.5f);
    }

    @Override
    public String getType() {
        return "pistol";
    }

    @Override
    public void operate() {
        System.out.println("OHhh Shots fired");
        soldier.shoot();

    }

    @Override
    public void putOn() {
        super.putOn();
        aImage.setOffset(new Vec2(0.5f,0));
    }
}
