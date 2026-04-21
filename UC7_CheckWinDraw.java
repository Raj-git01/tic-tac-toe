/**
 * UC7 - Check Win or Draw Conditions
 *
 * Goal: Evaluate the board to determine if there is a winner or if the game is a draw.
 *
 * Actor: Game System
 *
 * Flow:
 *   1. After every move, the system checks all rows, columns, and diagonals.
 *   2. If a player has 3 matching symbols in a row/col/diag, that player wins.
 *   3. If there are no empty cells and no winner, it's a draw (tie).
 *   4. Otherwise, the game continues.
 *
 * Key Concepts:
 *   1. Array Checking - evaluating specific indices of the 2D array.
 *   2. Conditional Logic - identifying matching conditions.
 */
public class UC7_CheckWinDraw {

    static char[][] board = {
        {'X', 'X', 'O'},
        {'O', 'O', 'X'},
        {'X', '-', 'O'}
    };

    /**
     * Checks if the given symbol has a winning line.
     * @param symbol 'X' or 'O'
     * @return true if the symbol has won, false otherwise
     */
    static boolean isWinner(char symbol) {
        // Check rows
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == symbol && board[r][1] == symbol && board[r][2] == symbol) {
                return true;
            }
        }
        // Check columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == symbol && board[1][c] == symbol && board[2][c] == symbol) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the board is completely filled.
     * @return true if there are no '-' cells left.
     */
    static boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Evaluates the game state.
     * @return A status message indicating the current state.
     */
    static String getGameState() {
        if (isWinner('X')) return "Player X Wins!";
        if (isWinner('O')) return "Player O Wins!";
        if (isBoardFull()) return "It's a Draw!";
        return "Game Continues...";
    }

    static void printBoard() {
        System.out.println("\n  Current Board:");
        for (int r = 0; r < 3; r++) {
            System.out.print("  ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c]);
                if (c < 2) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("===== UC7: CHECK WIN OR DRAW DEMO =====\n");
        printBoard();

        System.out.println("  [UC7] Game State: " + getGameState());

        // Let's modify the board to create a win for X
        System.out.println("\n  [UC7] Changing board so X wins...");
        board[2][1] = 'X';
        board[2][2] = 'X';
        printBoard();
        System.out.println("  [UC7] Game State: " + getGameState());

        System.out.println("=======================================");
    }
}
