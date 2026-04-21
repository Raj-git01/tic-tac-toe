/**
 * UC5 - Move Validation
 *
 * Goal: Ensure the move is within bounds and the chosen cell is empty.
 *
 * Actor: Game System
 *
 * Flow:
 *   Row and column received → validation performed → move accepted or rejected.
 *
 * Key Concepts:
 *   1. Conditional Logic      – if-else checks determine validity.
 *   2. Boundary Checking      – row and column must each be in range 0–2.
 *   3. Defensive Programming  – always validate before updating game state.
 *
 * Key Requirements:
 *   - Row and column must be 0–2 (within the 3x3 grid).
 *   - The target cell must be empty ('-').
 */
public class UC5_MoveValidation {

    // ------------------------------------------------------------------ //
    //  Shared board (in a real game this is passed in or shared globally)
    // ------------------------------------------------------------------ //
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    /**
     * UC5 – Validate whether a move at (row, col) is legal.
     *
     * A move is legal if and only if BOTH conditions are true:
     *   1. Boundary Check  : 0 ≤ row ≤ 2  AND  0 ≤ col ≤ 2
     *   2. Cell is empty   : board[row][col] == '-'
     *
     * Concepts: Conditional Logic + Boundary Checking + Defensive Programming
     *
     * @param row  row index derived from UC4
     * @param col  column index derived from UC4
     * @return     true if the move is valid, false otherwise
     */
    static boolean isValidMove(int row, int col) {

        // ---- 1. Boundary Checking ----------------------------------------
        // Defensive Programming: check limits before accessing the array
        // to avoid ArrayIndexOutOfBoundsException.
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("  [UC5] Invalid move: position (" +
                               row + ", " + col + ") is out of bounds (must be 0–2).");
            return false;   // Conditional Logic: reject out-of-bounds move
        }

        // ---- 2. Cell Occupancy Check -------------------------------------
        // Defensive Programming: only an empty cell ('-') can be chosen.
        if (board[row][col] != '-') {
            System.out.println("  [UC5] Invalid move: cell (" +
                               row + ", " + col + ") is already occupied by '" +
                               board[row][col] + "'.");
            return false;   // Conditional Logic: reject occupied cell
        }

        // ---- Move is valid -----------------------------------------------
        System.out.println("  [UC5] Move at (" + row + ", " + col + ") is valid.");
        return true;
    }

    /**
     * Place a symbol on the board after a successful validation.
     * Only called when isValidMove() returns true.
     *
     * @param row     row index
     * @param col     column index
     * @param symbol  'X' or 'O'
     */
    static void applyMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    /**
     * Print the current state of the board (reuses UC1 logic inline).
     */
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

    // ------------------------------------------------------------------ //
    //  Main – Entry point to run UC5 with example scenarios
    // ------------------------------------------------------------------ //
    public static void main(String[] args) {
        System.out.println("===== UC5: MOVE VALIDATION DEMO =====\n");

        // --- Scenario 1: Valid move on empty board -----------------------
        System.out.println("Scenario 1 – Valid move at (0, 0):");
        if (isValidMove(0, 0)) {
            applyMove(0, 0, 'X');   // accepted: place X
        }
        printBoard();

        // --- Scenario 2: Cell already occupied ---------------------------
        System.out.println("Scenario 2 – Trying to play at (0, 0) again:");
        if (isValidMove(0, 0)) {
            applyMove(0, 0, 'O');
        }
        printBoard();

        // --- Scenario 3: Out-of-bounds move -------------------------------
        System.out.println("Scenario 3 – Out-of-bounds move at (3, 3):");
        if (isValidMove(3, 3)) {
            applyMove(3, 3, 'O');
        }
        printBoard();

        // --- Scenario 4: Another valid move ------------------------------
        System.out.println("Scenario 4 – Valid move at (1, 1):");
        if (isValidMove(1, 1)) {
            applyMove(1, 1, 'O');   // accepted: place O
        }
        printBoard();

        System.out.println("======================================");
    }
}
