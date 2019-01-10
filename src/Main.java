/*
 * Connect 4 for ICS4U
 * by Seshan, Jack, and Kevin
 */
public class Main {
    public static void main(String[] args) throws Exception{
        HelperMethods.debugMode = true; // Turn debug mode on or off.
        System.out.println("Welcome to Connect 4!");

        int[] menuOptions = GUIHelpers.DisplayMainMenu();
        if(menuOptions[0] == 0) { // PvP
            GameCore.startGame(1);
        }
        // Start the game based on user's selection:

        System.out.println(menuOptions[1]);

        //debug
        //String[] gameResult = GUIHelpers.DisplayGameGUI("test");
    }
}
