import java.util.Random;

public class AICore {
    @SuppressWarnings("Duplicates")
    public static int easyAI (int[][] gameGrid) {
        // This is a very basic AI, it will do simple moves (unlike hard AI)
        int[] dropCol = new int[7]; // The AI will pick a col to drop.
        // Basically each column will get a weight for the current game state, and the one
        // with the highest weight will be the one the AI picks.

        for(int i = 0; i < dropCol.length; i++) {
            Random random = new Random();
            dropCol[i] = random.nextInt(4);
        }

        // "Mimics" the players move (if this col has lots of P1, weight it more)
        for(int row = 0; row < gameGrid.length; row++) {
            for(int col = 0; col < gameGrid[row].length; col++) {
                if(gameGrid[row][col] == 1) {
                    dropCol[col]++;
                }
            }
        }

        // Weight the spots next to where there is a lot of player 1
        int[] colCounter = new int[7];
        for(int row = 0; row < gameGrid.length; row++) {
            for(int col = 0; col < gameGrid[row].length; col++) {
                if(gameGrid[row][col] == 1) {
                    colCounter[col] = colCounter[col] + 1;

                }
            }
        }
        int highestCol = 0;
        int highestColIndex = 0;
        for(int i = 0; i < colCounter.length; i++) {
            if (highestCol < colCounter[i]) {
                highestCol = colCounter[i];
                highestColIndex = i;
            }
        }
        if(highestColIndex != 0) {
            dropCol[highestColIndex-1] = dropCol[highestColIndex-1] + 1;
        }
        if(highestCol != 6) {
            dropCol[highestColIndex+1] = dropCol[highestColIndex+1] + 1;
        }


        // The middle gets a bit of a higher weight too:
        dropCol[3] = dropCol[3] + 2;

        // Finally any column that is full should be weighted 0
        for(int i = 0; i < dropCol.length; i++) {
            if(gameGrid[0][i] != 0) {
                dropCol[i] = 0;
            }
        }


        // Find the highest weighted column and drop it!
        int bestCol = 0;
        int bestColIndex = 0;
        for(int i = 0; i < dropCol.length; i++ ) {
            if(dropCol[i] > bestCol) {
                bestCol = dropCol[i];
                bestColIndex = i;
            }
        }


        return bestColIndex; // This is the column the AI decided to drop the piece.
    }
}
