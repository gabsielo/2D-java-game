package game;

public class Jetpack extends BackpackItem{

    @Override
    public String getType() {
        return "jetpack";

    }

    @Override
    public void operate() {
        System.out.println("fly");
    }
}
