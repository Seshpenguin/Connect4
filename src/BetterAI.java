public class BetterAI {


    public static int miniMax(int[][] gameState, int currentPlayer) {
        int index = 0, score = 0;

        // detect three in a row and place to block and return index to block
        for (int i = 0; i < 7; i++) {
            int[] pos = GameCore.dropPiece(gameState, i, (currentPlayer == 2) ? 1 : 2);
            if (pos[0] == -1) {
                continue;
            }
            if (GameValidation.checkerFunctionMethod(gameState, pos, (currentPlayer == 2) ? 1 : 2)) {
                gameState[pos[0]][pos[1]] = 0;
                return i;
            }
            gameState[pos[0]][pos[1]] = 0;
        }

        for (int i = 0; i < 7; i++) {
            int[] pos = GameCore.dropPiece(gameState, i, currentPlayer);
            if (pos[0] == -1) {
                continue;
            }
            int s = miniMaxHelper(gameState, pos, 1, 0, false);
            if (score < s) {
                score = s;
                index = i;
            }
            System.out.println(s);
            gameState[pos[0]][pos[1]] = 0;
        }
        return index;
    }

    public static int miniMaxHelper(int[][] gameState, int[] currentInput, int currentPlayer, int depth, boolean isAI) {
        if (depth == 6) return 0;
        // base state
        if (GameValidation.checkerFunctionMethod(gameState, currentInput, currentPlayer)) {
            return isAI ? (int)Math.pow(20, 10-depth) : ((depth == 1) ? (int)Math.pow(20, 9): -(int)Math.pow(20, depth)) ;
        }

        int score = 0;

        for (int i = 0; i < 7; i++) { 
            int[] pos = GameCore.dropPiece(gameState, i, currentPlayer);
            if (pos[0] == -1) {
                continue;
            }
            score += miniMaxHelper(gameState, pos, (currentPlayer == 1) ? 2 : 1, depth+1, !isAI);
            gameState[pos[0]][pos[1]] = 0;
        }
        return score;
    }
}