package game;

import city.cs.engine.*;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {
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
