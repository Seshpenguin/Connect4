/*
 * ICS4U Connect 4 - GUI Helper Methods
 * These methods are for calling the GUI and to collect the data from them.
 * by Seshan
 */
public class GUIHelpers {
    public static int[] DisplayMainMenu() throws Exception {
        System.out.println("Displaying the main menu...");
        MenuGUI menu = new MenuGUI();

        while(menu.isWatingForUserInput()) { // Pause until the user presses play.
            Thread.sleep(500); // Prevents the loop from taking 100% CPU.
            HelperMethods.debugPrintln(menu.isWatingForUserInput() + " is the value.");
        }

        System.out.println("It's time to play Connect 4!");

        // Get the values from the GUI (using getter methods)
        int[] methodReturns = new int[2];
        methodReturns[0] = menu.gameType();

        return methodReturns;
    }

    public static int[] DisplayGameGUI(int type, int[][] gameGrid, int turn) throws Exception {
        // Type is the game type (1 AI or 2 PvP)
        // gameGrid is the current state of the gameboard to display
        // turn is player 1 or 2 turn (always 2 being handled as AI)

        GameGUI game = new GameGUI(type, gameGrid, turn);

        while(game.isWatingForUserInput()) {
            Thread.sleep(500); // Prevents the loop from taking 100% CPU.
            HelperMethods.debugPrintln(game.isWatingForUserInput() + " is the value.");
        }

        int[] methodReturns = new int[1];
        // Get and return the selected column.
        methodReturns[0] = game.getCol();

        return methodReturns;
    }

    public static void DisplayResultGUI (int winner, boolean isAI, int[][] gameGridFinal) {
        ResultGUI result = new ResultGUI(winner, isAI, gameGridFinal);

    }
}
