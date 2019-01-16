/*
 * Connect 4 for ICS4U
 * by Seshan, Jack, and Kevin
 */

/*
    Copyright (C) 2018 Seshan Ravikumar

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        HelperMethods.debugMode = false; // Turn debug mode on or off.
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

        int gameType = 0;
        int aiType = 0;
        if(menuOptions[0] == 1) {
            gameType = 1;
            aiType = 0;
        } else if (menuOptions[0] == 2) {
            gameType = 2;
            aiType = 1;
        } else if (menuOptions[0] == 3) {
            gameType = 2;
            aiType = 2;
        }

        GameCore.startGame(gameType, aiType);

        // Start the game based on user's selection:

        System.out.println(menuOptions[1]);

        //debug
        //String[] gameResult = GUIHelpers.DisplayGameGUI("test");
    }
}
