package io.bootcamp.FanStatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle(2,3,400,400);
        rectangle.draw();
        rectangle.setColor(Color.LIGHT_GRAY);
        rectangle.fill();
        rectangle.grow(100,100);
        Image image =  new Image();
        
    }
}
