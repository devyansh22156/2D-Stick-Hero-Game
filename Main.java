package com.example.ap_assignment03.Game;

import com.example.ap_assignment03.UI.MenuUI;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.*;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        List<Player> playerList = new ArrayList<>();

        try {
            MenuUI menu = new MenuUI(playerList);
            stage = menu.getMainStage();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}