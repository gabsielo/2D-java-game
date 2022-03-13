package game;

import org.jbox2d.common.Vec2;

public class Jetpack extends BackpackItem{

    public Jetpack(Soldier soldier) {
        super(soldier);
    }

    @Override
    public String getType() {
        return "jetpack";

    }

    @Override
    public void operate() {
        System.out.println("fly");
        soldier.setLinearVelocity(new Vec2(0,5));
    }
}
