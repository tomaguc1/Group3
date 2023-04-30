package Helpers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
public class Music {
    public Music(String text) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    File file4 = new File("./src");
        for(String fileNames : file4.list()) System.out.println(fileNames);

    Scanner scanner = new Scanner(text);

    File file = new File("./src/main/java/Helpers/PIRATE.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    clip.open(audioStream);

    File file2 = new File("./src/main/java/Helpers/MARIO.wav");
    AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
    Clip clip2 = AudioSystem.getClip();
    clip2.open(audioStream2);

    File file3 = new File("./src/main/java/Helpers/GOOFY.wav");
    AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
    Clip clip3 = AudioSystem.getClip();
    clip3.open(audioStream3);


    String response = "";





    while(!response.equals("QUIT")) {
            System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
            System.out.print("Enter your choice: ");

            response = scanner.next();
            System.out.println(response);
            response = response.toUpperCase();

            switch(response) {
                case ("PIRATE"):
                    clip.start();
                    clip2.stop();
                    clip3.stop();
                    break;
                case ("MARIO"): clip2.start(); clip.stop(); clip3.stop();
                    break;
                case ("GOOFY"): clip3.start(); clip.stop(); clip2.stop();
                    break;
                case ("STOP"): clip.stop(); clip2.stop(); clip3.stop();
                    break;
                //case ("RESTART"): clip.setMicrosecondPosition(0);
                //    break;
                case ("QUIT"): clip.close();
                    break;
                default: System.out.println("Not a valid response");
            }

        }


      System.out.println("Byeeee!");
}
}


