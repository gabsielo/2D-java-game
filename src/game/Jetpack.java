package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

public class Jetpack extends BackpackItem{

    public Jetpack(Soldier soldier) {
        super(soldier);

        image = new BodyImage("data/jetpack.png",1.5f);
    }

    @Override
    public void putOn() {
        super.putOn();
        aImage.setOffset(new Vec2(-1,0));
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
