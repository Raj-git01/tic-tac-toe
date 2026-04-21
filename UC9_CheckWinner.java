/**
 * UC9 - Detect Winner
 *
 * Goal: Detect if a player has won the game.
 * Actor: Game System
 * Flow: After each move, check rows, columns, and diagonals.
 *
 * Key Concepts:
 *   1. Pattern Matching
 *   2. Logical Conditions
 *   3. Loop-Based Checks
 */
public class UC9_CheckWinner {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'O', 'X', '-'},
        {'O', '-', 'X'}
    };

    /**
     * Checks whether the provided symbol has formed a winning line.
     *
     * @param symbol player symbol ('X' or 'O')
     * @return true if the symbol has 3 in a row
     */
    static boolean hasWinner(char symbol) {
        // Loop-based checks for rows and columns.
        for (int i = 0; i < 3; i++) {
            boolean rowMatch = board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol;
            boolean colMatch = board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol;
            if (rowMatch || colMatch) {
                return true;
            }
        }

        // Pattern matching for both diagonals.
        boolean diagonalOne = board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol;
        boolean diagonalTwo = board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;

        return diagonalOne || diagonalTwo;
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
        System.out.println("===== UC9: DETECT WINNER =====");
        printBoard();

        if (hasWinner('X')) {
            System.out.println("Player X has won.");
        } else if (hasWinner('O')) {
            System.out.println("Player O has won.");
        } else {
            System.out.println("No winner yet.");
        }

        System.out.println("===============================");
    }
}
