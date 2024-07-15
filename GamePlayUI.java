package com.example.ap_assignment03.UI;

import com.example.ap_assignment03.GameMechanics.Pillar;
import com.example.ap_assignment03.Model.GameRectangles;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

// The Code will change when the Final Code will get Ready because it needs Pillars data

public class GamePlayUI {

    private static final int height = 700;
    private static final int width = 800;
    private AnchorPane playLayout; // layout -> AnchorPane
    private Scene playScene;
    private Stage playStage;
    private Pillar pillar1, pillar2;

    public GamePlayUI() {
        this.playLayout = new AnchorPane();
        this.playScene = new Scene(playLayout, width, height);
        this.playStage = new Stage();
        this.pillar1 = createPillar1();
        this.pillar2 = createPillar2();
        createBackground();
        playStage.setScene(playScene);
    }

    public void setPlayLayout(AnchorPane playLayout) {
        this.playLayout = playLayout;
    }

    public void setPlayScene(Scene playScene) {
        this.playScene = playScene;
    }

    public void setPlayStage(Stage playStage) {
        this.playStage = playStage;
    }

    public void setPillar2(Pillar pillar2) {
        this.pillar2 = pillar2;
    }

    public Pillar getPillar2() {
        return pillar2;
    }

    public void setPillar1(Pillar pillar1) {
        this.pillar1 = pillar1;
    }

    public AnchorPane getPlayLayout() {
        return playLayout;
    }

    public Scene getPlayScene() {
        return playScene;
    }

    public Stage getPlayStage() {
        return playStage;
    }

    public Pillar getPillar1() {
        return pillar1;
    }

    public Pillar createPillar1(){ // Initial pillar of the game
        Pillar pillar1 = new Pillar();
        playLayout.getChildren().add(pillar1.getShape());
        pillar1.getShape().setLayoutX(32);
        pillar1.getShape().setLayoutY(458); // base
        return pillar1;
    }

    public Pillar createPillar2(){
        Pillar pillar2 = new Pillar();
        playLayout.getChildren().add(pillar2.getShape());
        pillar2.getShape().setLayoutX(628);
        pillar2.getShape().setLayoutY(458);
        return pillar2;
    }

    private void createBackground(){
        Image backgroundImage = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\background.jpg", 800, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        playLayout.setBackground(new Background(background));
    }

    private void insertCherryImage(int x, int y) {
        Image image = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\cherry.PNG");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setLayoutX(480);
        imageView.setLayoutY(304);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        playLayout.getChildren().add(imageView);
    }

    private void insertStickHeroImage(){
        Image image = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\StickHero.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setLayoutX(80);
        imageView.setLayoutY(170);
        playLayout.getChildren().add(imageView);
    }

}
