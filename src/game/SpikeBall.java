package game;



import city.cs.engine.*;

public class SpikeBall extends Walker {


    // enemy health level declaration and methods
    private int enemyHealthLevel;
    //getter and setter
    public void setEnemyHealthLevel(int enemyHealthLevel) {
        this.enemyHealthLevel = enemyHealthLevel;
    }
    public int getEnemyHealthLevel() {
        return enemyHealthLevel;
    }


    private static final Shape soldierShape = new BoxShape(1,2);
    // soldier image
    private static BodyImage TerroristImage =
            new BodyImage("data/terroristRight.png", 4f);

    //Terrorist image palaver
    //Terrorist image getter
    public BodyImage getTerroristImage(){return TerroristImage;}

    // flip terrorist images
    public static void flipTerroristImageLeft(){ TerroristImage =
            new BodyImage( "data/TerroristRight.png",4f);};
    public static void flipTerroristImageRight(){ TerroristImage =
            new BodyImage( "data/TerroristLeft.png",4f);}

    //constructor
    public SpikeBall(World world) {
        super(world, soldierShape);
        addImage(TerroristImage);
        enemyHealthLevel=10;}




}