public class BetterAI {


    public static int miniMax(int[][] gameState, int alpha, int beta, int currentPlayer) {
        int index = 0, score = 0;
        for (int i = 0; i < 7; i++) {
            int[] pos = GameCore.dropPiece(gameState, i, currentPlayer);
            if (pos[0] == -1) continue;
            int s = miniMaxHelper(gameState, alpha, beta, pos, currentPlayer, 0, false);
            if (score < s) {
                score = s;
                index = i;
            }
            gameState[pos[0]][pos[1]] = 0;
        }
        return index;
    }

    public static int miniMaxHelper(int[][] gameState, int alpha, int beta, int [] currentInput, int currentPlayer, int depth, boolean isAI) {
        if (depth == 7) return 0;
        // base state
        if (GameValidation.checkerFunctionMethod(gameState, currentInput, currentPlayer)) {
            return isAI ? 1 : 0;
        }

        int score = 0;

        for (int i = 0; i < 7; i++) { 
            int[] pos = GameCore.dropPiece(gameState, i, currentPlayer);
            if (pos[0] == -1) continue;
            score += miniMaxHelper(gameState, alpha, beta, pos, (currentPlayer == 1) ? 2 : 1, depth+1, !isAI);
            gameState[pos[0]][pos[1]] = 0;
        }
        return score;
    }
}