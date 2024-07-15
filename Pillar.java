package com.example.ap_assignment03.GameMechanics;

import com.example.ap_assignment03.Model.GameRectangles;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import java.util.Random;

public class Pillar {

    private final double minWidth = 50;
    private final double maxWidth = 200;
    private Shape shape;
    private double width;
    private double height;

    public Pillar() {
        this.width = generateWidth();
        this.height = 300; // default height
        this.shape = new GameRectangles(width, height);
        shape.setFill(Color.RED);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getMinWidth() {
        return minWidth;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public Shape getShape() {
        return shape;
    }

    public double generateWidth(){
        double width = 0;
        Random randomWidth = new Random();
        while (width < this.minWidth){
            width = randomWidth.nextDouble(this.maxWidth);
        }
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
