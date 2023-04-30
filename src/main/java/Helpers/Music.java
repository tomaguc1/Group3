package Helpers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
public class Music {
    String command;
    Clip clip;
    Clip clip2;
    Clip clip3;

    Clip clip4;



    public Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("./src/main/java/Helpers/PIRATE.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        this.clip = AudioSystem.getClip();
        clip.open(audioStream);

        File file2 = new File("./src/main/java/Helpers/MARIO.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        this.clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);

        File file3 = new File("./src/main/java/Helpers/GOOFY.wav");
        AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
        this.clip3 = AudioSystem.getClip();
        clip3.open(audioStream3);

        File file4 = new File("./src/main/java/Helpers/RICKROLL.wav");
        AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
        this.clip4 = AudioSystem.getClip();
        clip4.open(audioStream4);




    }
    public void setCommand(String command){
        this.command = command;

    }
    public void musicPlayer(String order) {
        setCommand(order);



    Scanner scanner = new Scanner(command);


    String response = "";


    response = scanner.next();

    if(!response.equals("QUIT")) {


            response = response.toUpperCase();

            switch(response) {
                case ("PIRATE"):
                    clip.start();
                    clip2.stop();
                    clip3.stop();
                    clip4.stop();


                    break;
                case ("MARIO"):
                    clip2.start();
                    clip.stop();
                    clip3.stop();
                    clip4.stop();

                    break;
                case ("GOOFY"):
                    clip3.start();
                    clip.stop();
                    clip2.stop();
                    clip4.stop();

                    break;
                case ("RICKROLL"):
                    clip4.start();
                    clip.stop();
                    clip2.stop();
                    clip3.stop();

                    break;
                case ("STOP"):
                    clip.stop();
                    clip2.stop();
                    clip3.stop();
                    clip4.stop();
                    break;
                case ("QUIT"):
                    clip.close();
                    clip2.close();
                    clip3.close();
                    clip4.close();
                    break;
                default: System.out.println("Not a valid response");
            }

        }
{


      System.out.println("Byeeee!");
}
} }


