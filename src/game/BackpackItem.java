package game;

public abstract class BackpackItem {
    protected Soldier soldier;
    public BackpackItem(Soldier soldier){
        this.soldier= soldier;
    };
public abstract String getType();
public abstract void operate();

}
