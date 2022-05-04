package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BigBoss extends Walker implements StepListener , Destroyable, ActionListener {
    private static final float radius = 1.0f;
    private static final Shape bigBossShape = new PolygonShape(2.5f, -1.95f, -1.95f, -1.92f, 0.11f, 1.93f, 1.48f, 1.97f);

    private static final BodyImage bigBossImageLeft =
            new BodyImage("data/bigBossLeft.png", 6f);

    private static final BodyImage bigBossImageRight =
            new BodyImage("data/bigBossRight.png", 6f);

    private int bossHealth;


    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }

    public static final float RANGE = 10;
    private final GameLevel world;
    private game.BigBoss.State state;
    private final Game gamePara;

    public BigBoss(GameLevel world, Game gamePara) {

        super(world, bigBossShape);
        this.gamePara= gamePara;
        this.world = world;
        // addImage(ballImage);
        state = game.BigBoss.State.STAND_STILL;
        getWorld().addStepListener(this);
        this.addImage(bigBossImageLeft);
        bossHealth = 5;

    }

    public boolean inRangeLeft() {
        Body a = world.getSoldier();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;    //gap in (0,RANGE)
            /*tried to put delay so boss can charge but didnt work
            Timer leftTimer = new Timer(800, this);
            leftTimer.setRepeats(false);
            leftTimer.start();

             */
    }

    public boolean inRangeRight() {
        Body a = world.getSoldier();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;  //gap in (-RANGE, 0)
            /*tried to put delay so boss can charge but didnt work
            Timer rightTimer = new Timer(800, this);
            rightTimer.setRepeats(false);
            rightTimer.start();

             */

    }

    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != BigBoss.State.ROLL_RIGHT) {
                state = BigBoss.State.ROLL_RIGHT;
                this.startWalking(3);
                //setAngularVelocity(-2);
                this.removeAllImages();
                this.addImage(bigBossImageRight);
            }
        } else if (inRangeLeft()) {
            if (state != BigBoss.State.ROLL_LEFT) {
                state = BigBoss.State.ROLL_LEFT;
                this.startWalking(-3);
                //  setAngularVelocity(2);
                this.removeAllImages();
                this.addImage(bigBossImageLeft);
            }
        } else {
            if (state != BigBoss.State.STAND_STILL) {
                state = BigBoss.State.STAND_STILL;
                //setAngularVelocity(0);
                setLinearVelocity(new Vec2(0, 0));
            }
        }
        refreshRoll();
    }

    // use this to prevent the balls from slowing
    // down and stopping due to friction when they
    // should be rolling
    private void refreshRoll() {
        switch (state) {
            case ROLL_LEFT:
                // setAngularVelocity(2);
                startWalking(-5);
                break;
            case ROLL_RIGHT:

                // setAngularVelocity(-2);
                startWalking(5);
                break;
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void destroy() {
        if (bossHealth >=3) {
            bossHealth--;
        }
        else if (bossHealth == 2) {
            bossHealth--;
        }

        else if (bossHealth == 1){

            super.destroy();
            Soldier.increaseCredits(10000000);

            gamePara.setGameOver(true);
        }

    }
}

