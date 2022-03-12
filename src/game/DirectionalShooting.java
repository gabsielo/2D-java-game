package game;

import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DirectionalShooting implements MouseListener {
    private Soldier soldier;
    private GameView view;

    public DirectionalShooting(Soldier s, GameView v){
        soldier = s;
        view = v;
    };

    @Override
    public void mouseClicked(MouseEvent e) {
        Vec2 worldPoint = view.viewToWorld(e.getPoint());
        soldier.shoot(worldPoint);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
