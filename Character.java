package com.example.ap_assignment03.GameMechanics;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Character {
    private Image characterImage;

    private ImageView characterImageView;

    private double height;

    private double width;

    private double speed;



    // 35 w 55 h
    public Character() {

        // Image will change on the basis of character selection // Need to add that also
        this.characterImage = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\charachter.jpeg");
        this.characterImageView = new ImageView(characterImage);
        this.height = 55;
        this.width = 35;
        this.speed = 100;
        this.characterImageView.setFitHeight(this.height);
        this.characterImageView.setFitWidth(this.width);

    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Image getCharacterImage() {
        return characterImage;
    }

    public void setCharacterImage(Image characterImage) {
        this.characterImage = characterImage;
    }

    public void setCharacterImageView(ImageView characterImageView) {
        this.characterImageView = characterImageView;
    }

    public ImageView getCharacterImageView() {
        return characterImageView;
    }


}
