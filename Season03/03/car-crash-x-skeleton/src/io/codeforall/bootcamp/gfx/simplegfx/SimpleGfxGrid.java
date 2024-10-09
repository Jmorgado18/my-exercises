package io.codeforall.bootcamp.gfx.simplegfx;

import io.codeforall.bootcamp.grid.Grid;
import io.codeforall.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    // private static Rectangle rectangle;

    private int cols;
    private int rows;
    public static final int PADDING = 10;


    public SimpleGfxGrid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;

        //throw new UnsupportedOperationException();

    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        Rectangle rectangle = new Rectangle(PADDING, PADDING, this.cols*this.getCellSize(), this.rows*this.getCellSize());
        rectangle.draw();

        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return this.cols;
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return this.rows;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the width of the grid in pixels
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return this.cols * getCellSize();

        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the height of the grid in pixels
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return this.rows * getCellSize();
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the pixel width and height of a grid position
     *
     * @return
     */
    public int getCellSize() {
        return 20;
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        return  new SimpleGfxGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col, row, this);
       // throw new UnsupportedOperationException();
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     *
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return rows * getCellSize() + PADDING;
        // throw new UnsupportedOperationException();
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return cols * getCellSize() + PADDING;


       // throw new UnsupportedOperationException();
    }
}
