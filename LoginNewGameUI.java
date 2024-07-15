package com.example.ap_assignment03.UI;

import com.example.ap_assignment03.Game.Main;
import com.example.ap_assignment03.Game.Player;
import com.example.ap_assignment03.GameMechanics.GameBackEnd;
import com.example.ap_assignment03.Model.GameButtons;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.*;

import java.io.FileNotFoundException;
import java.util.List;

public class LoginNewGameUI extends Main implements LoginUI {
    private static final int height = 700;
    private static final int width = 800;

    private AnchorPane layout; // layout -> AnchorPane
    private Scene mainScene;
    private Stage mainStage;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField phoneNumberField;
    private Player player;
    private List<Player> playerList;

    public LoginNewGameUI(Stage mainStage, List<Player> playerList) throws FileNotFoundException {

        this.layout = new AnchorPane();
        this.mainScene = new Scene(layout, width, height);
        this.mainStage = mainStage;
        this.playerList = playerList;
        this.mainStage.setScene(mainScene);
        createBackground();
        createEnterUsernameButton();
        createEnterAgeButton();
        createEnterPhoneNumberButton();
        createRegisterButton();
        createBackToMenuButton();

    }

    @Override
    public void createBackground() {
        Image backgroundImage = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\background.jpg", 800, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        layout.setBackground(new Background(background));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public void createEnterUsernameButton() {
        usernameField = new TextField();
        usernameField.setPromptText("Enter Username");
        layout.getChildren().add(usernameField);
        usernameField.setLayoutX(100);
        usernameField.setLayoutY(100);
    }

    @Override
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
    public void createEnterAgeButton(){
        ageField = new TextField();
        ageField.setPromptText("Enter Age");
        layout.getChildren().add(ageField);
        ageField.setLayoutX(100);
        ageField.setLayoutY(200);
    }
    public void createEnterPhoneNumberButton(){
        phoneNumberField = new TextField();
        phoneNumberField.setPromptText("Enter Phone Number");
        layout.getChildren().add(phoneNumberField);
        phoneNumberField.setLayoutX(100);
        phoneNumberField.setLayoutY(300);
    }

    public void createRegisterButton() throws FileNotFoundException {
        GameButtons registerButton = new GameButtons("SUBMIT");
        layout.getChildren().add(registerButton);
        registerButton.setLayoutX(100);
        registerButton.setLayoutY(400);
        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            int age = Integer.parseInt(ageField.getText());
            long phoneNumber = Long.parseLong(phoneNumberField.getText());
            Player player = new Player(username, age, phoneNumber);
            getPlayerList().add(player);
            System.out.println("player added");
            new GameBackEnd(mainStage, new GamePlayUI(), player, false);
        });
    }

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

    public TextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public TextField getAgeField() {
        return ageField;
    }

    public void setAgeField(TextField ageField) {
        this.ageField = ageField;
    }

    public TextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public void setPhoneNumberField(TextField phoneNumberField) {
        this.phoneNumberField = phoneNumberField;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}