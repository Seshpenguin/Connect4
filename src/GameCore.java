public class GameCore {
    public static void startPvPGame() throws Exception {
        // Game States
        int currentTurn = 1; // Player 1 or 2

        // The Game Board
        int[][] gameGrid = new int[6][7];

        // Start the Game loop
        while (true) {
            HelperMethods.debugPrintln("Start of PvP Game Loop");

            // Draw the game window to the screen.
            int[] selection = GUIHelpers.DisplayGameGUI(1, gameGrid, currentTurn);

            // Drop the piece into the column


        }
    }

    // Game Helpers
    public static void dropPiece (int[][] gameGrid, int col) {
        // Calculate where to place the piece in the array.
        for(int i = 0; i < gameGrid[0].length; )
    }
}
