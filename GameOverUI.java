package com.example.ap_assignment03.UI;

import com.example.ap_assignment03.GameMechanics.Score;
import com.example.ap_assignment03.Model.GameButtons;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class GameOverUI {
    private static final int height = 700;
    private static final int width = 800;
    private Score playerScore;
    private AnchorPane overLayout; // layout -> AnchorPane
    private Scene overScene;
    private Stage overStage;

    public GameOverUI(Score score, Stage mainStage) throws FileNotFoundException {
        this.overLayout = new AnchorPane();
        this.overScene = new Scene(overLayout, width, height);
        this.overStage = mainStage;
        this.playerScore=score;
        createBackground();
        createTextBoxes();
        createExitGameButton();
//        insertStickHeroImage();
        overStage.setScene(overScene);
    }
    public AnchorPane getOverLayout() {
        return overLayout;
    }

    public static int getHeight() {
        return height;
    }

    public Scene getOverScene() {
        return overScene;
    }

    public static int getWidth() {
        return width;
    }

    public Stage getOverStage() {
        return overStage;
    }

    public void setOverLayout(AnchorPane overLayout) {
        this.overLayout = overLayout;
    }

    public void setOverScene(Scene overScene) {
        this.overScene = overScene;
    }

    public void setOverStage(Stage overStage) {
        this.overStage = overStage;
    }

    private void createBackground(){
        Image backgroundImage = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\background.jpg", 800, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        overLayout.setBackground(new Background(background));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Score getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Score playerScore) {
        this.playerScore = playerScore;
    }

    public void createTextBoxes(){

        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);

        Text gameOverText = new Text("Game Over");
        gameOverText.setFont(Font.font("Arial", 48));
        gameOverText.setFill(Color.CYAN);
        gameOverText.setLayoutX(250);
        gameOverText.setLayoutY(92);

        Text scoreText = new Text("Score: "+ playerScore.getTotal());
        scoreText.setFont(Font.font("Arial", 24));
        scoreText.setFill(Color.CYAN);
        scoreText.setLayoutX(99);
        scoreText.setLayoutY(314);

        Text cherryText = new Text("Cherry Count: "+ playerScore.getCherryCnt());
        cherryText.setFont(Font.font("Arial", 24));
        cherryText.setFill(Color.CYAN);
        cherryText.setLayoutX(424);
        cherryText.setLayoutY(314);

        Text pillarText = new Text("Pillar Count: "+playerScore.getPillarCnt());
        pillarText.setFont(Font.font("Arial", 24));
        pillarText.setFill(Color.CYAN);
        pillarText.setLayoutX(99);
        pillarText.setLayoutY(482);

        getOverLayout().getChildren().addAll(gameOverText, scoreText, cherryText, pillarText);

    }

    public void createExitGameButton() throws FileNotFoundException {
        GameButtons button = new GameButtons("Exit to Main Menu");
        button.setLayoutX(440);
        button.setLayoutY(447);
        getOverLayout().getChildren().add(button);
        button.setOnAction(e->{
            try {
                new MenuUI(getOverStage());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

}