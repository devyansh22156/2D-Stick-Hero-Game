package com.example.ap_assignment03.UI;

import com.example.ap_assignment03.Game.Main;
import com.example.ap_assignment03.Game.Player;
import com.example.ap_assignment03.GameMechanics.GameBackEnd;
import com.example.ap_assignment03.Model.GameButtons;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MenuUI {

    private static final int height = 700;
    private static final int width = 800;
    private AnchorPane layout; // layout -> AnchorPane
    private Scene mainScene;
    private Stage mainStage;

    private List<Player> playerList;
    public Scene getMainScene() {
        return mainScene;
    }

    public MenuUI(List<Player> playerList) throws FileNotFoundException {
        this.layout = new AnchorPane();
        this.mainScene = new Scene(layout, width, height);
        this.mainStage = new Stage();
        this.mainStage.setScene(mainScene);
        this.playerList = playerList;
        createNewGameButton();
        createResumeGameButton();
        createCreditGameButton();
        createBackground();
        createExitGameButton();
        insertGameText();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public MenuUI(Stage mainStage) throws FileNotFoundException{
        this.layout = new AnchorPane();
        this.mainScene = new Scene(layout, width, height);
        mainStage.setScene(this.getMainScene());
        setMainStage(mainStage);
        createNewGameButton();
        createResumeGameButton();
        createCreditGameButton();
        createBackground();
        createExitGameButton();

    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Stage getMainStage(){
        return mainStage;
    }

    // button1 -> NewGame
    private void createNewGameButton() throws FileNotFoundException {
        GameButtons button1 = new GameButtons("New Game");
        layout.getChildren().add(button1);
        button1.setLayoutX(56);
        button1.setLayoutY(338);
        GamePlayUI playUI = new GamePlayUI();
        //button1.setOnAction(e->mainStage.setScene(playScene));
        // button1.setOnAction(e->new GameBackEnd(mainStage, playUI));
        button1.setOnAction(e-> {
            try {
                new LoginNewGameUI(getMainStage(), playerList);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void createResumeGameButton() throws FileNotFoundException {
        GameButtons button2 = new GameButtons("Resume Game");
        layout.getChildren().add(button2);
        button2.setLayoutX(305);
        button2.setLayoutY(338);
        button2.setOnAction(e->{
            try {
                new LoginResumeGameUI(getMainStage());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void createCreditGameButton() throws FileNotFoundException{
        GameButtons button4 = new GameButtons("Credits");
        layout.getChildren().add(button4);
        button4.setLayoutX(550);
        button4.setLayoutY(338);
        button4.setOnAction(e->{
            try {
                new CreditsDisplayUI(getMainStage());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void createExitGameButton() throws FileNotFoundException{
        GameButtons button4 = new GameButtons("Exit");
        layout.getChildren().add(button4);
        button4.setLayoutX(300);
        button4.setLayoutY(462);
        button4.setOnAction(e->{
            System.exit(0);
        });
    }

    private void createBackground(){
        Image backgroundImage = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\background.jpg", 800, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        layout.setBackground(new Background(background));
    }
    private void insertGameText(){
        Text txt = new Text("STICK HERO");
        txt.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        txt.setFill(Color.BLACK);
        txt.setLayoutX(250);
        txt.setLayoutY(150);
        layout.getChildren().add(txt);
    }
}
