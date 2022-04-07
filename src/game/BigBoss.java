package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BigBoss extends Walker implements StepListener {
        private static final float radius = 1.0f;
        private static final Shape ballShape = new CircleShape(radius);
      //  private static final BodyImage ballImage =
        //        new BodyImage("data/bowl.png", 2 * radius);

        private enum State {
            ROLL_LEFT, ROLL_RIGHT, STAND_STILL
        }

        public static final float RANGE = 10;
        private GameLevel world;
        private game.BigBoss.State state;

        public BigBoss(GameLevel world) {
            super(world, ballShape);
            this.world = world;
            // addImage(ballImage);
            state = game.BigBoss.State.STAND_STILL;
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
                if (state != game.BigBoss.State.ROLL_RIGHT) {
                    state = game.BigBoss.State.ROLL_RIGHT;
                    setAngularVelocity(-2);
                }
            } else if (inRangeLeft()) {
                if (state != game.BigBoss.State.ROLL_LEFT) {
                    state = game.BigBoss.State.ROLL_LEFT;
                    setAngularVelocity(2);
                }
            } else {
                if (state != game.BigBoss.State.STAND_STILL) {
                    state = game.BigBoss.State.STAND_STILL;
                    setAngularVelocity(0);
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
                    setAngularVelocity(2);
                    break;
                case ROLL_RIGHT:
                    setAngularVelocity(-2);
                    break;
                default: // nothing to do
            }
        }

        public void postStep(StepEvent e) {
        }

    }

