package game;

public class Pistol extends BackpackItem{

    @Override
    public String getType() {
        return "pistol";
    }

    @Override
    public void operate() {
        System.out.println("OHhh Shots fired");
    }
}
