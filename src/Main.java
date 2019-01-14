/*
 * Connect 4 for ICS4U
 * by Seshan, Jack, and Kevin
 */
public class Main {
    public static void main(String[] args) throws Exception{
        HelperMethods.debugMode = true; // Turn debug mode on or off.
        if(HelperMethods.debugMode) {
            GameValidation.isDebug = true;
        } else {
            GameValidation.isDebug = false;
        }

        System.out.println("Welcome to Connect 4!");
        System.out.println(System.getProperty("user.dir") + "/assets/red.png");

        int[] menuOptions = GUIHelpers.DisplayMainMenu();
        if(menuOptions[0] == -1) {
            HelperMethods.debugPrintln("Gamemode not found: ERROR");
        }
        GameCore.startGame(menuOptions[0]);

        // Start the game based on user's selection:

        System.out.println(menuOptions[1]);

        //debug
        //String[] gameResult = GUIHelpers.DisplayGameGUI("test");
    }
}
