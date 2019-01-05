public class GUIHelpers {
    public static String[] DisplayMainMenu() throws Exception {
        System.out.println("Displaying the main menu...");
        MenuGUI menu = new MenuGUI();

        while(menu.isWatingForUserInput()) {
            Thread.sleep(500); // Prevents the loop from taking 100% CPU.
            HelperMethods.debugPrintln(menu.isWatingForUserInput() + " is the value.");
        }
        // Pause until the user presses play.
        System.out.println("It's time to play Connect 4!");

        // Get the values from the GUI (using getter methods):


        String[] methodReturns = {"test", "temp"};
        return methodReturns;
    }

    public static String[] DisplayGameGUI(String type) throws Exception {
        GameGUI game = new GameGUI();
        String[] methodReturns = {"test", "temp"};
        return methodReturns;
    }
}
