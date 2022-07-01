/**
 *
 */
package unsw.automata;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Conway's Game of Life on a 10x10 grid.
 *
 * @author Robert Clifton-Everest
 *
 */
public class GameOfLife {
    BooleanProperty[][] board;
    BooleanProperty[][] prevGen;

    public GameOfLife() {
        // So we need to create a 10 * 10 array first.
        board = createEmptyBoard();
        prevGen = createEmptyBoard();
        
    }

    public BooleanProperty cellProperty(int x, int y) {
        return board[x][y];
    }

    public void ensureAlive(int x, int y) {
        // Set the cell at (x,y) as alive
        board[x][y].setValue(true);
    }

    public void ensureDead(int x, int y) {
        // Set the cell at (x,y) as dead
        board[x][y].setValue(false);
    }

    public boolean isAlive(int x, int y) {
        // Return true if the cell is alive
        return board[x][y].getValue();
    }

    public boolean prevIsAlive(int x, int y) {
        return prevGen[x][y].getValue();
    }

    public void tick() {
        prevGen = updatePrevBoard();
        board = setEmptyBoard();

        // Transition the game to the next generation.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Because the board has expanded to 12 * 12 detailed in function below.
                int numberOfNeightbours = checkNeighboursNumber(i + 1, j + 1);
                if (prevIsAlive(i, j)) {
                    // Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                    // Any live cell with more than three live neighbours dies, as if by overpopulation.
                    if (numberOfNeightbours < 2 || numberOfNeightbours > 3) {
                        ensureDead(i, j);
                    }
                    // Any live cell with two or three live neighbours lives on to the next generation.
                    else {
                        ensureAlive(i, j);
                    }
                }
                // Any dead cell with exactly three live neighbours becomes a live cell, 
                // as if by reproduction.
                else if (!prevIsAlive(i, j) && numberOfNeightbours == 3) {
                    ensureAlive(i, j);
                }
            }
        }
        
    }

    public int checkNeighboursNumber(int x, int y) {
        int numberOfNeightbours = 0;

        // To cooperate with wrapping property,
        // The 2d array has been expanded into the size of 12 * 12.
        BooleanProperty[][] expandedBoard = new SimpleBooleanProperty[12][12];
        // Four corners corresponding opposite corners.
        expandedBoard[0][0] = prevGen[9][9];
        expandedBoard[0][11] = prevGen[9][0];
        expandedBoard[11][0] = prevGen[0][9]; 
        expandedBoard[11][11] = prevGen[0][0];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Normal part:
                expandedBoard[i + 1][j + 1] = prevGen[i][j];
                // Top wrapping:
                if (j == 0) {
                    expandedBoard[i + 1][11] = prevGen[i][j];
                }
                // Bottom wrapping:
                if (j == 9) {
                    expandedBoard[i + 1][0] = prevGen[i][j];
                }
                // Left wrapping:
                if (i == 0) {
                    expandedBoard[11][j + 1] = prevGen[i][j];
                }
                // Right wrapping:
                if (i == 9) {
                    expandedBoard[0][j + 1] = prevGen[i][j];
                }
                
            }
        }

        // Checking neighbour in expanded board.
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < 12 && j >= 0 && j < 12) {
                    if ((expandedBoard[i][j].getValue()) && !(i == x && j == y)) {
                        numberOfNeightbours++;
                    }
                }
            }
        }
        return numberOfNeightbours;
    }

    public BooleanProperty[][] createEmptyBoard() {
        BooleanProperty[][] board = new SimpleBooleanProperty[10][10]; 
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = new SimpleBooleanProperty(false);
            }
        }
        return board;
    }

    public BooleanProperty[][] setEmptyBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j].setValue(false);
            }
        }
        return board;
    }


    public BooleanProperty[][] updatePrevBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                prevGen[i][j].setValue(board[i][j].getValue());
            }
        }
        return prevGen;
    }


    public void printBoardForDebug() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j].getValue()) {
                    System.out.printf("x ");
                }
                else {
                    System.out.printf("  ");
                }
            }
            System.out.printf("\n");
        }
    }



    
    
}
