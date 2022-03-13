package game;

import org.jbox2d.common.Vec2;

public class Pistol extends BackpackItem{

    public Pistol(Soldier soldier) {
        super(soldier);
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
}
