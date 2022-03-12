package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

public class Soldier extends Walker {
    public static int credits;
    private String direction;



    private static final Shape soldierShape = new PolygonShape(1.5f,-1.86f, -0.53f,-1.87f, -0.79f,0.69f, -0.03f,1.71f, 1.16f,1.3f, 1.56f,-1.84f);
   // soldier image
    private static  BodyImage leftSoldierImage =
            new BodyImage("data/soldierLeft.png", 4f);
    private static  BodyImage rightSoldierImage =
            new BodyImage("data/soldierRight.png", 4f);

    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        if (speed <0){
            this.removeAllImages();
            this.addImage(leftSoldierImage);
            direction ="left";}
            else{
                this.removeAllImages();
            this.addImage(rightSoldierImage);
                direction= "right";
            }



        }



    public void walkLeft(float Speed){
    this.startWalking(Speed);
    this.removeAllImages();
    this.addImage(new BodyImage("data/soldierLeft.png",4));}




        //soldier image palava
        //soldier image getter
      /*

      CURRENTLY REDUNDANT
      public BodyImage getSoldierImage(){return soldierImage;}

            // flip soldier images
         public static void flipSoldierImageLeft(){ soldierImage =
              new BodyImage( "data/soldierLeft.png",4f);};
        public static void flipSoldierImageRight(){ soldierImage =
            new BodyImage( "data/soldierRight.png",4f);}
*/
  // constructor CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONTSTRUCTOR
    public Soldier(World world) {
        super(world, soldierShape);
        addImage(leftSoldierImage);
        credits=0;
        setHealthLevel(1000);
        direction="left";

    }
    // CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR

    // accessor and mutator for credits (PROBABLY REDUNDANT)
    public int getCredits(){return credits;}
    public void increaseCredits(int amount){credits = credits+ amount;}
    public void decreaseCredits(int amount){credits = credits- amount;}


 // Health level methods

    private int healthLevel;


        //set health level

        public void setHealthLevel(int healthLevel){
            this.healthLevel = healthLevel;
            System.out.println( healthLevel + "health left");}

      // healthLevel getter
        public int getHealthLevel(){
         return healthLevel;
         }
         //decreaseHealthLevel
        public void decreaseHealthLevel(int healthAmount){
            healthLevel= healthLevel-healthAmount;
            System.out.println(" you  got hit " + healthLevel+ "health left");
        };
        // increase healthLevel
        public void increaseHealthLevel(int healthAmount){
            healthLevel = healthLevel+healthAmount;
        }

        // making shoot method
       /*   public void shoot() {

           DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
           if (direction.equals("left")) {
               projectile.setPosition(new Vec2(this.getPosition().x - 1, this.getPosition().y));
               projectile.setLinearVelocity(new Vec2(-25, 3));

           } else if (direction.equals("right")) {
               projectile.setPosition(new Vec2(this.getPosition().x +1, this.getPosition().y));
               projectile.setLinearVelocity(new Vec2(25, 3));

           }

       } */

       public void shoot (Vec2 t){
           DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
           Vec2 dir = t.sub(this.getPosition());
           projectile.setPosition(this.getPosition().add(dir.mul(0.1f)));
           dir.normalize();

           projectile.setLinearVelocity(dir.mul(40));



       }
}
