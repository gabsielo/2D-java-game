package game;

import city.cs.engine.*;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    private Soldier soldier;
    private SpikeBall spikeBall;





    public static void save(String fileName, GameLevel level)
            throws IOException
    {

        boolean append = false;
        FileWriter writer = null;

        try {


            writer = new FileWriter(fileName, append);


            writer.write(level.getName()+"\n");


            for(int i=0; i<level.getDynamicBodies().size();i++){

                Body b = level.getDynamicBodies().get(i);

                if(b instanceof Chicken){
                    writer.write("Chicken" + b.getPosition().x + "," +b.getPosition().y+"\n");
                }
                else if (b instanceof Soldier){
                    writer.write("Soldier"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof LavaPit){
                    writer.write("LavaPit"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }

                else if (b instanceof Terrorist){
                    writer.write("Terrorist"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof SpikeBall){
                    writer.write("SpikeBall"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof BigBoss){
                    writer.write("BigBoss"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof Cerberus){
                    writer.write("Cerberus"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof Gangster){
                    writer.write("Gangster"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof Zoot){
                    writer.write("Zoot"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof Wall){
                    writer.write("Wall"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }
                else if (b instanceof HalfWall){
                    writer.write("HalfWall"+ b.getPosition().x+","+b.getPosition().y+"\n");
                }

            }


        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }


    public static GameLevel load(String fileName, Game game)throws IOException{
        FileReader fr = null;
        BufferedReader reader = null;

        try {

            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);


            String line = reader.readLine();
            GameLevel level = null;

            if(line.equals("Level1")){
                level = new Level1(game);
            }
            else if(line.equals("Level2")){
                level = new Level2(game);
            }
            else if(line.equals("Level3")){
                level = new Level3(game);
            }

                line = reader.readLine();


            while (line != null) {

                String[] tokens = line.split(",");

                if (tokens[0].equals("Chicken")){
                   // Chicken chicken = new Chicken(level, new Vec2(Float.parseFloat(tokens[1]),
                     //       (Float.parseFloat(tokens[2])));

                 //   chicken.setPosition(new Vec2((Float.parseFloat(tokens[1]),
                 //           Float.parseFloat(tokens[2])));
                }
               else if (tokens[0].equals("Soldier")){
                    Soldier soldier = new Soldier(level);
                    soldier.setPosition(new Vec2(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));
                  //  Soldier.setCredits(Integer.parseInt(tokens[3]));
                    level.soldier= soldier;

                }
                else if (tokens[0].equals("Terrorist")){
                   Terrorist terrorist = new Terrorist(level);
                    terrorist.setPosition(new Vec2(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));

                }

                /*
                //ask charles why its all red

                Shape shape = new BoxShape(11, 0.5f);
                StaticBody ground = new StaticBody(this, shape);

                BodyImage groundImage = new BodyImage("data/groundThin.png", 0.8f);
                ground.setPosition(new Vec2(0f, -11.5f));
                ground.addImage(groundImage);

                //soldier creation stays in GameLevel
                // make the character
                soldier = new Soldier(this);
                soldier.setPosition(new Vec2(-9,10));
                soldier.setAlwaysOutline(true);
                soldier.setLinearVelocity(new Vec2(0, 9));
                soldier.increaseCredits(15);
                this.soldier= soldier;





                // make a Terrorist
                osama = new Terrorist(this);
                osama = osama;
                osama.startWalking(osama.getTerroristWalkingSpeed() - 1);


                // trying to make 2nd terrorrist
                Terrorist a = new Terrorist(this);
                a.setPosition(new Vec2(2, -11));
                osama.setPosition(new Vec2(7,-7));
                a.startWalking(1);

                //try to make chicken bucket
                Chicken chicken1 = new Chicken(this, new Vec2(5,5));
                for (int i=0; i<5; i++){


                    Chicken KFC1 =new Chicken(this, new Vec2(i*3f,7));
                }

                Wall wall1 = new Wall(this, new Vec2(-11, -1));



                //
                //make the ball
                //experiment adding image for ball
                //make spikeBall
                spikeBall = new SpikeBall(this, new Vec2(8, -11));
                spikeBall.setPosition(new Vec2(8,-4));

                spikeBall.startWalking(spikeBall.getSpikeBallWalkingSpeed() + 1);




                //add enemy collision listener for the soldier
                SoldierCollisionListener EnemyCollision = new SoldierCollisionListener(soldier);
                soldier.addCollisionListener(EnemyCollision);

                LevelCompleteListener LevelComplete = new LevelCompleteListener(this,game);
                soldier.addCollisionListener(LevelComplete);



                // add wall collision listener for Enemy
                TerroristCollisionListener osamaWallCollision = new TerroristCollisionListener(osama);
                osama.addCollisionListener(osamaWallCollision);
                //and spikeball collsion listener
                SpikeBallCollisionListener spikeBallCollision = new SpikeBallCollisionListener(spikeBall);
                spikeBall.addCollisionListener(spikeBallCollision);
                // abu collision listener
                TerroristCollisionListener abuWallCollision = new TerroristCollisionListener(a);
                //  a.addCollisionListener(abuWallCollision);
                soldier.getBackpack().addItem(new Pistol(soldier));
                soldier.getBackpack().addItem(new Jetpack(soldier));


                 */





                line = reader.readLine();
            }
            return level;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }


}
