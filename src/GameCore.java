/*
 * ICS4U Connect 4 - Game Logic Core
 * This is where the main game logic takes place. it calls the various methods to accomplish this.
 * by Seshan
 */
public class GameCore {
    //6 x 7
    public static void startGame(int type) throws Exception {
        // Game States
        int currentTurn = 1; // Player 1 or 2

        // The Game Board
        int[][] gameGrid = new int[6][7];

        // Start the Game loop
        while (true) {
            HelperMethods.debugPrintln("Start of Game Loop");

            if(currentTurn == 1) {
                HelperMethods.debugPrintln("~~ Player 1 turn...");
                // Probe for the first players choice.
                int[] selection = GUIHelpers.DisplayGameGUI(type, gameGrid, currentTurn);
                int[] dropCoords = dropPiece(gameGrid, selection[0], currentTurn); // Drop the piece in the column

                // Check if the player has won!
                if(GameValidation.checkerFunctionMethod(gameGrid, dropCoords, currentTurn)) {
                    // Player 1 has won.
                    HelperMethods.debugPrintln("Player 1 has connected 4.");
                    GUIHelpers.DisplayResultGUI(currentTurn, false);
                    break;
                } else {
                    currentTurn = 2; // Set it to player 2's turn.
                }

            } else {
                // this will be player 2, or the AI.
                HelperMethods.debugPrintln("~~ Player 2 turn...");
                if(type == 1) { // PvP game
                    int[] selection = GUIHelpers.DisplayGameGUI(type, gameGrid, currentTurn);
                    int[] dropCoords = dropPiece(gameGrid, selection[0], currentTurn); // Drop the piece in the column
                    // Check if the player has won!
                    if(GameValidation.checkerFunctionMethod(gameGrid, dropCoords, currentTurn)) {
                        // Player 1 has won.
                        HelperMethods.debugPrintln("Player 2 has connected 4.");
                        GUIHelpers.DisplayResultGUI(currentTurn, false);
                        break;
                    } else {
                        currentTurn = 1;
                    }

                } else {
                    // probe the AI for a column.
                    // TODO
                    HelperMethods.debugPrintln("TODO: AI Play Move");
                    // GUIHelpers.DisplayResultGUI(currentTurn, true);
                    currentTurn = 1;
                }
            }
        }
    }

    // Game Helpers
    public static int[] dropPiece (int[][] gameGrid, int col, int player) {
        // Calculate where to place the piece in the array.
        // This will count from the top (0) down the array to the last empty point.
        for(int i = 0; i < gameGrid.length; i++) {
            if(gameGrid[i][col] != 0) {
                // We hit the top of the col
                gameGrid[i-1][col] = player;
                int[] returnParams = {i-1, col};
                return returnParams;
            }
        }
        // Start of game, the board is empty
        // place piece at bottom.
        gameGrid[gameGrid.length-1][col] = player;
        int[] returnParams = {gameGrid.length-1, col};
        return returnParams;
    }
}
