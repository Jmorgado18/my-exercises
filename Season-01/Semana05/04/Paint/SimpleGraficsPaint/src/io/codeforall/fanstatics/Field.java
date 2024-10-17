package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Field implements KeyboardHandler {

    public static final int PADDING = 10;

    public void DrawRectangle() {
        for (int i = 0; i < 20; i++) {

        Rectangle rectangle = new Rectangle(PADDING, PADDING, 100, 100);
        rectangle.draw();
        rectangle.setColor(Color.LIGHT_GRAY);
        rectangle.fill();
        makeGrid();
        }
    }

    public static void makeGrid(){

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
