public class BetterAI {
    public static int AI (int[][] gameBoard, int[] userInput, int aiID, int numLayers) {
        int aiMove = null;

        return aiMove;
    }

    public static int moveEvaluator(int[][] gameState, int[] currentInput, int currentPlayer, int depth) {
        boolean winState = GameValidation.checkerFunctionMethod(gameState, currentInput, currentPlayer);
        if (winState) {
            return 21 - depth;
        } else {
            return null;
        }
    }

    public static int miniMax(int[][] gameState, int alpha, int beta, int [] currentInput, int currentPlayer, int depth, boolean isAI) {
        int index = 0, score = 1e9;
        for (int i = 0; i < 7; i++) {
            int[] pos = GameCore.dropPiece(gameState, i, currentPlayer);
            if (pos[0] == -1) continue;
            int s = miniMaxHelper(gameState, alpha, beta, currentI);
            if (score > s) {
                score = s;
                index = i;
            }
            gamestate[pos[0]][pos[1]] = 0;
        }
        return index;
    }

    public static int miniMaxHelper(int[][] gameState, int alpha, int beta, int [] currentInput, int currentPlayer, int depth, boolean isAI) {
        // base state
        if (GameValidation.checkerFunctionMethod(gameState, currentInput, currentPlayer)) {
            gameState[currentInput[0]][currentInput[1]] = 0;
            return isAI ? depth : 1e9;
        }

        int score = 1e9;

        for (int i = 0; i < 7; i++) { 
            int[] pos = GameCore.dropPiece(gameState, i, currentPlayer);
            if (pos[0] == -1) continue;
            score = Math.min(miniMax(gameState, alpha, beta, pos, (currentPlayer == 1) ? 2 : 1, depth+1, !isAI), score);
            gameState[pos[0]][pos[1]] = 0;
        }
        return score;
    }
}