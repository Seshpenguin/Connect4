/*
 * Connect 4 for ICS4U
 * by Seshan, Jack, and Kevin
 */
public class Main {
    public static void main(String[] args) throws Exception{
        HelperMethods.debugMode = true; // Turn debug mode on or off.
        System.out.println("Welcome to Connect 4!");

        String[] menuOptions = GUIHelpers.DisplayMainMenu();

        // Start the game based on user's selection:
        if(menuOptions[1].equals("")) {

        }

        System.out.println(menuOptions[1]);

        //debug
        String[] gameResult = GUIHelpers.DisplayGameGUI("test");
    }
}
