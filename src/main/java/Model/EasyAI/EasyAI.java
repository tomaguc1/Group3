package Model.EasyAI;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class EasyAI {
    public static void main(String[] args) {
        
    }
    
    public void test(){
    	List<String> coordinates = new ArrayList<>();
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                coordinates.add("(" + x + "," + y + ")");
                }
            }
           
    	Random r = new Random();
    	int i = 100;
    	while(i > 95) {
    		int testing = r.nextInt(i);
    		coordinates = coordinates.remove(testing);
    		i = i - 1;
    		
    	}
    	
    	
    }
  
}
