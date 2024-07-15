package com.example.ap_assignment03.GameMechanics;

import com.example.ap_assignment03.Model.GameRectangles;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Stick {

    private final Shape shape;
    private double length;

    private double height;

    private double width;

    public Stick(double height, double width) {
        this.height = height;
        this.width = width;
        this.shape = new GameRectangles(width, height);
        this.shape.setFill(Color.BLUE);
        this.length = 1;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Shape getShape() {
        return shape;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
