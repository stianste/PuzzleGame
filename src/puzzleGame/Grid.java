package puzzleGame;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Grid {

    private Pane pane;
    //Add 1 to the height to account for the bottom row.
    private int[][] grid = new int[(int) Constants.numberOfSquaresHeight + 1][(int) Constants.numberOfSquaresWidth];
    //Be aware that x = column, y = row
    private int x = 0;
    private int y = 0;
    private List<Square> squares = new ArrayList<Square>();

    public Grid(double startX, double startY, Pane p) {
        this.pane = p;
        initializeGrid();
        drawSquares(startX, startY);
    }

    private void drawSquares(double startX, double startY) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = grid[i][j];
                if (val != -1) {
                    Square s = new Square(Constants.squareTypes[val], startX + j * (Constants.squareWidth),
                            startY + i * (Constants.squareHeight), j, i);
                    s.addTo(pane);
                    squares.add(s);
                }
            }
        }
    }

    private void initializeGrid() {
        Random rand = new Random();

        /*
        TODO: Decide how many out-of-place squares there should be
        int oopNr = rand.nextInt(Constants.outOfPlaceSquares);
        Iterate over the grid, backwards, and place random values in each slot.
        TODO: implement using an even amount of the same values, distributed randomly.
        */

        //First fill array with only -1 to indicate empty slots.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = -1;
            }
        }

        for (int i = grid.length - 1; i >= grid.length - (Constants.numberOfStartRows + 1); i--) {
            for (int j = 0; j < grid[i].length; j++) {
                int value = rand.nextInt(Constants.squareTypes.length);
                if (threeInARow(i, j, value)) {
                    value = (value == (grid[0].length - 2)) ? 0 : value + 1;
                }
                grid[i][j] = value;
            }
        }
    }

    private boolean threeInARow(int row, int col, int value) {
        /* A naive approach to checking whether inserting the current value will result in starting with three
        Squares - of the same type - in a row. Assumes that the grid is being filled bottom up, from left to right.
         */

        try {
            if (grid[row][col - 1] == value && grid[row][col - 2] == value) return true;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            if (grid[row + 1][col] == value && grid[row + 2][col] == value) return true;
        } catch (ArrayIndexOutOfBoundsException e2) {
        }
        return false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Square findMatchingSquare(int x, int y) {
        return this.squares.stream().filter(s -> s.getX() == x && s.getY() == y).collect(Collectors.toList()).get(0);
    }

    public void switchSquares(int x, int y) {
        int temp = grid[y][x];
        grid[y][x] = grid[y][x + 1];
        grid[y][x + 1] = temp;
    }
    public void printGrid(){
        stream(grid).forEach(list -> {
            stream(list).forEach(integer -> System.out.print(integer));
            System.out.println();
        });
    }

    public void removeSquares(int x, int y) {
        //Currently doesn't work with horizontal and vertical at the same time
        int leftValue = grid[y][x];
        int rightValue = grid[y][x+1];

        removeHorizontally(leftValue, x, y);
        removeHorizontally(rightValue, x + 1, y);
        removeVertically(leftValue, x, y);
        removeVertically(rightValue, x + 1, y);
        printGrid();
    }

    private void removeVertically(int value, int x, int y) {
        int currList = 0;

        List<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>();

        ll.add(new ArrayList<Integer>());
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][x] == value) {
                ll.get(currList).add(i);
            } else {
                ll.add(new ArrayList<Integer>());
                currList += 1;
            }
        }

        List<ArrayList<Integer>> sequence = ll.stream().filter(list -> list.size() >= 3).collect(Collectors.toList());

        if (sequence.size() == 0) {
            return;
        }

        sequence.subList(1, sequence.size()).stream().forEach(list -> sequence.get(0).addAll(list));

        sequence.get(0).stream().forEach(i -> {
            this.squares.stream().filter(s -> s.getX() == x && s.getY() == i).forEach(square -> {
                grid[i][x] = -1;
                square.remove(this.pane);
                square = null;
            });
        });
        sequence.get(0).stream().forEach(i -> this.squares.removeIf(s -> s.getX() == x && s.getY() == i));
        fallDown(x);
    }

    private void removeHorizontally(int value, int x, int y) {
        int currList = 0;

        List<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>();

        ll.add(new ArrayList<Integer>());

        for (int i = 0; i < grid[y].length; i++) {
            if (grid[y][i] == value) {
                ll.get(currList).add(i);
            } else {
                ll.add(new ArrayList<Integer>());
                currList += 1;
            }
        }

        List<ArrayList<Integer>> sequence = ll.stream().filter(list -> list.size() >= 3).collect(Collectors.toList());
        if (sequence.size() == 0) {
            return;
        }

        sequence.subList(1, sequence.size()).stream().forEach(list -> sequence.get(0).addAll(list));

        sequence.get(0).stream().forEach(i -> {
            this.squares.stream().filter(s -> s.getX() == i && s.getY() == y).forEach(square -> {
                grid[y][i] = -1;
                square.remove(this.pane);
                square = null;
            });
        });
        sequence.get(0).stream().forEach(i -> this.squares.removeIf(s -> s.getX() == i && s.getY() == y));
        sequence.get(0).stream().forEach(integer -> fallDown(integer));
    }

    private void fallDown(int row) {
        int offset = 0;

        for (int i = grid.length-1; i >= 0; i--) {
            if (grid[i][row] == -1) {
                offset++;
            } else {
                if(offset > 0){
                    grid[i + offset][row] = grid[i][row];
                    grid[i][row] = -1;
                    for (int j = 0; j < squares.size(); j++) {
                        Square s = squares.get(j);
                        if (s.getX() == row && s.getY() == i) {
                            s.moveDown(offset);
                        }
                    }
                }
            }
        }
    }
}
