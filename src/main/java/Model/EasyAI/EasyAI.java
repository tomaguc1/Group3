package Model.EasyAI;

import java.util.Random;
import java.util.ArrayList;

public class EasyAI {
    public static void main(String[] args) {
        
    }

    public void setShips(){
        ArrayList<String> coordinates = new ArrayList<String>();
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                coordinates.add("(" + x + "," + y + ")");
            }
        }
        Random rand = new Random();
        int min = 0;
        int max = 99;
        int i=0;

    	while(i <= 5) {
            int testing = rand.nextInt(max - min + 1) + min;//random number for a coordinate in the array

            if(coordinates.get(testing) != null) {
                //method to set ship
                coordinates.set(testing, null);// Removes the space from the array, keeps array length
            }else{
                i=i-1;
                }
            i++;
            }
    	}
    	


    public void setMissile(){
        ArrayList<String> coordinates = new ArrayList<String>();
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                coordinates.add("(" + x + "," + y + ")");
            }
        }
        Random rand = new Random();


        int i=0;
        while(i < 100 ) {

            int min = 0;
            int max = 99-i;

            int rCoordinate = rand.nextInt(max - min + 1) + min;//random number for a coordinate in the array

            if(coordinates.get(rCoordinate) != null){//an array containing all the coordinates in which enemy ships are placed) {
                //method to set missile
                coordinates.remove(rCoordinate);// Removes the space from the array, reduces array length
                //end turn
            }else{
            //method to set missile
            coordinates.remove(rCoordinate);// Removes the space from the array, reduces array length
            //continue turn

            }i++;
    }


}}
