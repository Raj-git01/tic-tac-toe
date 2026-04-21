/**
 * UC8 - Main Game Loop
 *
 * Goal: Bring all the pieces together to create the full, playable console game.
 *
 * Actor: User vs. Computer
 *
 * Flow:
 *   1. Initialize Board (UC1).
 *   2. Toss to see who plays first and assign X or O (UC2).
 *   3. Loop until Win or Draw:
 *      a. If Human Turn: Get user input (UC3), convert to index (UC4), validate (UC5), place symbol.
 *      b. If Computer Turn: Generate move (UC6), place symbol.
 *      c. Show board.
 *      d. Check game state (UC7).
 *      e. Switch turn.
 *   4. Announce result and end game.
 */
import java.util.Scanner;
import java.util.Random;

public class UC8_MainGameLoop {

    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    static char humanSymbol, compSymbol;
    static boolean isHumanTurn;

    static void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("\n===== BOARD =====");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c]);
                if (c < 2) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("=================\n");
    }

    static void setupGame() {
        System.out.println("Welcome to Tic-Tac-Toe!\n");
        Random rand = new Random();
        int toss = rand.nextInt(2); // 0 or 1
        
        if (toss == 0) {
            System.out.println("You won the toss! You play first.");
            isHumanTurn = true;
        } else {
            System.out.println("Computer won the toss! Computer plays first.");
            isHumanTurn = false;
        }

        System.out.print("Choose your symbol (X or O): ");
        char choice = scanner.next().toUpperCase().charAt(0);
        while (choice != 'X' && choice != 'O') {
            System.out.print("Invalid choice. Please choose X or O: ");
            choice = scanner.next().toUpperCase().charAt(0);
        }

        humanSymbol = choice;
        compSymbol = (humanSymbol == 'X') ? 'O' : 'X';
        
        System.out.println("You are '" + humanSymbol + "', Computer is '" + compSymbol + "'.");
    }

    static boolean isWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }

    static boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-') return false;
            }
        }
        return true;
    }

    static void humanMove() {
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Your turn. Enter a slot (1-9): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 9.");
                scanner.next(); // clear bad input
                continue;
            }
            int slot = scanner.nextInt();
            if (slot < 1 || slot > 9) {
                System.out.println("Slot out of bounds! Must be 1-9.");
                continue;
            }

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (board[row][col] != '-') {
                System.out.println("Cell already occupied. Choose an empty slot.");
            } else {
                board[row][col] = humanSymbol;
                validMove = true;
            }
        }
    }

    static void computerMove() {
        System.out.println("Computer is thinking...");
        Random rand = new Random();
        boolean validMove = false;
        while (!validMove) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if (board[row][col] == '-') {
                board[row][col] = compSymbol;
                validMove = true;
                System.out.println("Computer played at slot " + ((row * 3) + col + 1) + ".");
            }
        }
    }

    public static void main(String[] args) {
        initializeBoard();
        setupGame();
        printBoard();

        boolean gameOver = false;

        while (!gameOver) {
            if (isHumanTurn) {
                humanMove();
            } else {
                computerMove();
            }

            printBoard();

            if (isWinner(humanSymbol)) {
                System.out.println("Congratulations! You won!");
                gameOver = true;
            } else if (isWinner(compSymbol)) {
                System.out.println("Computer wins! Better luck next time.");
                gameOver = true;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                gameOver = true;
            }

            isHumanTurn = !isHumanTurn; // Switch turn
        }
        
        scanner.close();
        System.out.println("Game Over.");
    }
}
