package com.example.ap_assignment03.UI;
import com.example.ap_assignment03.Model.GameButtons;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;
public class CreditsDisplayUI {
    private static final int height = 700;
    private static final int width = 800;

    public CreditsDisplayUI(Stage mainStage) throws FileNotFoundException {
        this.layout = new AnchorPane();
        this.mainScene = new Scene(layout, width, height);
        this.mainStage = mainStage;
        this.mainStage.setScene(mainScene);
        this.mainStage.setScene(mainScene);
        createBackground();
        displayText();
        createBackToMenuButton();
    }

    private AnchorPane layout; // layout -> AnchorPane
    private Scene mainScene;
    private Stage mainStage;

    public AnchorPane getLayout() {
        return layout;
    }

    public void setLayout(AnchorPane layout) {
        this.layout = layout;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void createBackToMenuButton() throws FileNotFoundException {
        GameButtons button1 = new GameButtons("Back To Main Menu");
        layout.getChildren().add(button1);
        button1.setLayoutX(452);
        button1.setLayoutY(462);
        button1.setOnAction(e->{
            try {
                new MenuUI(getMainStage());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void displayText() {
        Text text = new Text();
        text.setText("GAME CREDITS!\n Created by: Devyansh & Ansh\n Design: Devyansh & Ansh\n Art & Music: Devyansh & Ansh");
        text.setX(100);
        text.setY(200);
        text.setFont(Font.font(40));
        text.setFill(Color.CYAN);
        layout.getChildren().add(text);
    }

    private void createBackground() {
        Image backgroundImage = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\background.jpg", 800, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        layout.setBackground(new Background(background));
    }
}