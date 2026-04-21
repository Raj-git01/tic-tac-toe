# Tic-Tac-Toe Use Case Implementation (Java)

This repository contains a step-by-step implementation of a console-based Tic-Tac-Toe game in Java, organized by use cases (`UC1` to `UC8`).

## Project Structure

- `UC1_BoardDisplay.java` - Display and initialize an empty 3x3 board.
- `UC2_TossAndAssign.java` - Perform random toss and assign symbols/player turn.
- `UC3_UserInput.java` - Read player slot input from console.
- `UC4_SlotToIndex.java` - Convert slot number (1-9) to board indices.
- `UC5_MoveValidation.java` - Validate moves (bounds + empty cell).
- `UC6_ComputerMove.java` - Generate and apply computer move.
- `UC7_CheckWinDraw.java` - Check winner and draw conditions.
- `UC8_MainGameLoop.java` - Full playable game loop (User vs Computer).

## Prerequisites

- Java 8+ (JDK installed)

## Compile

```bash
javac *.java
```

## Run Individual Use Cases

```bash
java UC1_BoardDisplay
java UC2_TossAndAssign
java UC3_UserInput
java UC4_SlotToIndex
java UC5_MoveValidation
java UC6_ComputerMove
java UC7_CheckWinDraw
```

## Run Full Game

```bash
java UC8_MainGameLoop
```

## Branching Convention

Each use case has its own branch:

- `usecase/uc1-board-display`
- `usecase/uc2-toss-and-assign`
- `usecase/uc3-user-input`
- `usecase/uc4-slot-to-index`
- `usecase/uc5-move-validation`
- `usecase/uc6-computer-move`
- `usecase/uc7-check-win-draw`
- `usecase/uc8-main-game-loop`

`main` keeps the combined code and shared documentation.
