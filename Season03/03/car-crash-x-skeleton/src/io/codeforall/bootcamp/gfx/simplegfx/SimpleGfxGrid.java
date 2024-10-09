package io.codeforall.bootcamp.gfx.simplegfx;

import io.codeforall.bootcamp.grid.Grid;
import io.codeforall.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class SimpleGfxGrid implements Grid {

    // private static Rectangle rectangle;

    private int col;
    private int row;
    private int pixelCols;
private int pixelRows;
private int width;
private int height;
private Shape rectangle;
    public static final int PADDING = 10;


    public SimpleGfxGrid(int cols, int rows) {

        this.col = cols;
        this.row = rows;
        this.pixelCols=PADDING;
        this.pixelRows=PADDING;
    this.width=col * getCellSize();
this.height=this.row *getCellSize();

        //throw new UnsupportedOperationException();

    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        rectangle = new Rectangle(PADDING, PADDING, this.getWidth(), this.getHeight());
        rectangle.draw();

        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return col;
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return row;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the width of the grid in pixels
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return width;

        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the height of the grid in pixels
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return height;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int getX() {
        return this.pixelCols;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int getY() {
        return this.pixelRows;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the pixel width and height of a grid position
     *
     * @return
     */
    public int getCellSize() {
        return pixelCols +pixelRows;
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
        return row * getCellSize() + PADDING;
        // throw new UnsupportedOperationException();
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return col * getCellSize() + PADDING;


       // throw new UnsupportedOperationException();
    }
}
