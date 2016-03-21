package puzzleGame;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.Random;
import java.util.stream.IntStream;

public class Grid {

    private Pane pane;
    private int[][] grid = new int[(int)Constants.numberOfSquaresHeight+1][(int)Constants.numberOfSquaresWidth];

    public Grid(int startX, int startY, Pane p){
        this.pane = p;
        initializeGrid();
        drawSquares(startX, startY);
    }

    private void drawSquares(int startX, int startY) {
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    Square s = new Square(Constants.squareTypes[grid[i][j]], startX + j*((int) Constants.squareWidth), startY + i*((int)Constants.squareHeight));
                    s.addTo(pane);
                }
            }
        }
    }

    private void initializeGrid(){
        Random rand = new Random();

        /*
        TODO: Decide how many out-of-place squares there should be
        int oopNr = rand.nextInt(Constants.outOfPlaceSquares);
        Iterate over the grid, backwards, and place random values in each slot.
        TODO: implement using an even amount of the same values, distributed randomly.
        */

        //First fill array with only 0s.
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = 0;
            }
        }

        for(int i = grid.length-1; i == grid.length - Constants.numberOfStartRows + 1; i--){
            for(int j = 0; j < grid[0].length; i++){
                int value = rand.nextInt(Constants.squareTypes.length + 1);
                if(threeInARow(i,j,value)){
                    value = (value == grid.length-1) ? 1 : value + 1;
                }
                grid[i][j] = value;
            }
        }
    }
    private boolean threeInARow(int row, int col, int value){
        /* A naive approach to checking whether inserting the current value will result in starting with three
        Squares - of the same type - in a row. Assumes that the grid is being filled bottom up, from left to right.
         */

        if(grid[row][col-1] == value && grid[row][col-2] == value) return true;

        try{ if(grid[row-1][col] == value && grid[row-2][col] == value) return true; }

        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return false;
    }
}
