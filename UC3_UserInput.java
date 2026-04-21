import java.util.Scanner;

/**
 * UC3 - User Input Handling
 *
 * Goal: Allow the user to enter a slot number between 1 and 9.
 *
 * Actor: Human Player
 *
 * Flow:
 *   User enters slot number → program reads input → control returns to game logic.
 *
 * Key Concepts:
 *   1. User Input Handling   – reads an integer from the console via Scanner.
 *   2. Method Creation       – encapsulates input logic in a dedicated method.
 *   3. Separation of Concerns – this class ONLY handles reading input;
 *                               validation is delegated to UC5.
 *
 * Key Requirements:
 *   - Read integer input.
 *   - Return the slot value (1–9) to the caller.
 */
public class UC3_UserInput {

    // A single Scanner instance shared within this class.
    // In a full game, this would be passed in or shared globally.
    static Scanner scanner = new Scanner(System.in);

    /**
     * UC3 – Read the slot number entered by the current player.
     *
     * Concept: User Input Handling + Method Creation
     *
     * - Prompts the player to enter a number from 1 to 9.
     * - Reads and returns the integer value.
     * - Does NOT validate here (Separation of Concerns → UC5 does that).
     *
     * @param currentPlayer  the player number (1 or 2) for the prompt message.
     * @return  the raw slot number entered by the user.
     */
    static int getSlotInput(int currentPlayer) {
        // ---- User Input Handling ----------------------------------------
        System.out.print("Player " + currentPlayer +
                         ", enter a slot number (1-9): ");
        int slot = scanner.nextInt();   // read integer from console
        return slot;                    // return raw value to game logic
    }

    // ------------------------------------------------------------------ //
    //  Main – Entry point to run UC3 in isolation
    // ------------------------------------------------------------------ //
    public static void main(String[] args) {
        // Simulating Player 1's turn
        int slot = getSlotInput(1);
        System.out.println("Slot entered: " + slot);
        // Control would now return to the main game loop,
        // which passes the slot to UC4 (conversion) and UC5 (validation).
    }
}
