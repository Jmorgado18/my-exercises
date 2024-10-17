package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class Field implements KeyboardHandler {

    public static final int PADDING = 10;

    private int cellsize;
    private int rows;
    private int cols;
    private Rectangle[][] positions;
    private boolean[][] paintedPositions;
    private Rectangle cursor;
    private Keyboard keyboard;
    private boolean isSwitching;


    public Field(int cols, int rows) {
        this.paintedPositions = new boolean[cols][rows];
        this.isSwitching = false;
        this.cols = cols;
        this.rows = rows;
        this.cellsize = 10;
        this.positions = new Rectangle[cols][rows];
        this.cursor = cursor;
        this.keyboard = keyboard;
        this.initKeyboard();
    }

    public void DrawRectangle() {
        Rectangle rectangle = new Rectangle(PADDING, PADDING, this.positions.length * cellsize, this.positions.length * cellsize);
        rectangle.draw();
        rectangle.setColor(Color.LIGHT_GRAY);
        rectangle.fill();
        for (int i = 0; i < this.positions.length; i++) {

            for (int j = 0; j < this.positions.length; j++) {
                this.positions[i][j] = new Rectangle(PADDING + (i * cellsize), PADDING + (j * cellsize), cellsize, cellsize);
                this.positions[i][j].draw();
            }

        }

        cursor = new Rectangle(PADDING, PADDING, cellsize, cellsize);
        cursor.setColor(Color.BLACK);
        cursor.draw();
        cursor.fill();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                System.out.println(isSwitching);

                if (this.cursor.getX() < PADDING + ((this.cols - 1) * cellsize)) {
                    cursor.translate(cellsize, 0);

                }
                if (isSwitching) {
                    paintCell();
                }


                break;
            case KeyboardEvent.KEY_LEFT:
                System.out.println(isSwitching);
                if (this.cursor.getX() > PADDING) {
                    cursor.translate(-cellsize, 0);
                }
                if (isSwitching) {
                    if (paintedPositions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1]) {
                        unpaintCell();
                        break;
                    }
                    paintCell();
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                System.out.println(isSwitching);
                if (this.cursor.getY() < PADDING + ((this.rows - 1) * cellsize)) {
                    cursor.translate(0, cellsize);
                }

                if (isSwitching) {
                    if (paintedPositions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1]) {
                        unpaintCell();
                        break;
                    }
                    paintCell();
                }

                break;
            case KeyboardEvent.KEY_UP:
                System.out.println(isSwitching);
                if (this.cursor.getY() > PADDING) {
                    cursor.translate(0, -cellsize);
                }
                if (isSwitching) {
                    if (paintedPositions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1]) {
                        unpaintCell();
                        break;
                    }
                    paintCell();
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                System.out.println(isSwitching);

                if (paintedPositions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1]) {
                    unpaintCell();

                    break;
                }
                paintCell();
                isSwitching = true;

                break;

            case KeyboardEvent.KEY_C:
                clear();
                break;

            case KeyboardEvent.KEY_S:
                try {
                    save();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case KeyboardEvent.KEY_L:
                try {
                    load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                isSwitching = false;

                break;
        }

    }

    public void initKeyboard() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(moveLeft);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(moveDown);

        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(spacePress);

        KeyboardEvent spaceRelease = new KeyboardEvent();
        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(spaceRelease);

        KeyboardEvent c = new KeyboardEvent();
        c.setKey(KeyboardEvent.KEY_C);
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(c);

        KeyboardEvent s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(s);

        KeyboardEvent l = new KeyboardEvent();
        l.setKey(KeyboardEvent.KEY_L);
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(l);

    }

    public void paintCell() {
        this.positions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1].setColor(Color.BLUE);
        this.positions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1].fill();
        this.paintedPositions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1] = true;


    }

    public void unpaintCell() {

        this.positions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1].draw();
        new Rectangle(this.cursor.getX(), this.cursor.getY(), cellsize, cellsize);
        this.paintedPositions[(int) (this.cursor.getX() / cellsize) - 1][(int) (this.cursor.getY() / cellsize) - 1] = false;
    }

    public void clear() {
        DrawRectangle();

    }

    public void save() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("rsc/board");
        for (int i = 0; i < this.paintedPositions.length; i++) {
            for (int j = 0; j < this.paintedPositions.length; j++) {
                if (this.paintedPositions[i][j]) {
                    outputStream.write(1);
                } else {
                    outputStream.write(0);
                }
            }
        }
        outputStream.close();
    }

    public void load() throws IOException {
        FileInputStream inputStream = new FileInputStream("rsc/board");
        for (int i = 0; i < this.paintedPositions.length; i++) {
            for (int j = 0; j < this.paintedPositions.length; j++) {
                if (inputStream.read() == 1) {
                    this.paintedPositions[i][j] = true;
                    this.positions[i][j].setColor(Color.BLUE);
                    this.positions[i][j].fill();



                } else {
                    this.paintedPositions[i][j] = false;
                    this.positions[i][j].draw();


                }


            }

        }

        inputStream.close();
    }
}