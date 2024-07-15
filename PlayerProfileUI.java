package com.example.ap_assignment03.UI;

import com.example.ap_assignment03.Game.Player;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerProfileUI {
    private static final int height = 700;
    private static final int width = 800;

    private AnchorPane layout; // layout -> AnchorPane
    private Scene mainScene;
    private Stage mainStage;
    private Player player;
    public PlayerProfileUI(Player a,Stage mainStage){
        this.player=a;
        this.layout = new AnchorPane();
        this.mainScene = new Scene(layout, width, height);
        this.mainStage = mainStage;
        this.mainStage.setScene(mainScene);
        this.mainStage.setScene(mainScene);
        createBackground();
        displayText();
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    private void createBackground(){
        Image backgroundImage = new Image("D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\background.jpg", 800, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        layout.setBackground(new Background(background));
    }
    public void displayText() {
        Text text = new Text();
        String s="";
        for (int i=0;i<=player.getScoreList().size()-1;i++){
            double val=player.getScoreList().get(i).getPoints();
            s+=val;
            s+=",";
        }
        text.setText("PLAYER STATS:\n Gamer Name: "+player.getName() +"\n Phone Number: "+player.getPhoneNo()+"Player Scores: "+ s);
        text.setX(400);
        text.setY(350);
        text.setFont(Font.font(20));
        layout.getChildren().add(text);
    }
}