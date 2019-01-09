import javax.sound.sampled.BooleanControl;
import java.util.*;

public class test {
    static boolean isDebug = true;
    public static void main(String args[]) {
        int[][] testGrid =  new int[][] {
            {0, 1, 2, 2, 2, 2, 1},
            {},
            {},
            {},
            {},
            {}
        };
        int currentPlayerID = 2;
        int[] userInput = new int[] {4,5};

        System.out.println(checkerFunctionMethod(testGrid, userInput, currentPlayerID));
    }

    public static boolean checkerFunctionMethod(int[][] seshanIsLazy, int[] inputCord, int currentID) {
        boolean connect4 = false;
        String[][] stringGrid = new String[7][7];
        for (int i = 0; i < seshanIsLazy.length; i++) {
            for (int j = 0; j < seshanIsLazy[i].length; j++) {
                if (seshanIsLazy[i][j] == 1) {
                    stringGrid[i][j] = "a";
                } if (seshanIsLazy[i][j] == 2) {
                    stringGrid[i][j] = "b";
                } else {
                    stringGrid[i][j] = "n";
                }
            }
        }

        String tempHor = "";
        String tempVer = "";
        String tempDiaA = "";
        String tempDiaB = "";

        for (int i = 0; i < 7; i++) {
            tempHor += stringGrid[inputCord[0]][i];
        }
        for (int i = 0; i < 6; i++) {
            tempVer += stringGrid[i][inputCord[1]];
        }
        int count = 0;
        
        int x = 0;
        int y = 0;
        
        //Going NW
        count = 0;
        do {
            y = inputCord[0];
            x = inputCord[1];
            tempDiaA = stringGrid[y][x] + tempDiaA;
            count++;
            y -= count;
            x -= count; 
        } while (x < 0 || y < 0);

        //Going SE
        count = 0;
        do {
            y = inputCord[0];
            x = inputCord[1];
            count++;
            x = x + count;
            y = y + count;
            while(isDebug) System.out.println(x + ", " + y + ", " + tempDiaA);
            tempDiaA = tempDiaA + stringGrid[y][x];
            while(isDebug) System.out.print(tempDiaA);
        } while (y < 6 || x < 7);

        //Going NE
        count = 0;
        do {
            y = inputCord[0];
            x = inputCord[1];
            count++;
            y -= count;
            x += count;
            tempDiaB = tempDiaB + stringGrid[y][x];
        } while (x < 7 || y < 6);

        //Going SW
        count = 0;
        do {
            y = inputCord[0];
            x = inputCord[1];
            tempDiaB = stringGrid[y][x] + tempDiaB;
            count++;
            y += count;
            x -= count;
        } while (x < 7 || y < 6);

        String playerID = "";
        if (currentID == 1) {
            playerID = "a";
        } else {
            playerID = "b";
        }
        
        if (repeatCounter(playerID, tempDiaA) == 4 || repeatCounter(playerID, tempDiaB) == 4 || repeatCounter(playerID, tempHor) == 4 || repeatCounter(playerID, tempVer) == 4) {
            connect4 = true;
        } else {
            connect4 = false;
        }

        return connect4;
    }

    //To check the connect 4
    public static int repeatCounter(String playerID, String stringTOCheck) {
        int counter = 1;
        char currentID = playerID.charAt(0);
        for (int i = 0; i < stringTOCheck.length()-1; i ++) {
            if (stringTOCheck.charAt(i) == stringTOCheck.charAt(i+1) && stringTOCheck.charAt(i) == currentID) {
                counter++;
            } else {
                counter = 1;
            }
        }
        return counter;
    }
}