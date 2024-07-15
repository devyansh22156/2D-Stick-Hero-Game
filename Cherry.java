package com.example.ap_assignment03.GameMechanics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cherry {

    private Image cherry;
    private ImageView cherryImageView;
    private double height;
    private double width;

    public Cherry() {

        this.cherry = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\cherry.PNG");
        this.cherryImageView = new ImageView(this.cherry);
        this.height = 40;
        this.width = 40;
        this.cherryImageView.setFitHeight(height);
        this.cherryImageView.setFitWidth(width);

    }

    public Image getCherry() {
        return cherry;
    }

    public ImageView getCherryImageView() {
        return cherryImageView;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setCherry(Image cherry) {
        this.cherry = cherry;
    }

    public void setCherryImageView(ImageView cherryImageView) {
        this.cherryImageView = cherryImageView;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

