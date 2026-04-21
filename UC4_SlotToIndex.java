/**
 * UC4 - Slot Number to Row & Column Conversion
 *
 * Goal: Convert a user-entered slot number (1–9) into row and column indices
 *       suitable for accessing the 2D board array.
 *
 * Actor: Human Player (triggered after UC3 captures input)
 *
 * Flow:
 *   Slot entered → system converts slot → row & column generated.
 *
 * Key Concepts:
 *   1. Zero-based Indexing   – array indices start at 0, so slot 1 → (0,0).
 *   2. Mathematical Mapping  – a formula maps slot 1-9 to a 3x3 grid.
 *   3. Division and Modulo   – row = (slot-1) / 3 ,  col = (slot-1) % 3
 *   4. Utility Methods       – conversion is isolated in its own method.
 *
 * Key Requirements:
 *   - Convert slot (1–9) to valid indices (row: 0–2, col: 0–2).
 *
 * Slot → Grid mapping (for reference):
 *
 *   Slot:          Grid position:
 *   1 | 2 | 3      (0,0) | (0,1) | (0,2)
 *   ---------      ---------------------
 *   4 | 5 | 6      (1,0) | (1,1) | (1,2)
 *   ---------      ---------------------
 *   7 | 8 | 9      (2,0) | (2,1) | (2,2)
 */
public class UC4_SlotToIndex {

    /**
     * UC4 – Convert a slot number to a row index.
     *
     * Concept: Zero-based Indexing + Division
     *
     * Formula: row = (slot - 1) / 3
     *   - Subtracting 1 shifts the range from 1-9 to 0-8 (zero-based).
     *   - Integer division by 3 groups every three slots into the same row.
     *
     * Examples:
     *   slot 1 → (1-1)/3 = 0   slot 4 → (4-1)/3 = 1   slot 7 → (7-1)/3 = 2
     *
     * @param slot  user-entered slot number (1–9)
     * @return      row index (0, 1, or 2)
     */
    static int getRow(int slot) {
        return (slot - 1) / 3;   // Mathematical Mapping with Division
    }

    /**
     * UC4 – Convert a slot number to a column index.
     *
     * Concept: Zero-based Indexing + Modulo
     *
     * Formula: col = (slot - 1) % 3
     *   - Subtracting 1 shifts range to 0-8.
     *   - Modulo 3 gives the remainder, which is the column position.
     *
     * Examples:
     *   slot 1 → (1-1)%3 = 0   slot 2 → (2-1)%3 = 1   slot 3 → (3-1)%3 = 2
     *
     * @param slot  user-entered slot number (1–9)
     * @return      column index (0, 1, or 2)
     */
    static int getCol(int slot) {
        return (slot - 1) % 3;   // Mathematical Mapping with Modulo
    }

    /**
     * Utility – Convert and display the full mapping for a given slot.
     * Demonstrates how the formulas work together.
     *
     * @param slot  user-entered slot number (1–9)
     */
    static void displayMapping(int slot) {
        int row = getRow(slot);
        int col = getCol(slot);
        System.out.println("Slot " + slot + " → row=" + row + ", col=" + col +
                           "  [board[" + row + "][" + col + "]]");
    }

    // ------------------------------------------------------------------ //
    //  Main – Entry point to run UC4 in isolation
    // ------------------------------------------------------------------ //
    public static void main(String[] args) {
        System.out.println("===== SLOT → INDEX MAPPING =====");
        // Show the conversion for all 9 slots
        for (int slot = 1; slot <= 9; slot++) {
            displayMapping(slot);
        }
        System.out.println("=================================");
    }
}
