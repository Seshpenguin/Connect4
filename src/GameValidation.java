import java.util.*;

public class GameValidation {
    static boolean isDebug = true;
/*
    public static void main(String args[]) {
        int[][] testGrid =  new int[][] {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 2, 0, 0, 0, 0},
            {0, 1, 2, 0, 0, 0, 0}
        };
        int currentPlayerID = 1;
        int[] userInput = new int[] {5, 1};

        System.out.println(checkerFunctionMethod(testGrid, userInput, currentPlayerID));
    }
*/
    public static boolean checkerFunctionMethod(int[][] seshanIsLazy, int[] inputCord, int currentID) {

        String tempHor = "";
        String tempVer = "";
        String tempDiaA = stringDiagonalA(inputCord, seshanIsLazy);
        String tempDiaB = stringDiagonalB(inputCord, seshanIsLazy);
        
        for (int i = 0; i < 7; i++) {
            tempHor += Integer.toString(seshanIsLazy[inputCord[0]][i]);
            if(isDebug) System.out.println(tempHor);
        }
        for (int i = 0; i < 6; i++) {
            tempVer += Integer.toString(seshanIsLazy[i][inputCord[1]]);
            if(isDebug) System.out.println(tempVer);
        }

        boolean connect4 = false;
        
        if (repeatCounter(currentID, tempDiaA) || repeatCounter(currentID, tempDiaB) || repeatCounter(currentID, tempHor) || repeatCounter(currentID, tempVer)) {
            connect4 = true;
        } else {
            connect4 = false;
        }

        return connect4;
    }

    //To check the connect 4
    public static boolean repeatCounter(int playerID, String stringTOCheck) {
        String ID = Integer.toString(playerID);
        String targetString = "";
        for (int i = 0; i < 4; i++) {
            targetString += ID;
        }
        
        return stringTOCheck.matches("(.*)" + targetString +"(.*)");
    }

    public static String stringDiagonalA (int[] inputCord, int[][] seshanIsLazy) {
        int x = inputCord[1];
        int y = inputCord[0];
        
        String finalString = "";
        if (y < x) {
            x -= inputCord[0];
            y -= inputCord[0];
        } else {
            x -= inputCord[1];
            y -= inputCord[1];
        }
        while(y < 6 && x < 7) {
                finalString += seshanIsLazy[y][x];
                if(isDebug) System.out.println(y + " " + x + " " + finalString);
                y++;
                x++;
            }

        return finalString;
    }

    public static String stringDiagonalB (int[] inputCord, int[][] seshanIsLazy) {
        int x = inputCord[1];
        if(isDebug) System.out.println(x);
        int y = inputCord[0];
        if(isDebug) System.out.println(y);
        String finalString = "";
        if(isDebug) System.out.println(finalString);

        while(x > 0 && y < 5) {
            x--;
            y++;
        }

        while(y >= 0 && x < 7) {
            if(isDebug) System.out.println(y + " " + x);

                finalString += seshanIsLazy[y][x];
                if(isDebug) System.out.println(y + " " + x + " " + finalString);
                y--;
                x++;
            }
        return finalString;
    }
}