package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import static java.lang.Math.*;


public class TestTimerActionListener implements ActionListener {

    World world;

    public TestTimerActionListener(World w){
        world = w;
    };

private static int secondsPast;
    @Override
    public void actionPerformed(ActionEvent e) {
        secondsPast++;
        System.out.println("time"+ secondsPast );
        if (secondsPast%5 ==0) {
            Chicken chicken1 = new Chicken(world, new Vec2(5, 5));
            chicken1.setPosition(new Vec2((secondsPast * secondsPast / 2 % 10), secondsPast % 10 * -1));
        }




    }
}
