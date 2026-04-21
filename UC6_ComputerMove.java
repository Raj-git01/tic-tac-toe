/**
 * UC6 - Computer Move
 *
 * Goal: Implement logic for the computer to make a move.
 *
 * Actor: Computer
 *
 * Flow:
 *   1. The computer finds all available (empty) cells.
 *   2. The computer randomly selects one of these cells to make a move.
 *
 * Key Concepts:
 *   1. Random Number Generation - Math.random() or java.util.Random
 *   2. Array Traversal - Finding empty spots
 *   3. Control Flow - Loops and conditionals
 */
import java.util.Random;

public class UC6_ComputerMove {

    static char[][] board = {
        {'X', '-', 'O'},
        {'-', 'X', '-'},
        {'-', '-', 'O'}
    };

    /**
     * Checks if there are any available moves left on the board.
     * @return true if there is at least one empty cell.
     */
    static boolean hasFreeSpace() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-') return true;
            }
        }
        return false;
    }

    /**
     * Executes the computer's move by randomly selecting an available empty cell.
     * @param computerSymbol the symbol the computer is playing ('X' or 'O')
     */
    static void executeComputerMove(char computerSymbol) {
        if (!hasFreeSpace()) {
            System.out.println("  [UC6] Board is full. No moves possible.");
            return;
        }

        Random rand = new Random();
        boolean validMoveMade = false;

        System.out.println("  [UC6] Computer is thinking...");

        while (!validMoveMade) {
            int row = rand.nextInt(3); // 0 to 2
            int col = rand.nextInt(3); // 0 to 2

            if (board[row][col] == '-') {
                board[row][col] = computerSymbol;
                validMoveMade = true;
                System.out.println("  [UC6] Computer placed '" + computerSymbol + "' at (" + row + ", " + col + ").");
            }
        }
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
        System.out.println("===== UC6: COMPUTER MOVE DEMO =====\n");
        printBoard();

        executeComputerMove('O');
        printBoard();

        executeComputerMove('X');
        printBoard();
        
        System.out.println("===================================");
    }
}
