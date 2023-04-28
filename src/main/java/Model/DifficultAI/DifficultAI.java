package Model.DifficultAI;


import java.util.*;

public class DifficultAI {
    private final int board_size = 10;  // board size is defined
    private int[][] board = new int[board_size][board_size]; //board is defined
    
    private Set<String> remainingMoves = new HashSet<>(); //creates a private instance 
    													//variable called remainingMoves of type 
    													//Set<String> and initialises it as an empty 
    													//HashSet
    
    public DifficultAI() {
        // Initialise remainingMoves set with all possible coordinates
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                remainingMoves.add(i + "," + j);
            }
        }
    }

    public void updateBoard(int x, int y, boolean hit) { //verify "hit"
        // Update grid with result of last move
    	board[x][y] = hit ? 1 : -1;
        remainingMoves.remove(x + "," + y);
    }

    public int[] getNextMove() { //decides next move
        // Calculate Probability Density Function for each remaining move
    	
    	/**
    	 * creates map object which stores key value pairs
    	 * Initialized to an empty hashmap
    	 */
        Map<String, Double> moveProbs = new HashMap<>();  
        												
        for (String move : remainingMoves) {
            int x = Integer.parseInt(move.split(",")[0]);
            int y = Integer.parseInt(move.split(",")[1]);
            double prob = getPDF(x, y);
            moveProbs.put(move, prob);
        }
        
        // Choose move with highest PDF value
        String bestMove = Collections.max(moveProbs.entrySet(), Map.Entry.comparingByValue()).getKey();
        int[] nextMove = {Integer.parseInt(bestMove.split(",")[0]), Integer.parseInt(bestMove.split(",")[1])};
        return nextMove;
    }
    
    private double getPDF(int x, int y) {
        // Calculate PDF for a given coordinate
        int adjHits = 0, adjMisses = 0, adjUnknowns = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(board_size - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(board_size - 1, y + 1); j++) {
                if (board[i][j] == 1) {
                    adjHits++;
                } else if (board[i][j] == -1) {
                    adjMisses++;
                } else {
                    adjUnknowns++;
                }
            }
        }
        return (double) adjHits / (adjHits + adjMisses + adjUnknowns);
    }
}
