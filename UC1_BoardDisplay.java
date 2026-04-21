/**
 * UC1 - Display Empty Board
 *
 * Goal: Display an empty Tic-Tac-Toe board on the console so that the
 *       user can visually see the game layout before starting.
 *
 * Actor: User – the person who runs the program.
 *
 * Flow of Execution:
 *   1. The user runs the program.
 *   2. The program creates and initializes the board.
 *   3. The program prints the board on the console in a readable format.
 *
 * Theoretical Concepts Used:
 *   1. 2D Array  – board[3][3] represents a 3x3 grid.
 *   2. Initialization Logic – every cell is set to '-' (empty placeholder).
 *   3. Nested Loops – outer loop for rows, inner loop for columns.
 */
public class UC1_BoardDisplay {

    // ------------------------------------------------------------------ //
    //  1. 2D Array – Board Representation
    //     A 3x3 character array where each cell holds '-', 'X', or 'O'.
    // ------------------------------------------------------------------ //
    static char[][] board = new char[3][3];

    /**
     * UC1 – Step 2: Initialize every cell of the board with '-'.
     * This indicates the cell is not yet occupied.
     *
     * Concept: Initialization Logic + Nested Loops
     */
    static void initializeBoard() {
        // Outer loop → iterates over rows (0, 1, 2)
        for (int row = 0; row < 3; row++) {
            // Inner loop → iterates over columns (0, 1, 2)
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';   // placeholder symbol
            }
        }
    }

    /**
     * UC1 – Step 3: Print the board in a clean, readable format.
     *
     * Example output:
     *   - - -
     *   - - -
     *   - - -
     *
     * Concept: Nested Loops + Formatted Console Output
     */
    static void printBoard() {
        System.out.println("\n===== TIC-TAC-TOE BOARD =====");
        // Outer loop → row by row
        for (int row = 0; row < 3; row++) {
            // Inner loop → column by column within each row
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);   // print cell value
                if (col < 2) {
                    System.out.print(" ");           // space between columns
                }
            }
            System.out.println();  // move to next line after each row
        }
        System.out.println("==============================\n");
    }

    // ------------------------------------------------------------------ //
    //  Main – Entry point to run UC1
    // ------------------------------------------------------------------ //
    public static void main(String[] args) {
        initializeBoard();   // Step 2: create and initialise the board
        printBoard();        // Step 3: display the empty board
    }
}
