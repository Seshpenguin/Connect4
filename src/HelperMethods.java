public class HelperMethods {
    public static boolean debugMode = false;
    public static void debugPrintln(String s) {
        // This method will print a message only if debug mode is on.
        if(debugMode){
            System.out.println("[DEBUG] " + s);
        }
    }
}
