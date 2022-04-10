
package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;



public class LevelCompleteListener implements CollisionListener {


    private Soldier soldier;
    GameLevel currentLevel;
    Game game;
    public LevelCompleteListener(GameLevel level, Game game) {
        currentLevel= level;
        this.game=game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Terrorist) {
            if (currentLevel.isComplete())
                game.goToNextLevel();

        } else if (e.getOtherBody() instanceof SpikeBall)
        {
            if (currentLevel.isComplete())
                game.goToNextLevel();

        } else if (e.getOtherBody() instanceof Food)
        {
            if (currentLevel.isComplete())
                game.goToNextLevel();

        }
        else if (e.getOtherBody() instanceof Wall|| e.getOtherBody() instanceof HalfWall)
        {
            if (currentLevel.isComplete())
                game.goToNextLevel();

        }
        else if (e.getOtherBody() instanceof Wall|| e.getOtherBody() instanceof Gangster)
        {
            if (currentLevel.isComplete())
                game.goToNextLevel();

        }
    }
}