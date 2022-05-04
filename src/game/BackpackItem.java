package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

public abstract class BackpackItem {
    protected Soldier soldier;
    protected BodyImage image;
    protected AttachedImage aImage;
    public BackpackItem(Soldier soldier){
        this.soldier= soldier;
    }

    public void wear(){
        soldier.removeAttachedImage(aImage);
        soldier.addImage(image);
    }
    public void putOn(){
        aImage = soldier.addImage(image);
        if (soldier.getDirection().equals("left"))

        aImage.flipHorizontal();

    }

    public void takeOff(){
        soldier.removeAttachedImage(aImage);
    }

public abstract String getType();
public abstract void operate();


}
