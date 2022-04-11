package game;

import city.cs.engine.*;
import city.cs.engine.DynamicBody;

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


   // public static GameLevel load(String filename){


   // }


}
