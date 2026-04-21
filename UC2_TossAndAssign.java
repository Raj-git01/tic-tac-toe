import java.util.Random;

/**
 * UC2 - Random Toss and Symbol Assignment
 *
 * Goal: Randomly decide which player starts the game and assign symbols
 *       (X or O) to each player before the game begins.
 *
 * Actor: Game System – the system automatically performs the toss and assigns roles.
 *
 * Flow of Execution:
 *   1. The game starts.
 *   2. The system performs a random toss.
 *   3. Based on the result:
 *        - One player is selected to start first.
 *        - Symbols (X and O) are assigned.
 *   4. The system stores the current player and their symbol for further gameplay.
 *
 * Theoretical Concepts Used:
 *   1. Random Number Generation – simulates a coin-flip toss (0 or 1).
 *   2. Conditional Logic         – decides who starts and which symbol each gets.
 *   3. Game State Variables      – stores current player and their symbols.
 */
public class UC2_TossAndAssign {

    // ------------------------------------------------------------------ //
    //  3. Game State Variables
    //     These are shared across the game and updated by this use case.
    // ------------------------------------------------------------------ //
    static int    currentPlayer;        // 1 or 2 – whoever won the toss
    static char   player1Symbol;        // 'X' or 'O'
    static char   player2Symbol;        // 'O' or 'X'

    /**
     * UC2 – Perform toss and assign symbols.
     *
     * Concepts: Random Number Generation + Conditional Logic
     *
     * Steps:
     *   a. Generate a random number: 0 → Player 1 starts, 1 → Player 2 starts.
     *   b. Apply conditional logic to assign X/O accordingly.
     *   c. Update game state variables.
     */
    static void performTossAndAssign() {

        // ---- 1. Random Number Generation --------------------------------
        Random random = new Random();
        int tossResult = random.nextInt(2);  // produces 0 or 1 (like a coin flip)

        // ---- 2. Conditional Logic ----------------------------------------
        // If toss == 0  →  Player 1 starts with X, Player 2 gets O
        // If toss == 1  →  Player 2 starts with X, Player 1 gets O
        if (tossResult == 0) {
            currentPlayer = 1;       // Player 1 goes first
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = 2;       // Player 2 goes first
            player1Symbol = 'O';
            player2Symbol = 'X';
        }

        // ---- 3. Display result -------------------------------------------
        System.out.println("\n===== TOSS RESULT =====");
        System.out.println("Toss value  : " + tossResult +
                           (tossResult == 0 ? " (Player 1 wins toss)" : " (Player 2 wins toss)"));
        System.out.println("Player 1    : " + player1Symbol);
        System.out.println("Player 2    : " + player2Symbol);
        System.out.println("First move  : Player " + currentPlayer);
        System.out.println("=======================\n");
    }

    /**
     * Helper – returns the symbol of whichever player is currently active.
     * Used by later use cases to know whose turn it is.
     */
    static char getCurrentPlayerSymbol() {
        return (currentPlayer == 1) ? player1Symbol : player2Symbol;
    }

    // ------------------------------------------------------------------ //
    //  Main – Entry point to run UC2 in isolation
    // ------------------------------------------------------------------ //
    public static void main(String[] args) {
        performTossAndAssign();
        System.out.println("Active player's symbol: " + getCurrentPlayerSymbol());
    }
}
