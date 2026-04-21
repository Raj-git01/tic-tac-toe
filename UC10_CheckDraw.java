/**
 * UC10 - Detect Draw
 *
 * Goal: Detect when no moves remain and no winner exists.
 * Actor: Game System
 * Flow: Board checked -> no empty cells -> draw declared.
 *
 * Key Concepts:
 *   1. Counting Logic
 *   2. Loop Traversal
 *   3. Boolean Flags
 */
public class UC10_CheckDraw {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'X', 'O', 'O'},
        {'O', 'X', 'X'}
    };

    static boolean hasWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    /**
     * Detects draw using loop traversal and boolean flags.
     *
     * @return true if board is full and there is no winner
     */
    static boolean isDraw() {
        int emptyCells = 0;        // Counting logic
        boolean boardFull;
        boolean winnerFound;

        for (int r = 0; r < 3; r++) { // Loop traversal
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-') {
                    emptyCells++;
                }
            }
        }

        boardFull = (emptyCells == 0);
        winnerFound = hasWinner('X') || hasWinner('O'); // Boolean flags

        return boardFull && !winnerFound;
    }

    static void printBoard() {
        System.out.println("\nBoard:");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c]);
                if (c < 2) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("===== UC10: DETECT DRAW =====");
        printBoard();

        if (isDraw()) {
            System.out.println("Game result: Draw.");
        } else {
            System.out.println("Game result: Not a draw.");
        }

        System.out.println("=============================");
    }
}
