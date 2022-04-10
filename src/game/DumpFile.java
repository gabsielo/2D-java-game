package game;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class DumpFile {



    public static void main(String[] args) throws IOException {



     //  HighScoreWriter writer = new HighScoreWriter("data/score.txt");
     //  writer.writeHighScore("Gabriel",69);

        HighScoreReader reader = new HighScoreReader("data/score.txt");
        reader.readScores();


       /* String fileName = "data/sample.txt";


        FileInputStream in = new FileInputStream(fileName);
        try {
            int c = in.read();
            while (c != -1) {
                System.out.println(c);
                c = in.read();
            }
        } finally {

            in.close();
        }

        */
    }



}