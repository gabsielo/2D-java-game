package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Cerberus extends Walker implements StepListener, Destroyable{
    private static final float radius = 2.0f;

  //  private static final Shape ballShape = new CircleShape(radius);
   private static final Shape cerberusShape = new BoxShape(2.25f,1.5f);
    private static final BodyImage cerberusLeftImage =
            new BodyImage("data/cerberusLeft.png", 2*radius);
          //  new BodyImage("data/cerberusLeft.png", 2*radius);
    private static final BodyImage cerberusRightImage =
            new BodyImage("data/cerberusRight.png", 2*radius);


    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }
    public static final float RANGE = 10;
    private GameLevel world;
    private State state;

    public Cerberus(GameLevel world) {
        super(world, cerberusShape );
        this.addImage(cerberusLeftImage);
        this.world= world;
       // addImage(ballImage);
        state = State.STAND_STILL;
        getWorld().addStepListener(this);
    }

    public boolean inRangeLeft() {
        Body a = world.getSoldier();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;    //gap in (0,RANGE)

    }

    public boolean inRangeRight() {
        Body a = world.getSoldier();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;  //gap in (-RANGE, 0)

    }

    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != State.ROLL_RIGHT) {
                state = State.ROLL_RIGHT;
                this.startWalking(-3);
                //setAngularVelocity(-2);
                this.addImage(cerberusRightImage);
            }
        } else if (inRangeLeft()) {
            if (state != State.ROLL_LEFT) {
                state = State.ROLL_LEFT;
                this.startWalking(3);
              //  setAngularVelocity(2);
                this.addImage(cerberusLeftImage);
            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
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
              //  setAngularVelocity(2);
                this.startWalking(-3);
                break;
            case ROLL_RIGHT:
                this.startWalking(3);
                //setAngularVelocity(-2);
                break;
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    }
}