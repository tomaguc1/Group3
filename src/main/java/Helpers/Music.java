package Helpers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
public class Music {
    public Music(String text) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    Scanner scanner = new Scanner(text);

    File file = new File("PIRATE.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();

    File file2 = new File("MARIO.wav");
    AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
    Clip clip2 = AudioSystem.getClip();
    clip2.open(audioStream2);

    File file3 = new File("GOOFY.wav");
    AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
    Clip clip3 = AudioSystem.getClip();
    clip3.open(audioStream3);


    String response = "";


    while(!response.equals("Q")) {
            System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
            System.out.print("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();

            switch(response) {
                case ("PIRATE"): clip.start();
                    break;
                case ("MARIO"): clip2.start();
                    break;
                case ("GOOFY"): clip3.start();
                    break;
                case ("STOP"): clip.stop();
                    break;
                case ("RESTART"): clip.setMicrosecondPosition(0);
                    break;
                case ("QUIT"): clip.close();
                    break;
                default: System.out.println("Not a valid response");
            }

        }


      System.out.println("Byeeee!");
}
}


