package com.example.ap_assignment03.Model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameButtons extends Button {
    private final String fontPath = "src/main/java/com/example/ap_assignment03/Model/Amatic-Bold.ttf";
    private final String  pressedButtonImage = "-fx-background-color: brown; -fx-background-image: url('D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\red_button_pressed.png');";
    private final String freeButtonImage  = "-fx-background-color: brown; -fx-background-image: url('D:\\Users\\devch\\Documents\\AP_Assignment03\\src\\main\\resources\\com\\example\\ap_assignment03\\red_button.png');";

    public GameButtons(String msg) throws FileNotFoundException {
        setText(msg);
        setGameButtonFont();
        setPrefWidth(190); // 190
        setPrefHeight(49); // 49
        setStyle(freeButtonImage);
        initializeButtonListeners();
    }

    public GameButtons(String msg, double pWidth, double pHeight) throws FileNotFoundException {
        setText(msg);
        setGameButtonFont();
        setPrefWidth(pWidth); // 190
        setPrefHeight(pHeight); // 49
        setStyle(freeButtonImage);
        initializeButtonListeners();
    }

    private void setGameButtonFont() throws FileNotFoundException {
        try{
            setFont(Font.loadFont(new FileInputStream(fontPath), 23));
        }catch (FileNotFoundException e){
            setFont(Font.font("Verdana", 23));
        }

        setPrefHeight(190);
        setPrefWidth(49);
        setStyle(this.freeButtonImage);
        initializeButtonListeners();
    }

    private void setPressedButtonStyle(){
        setStyle(this.pressedButtonImage);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);

    }

    private void setFreeButtonStyle(){
        setStyle(this.freeButtonImage);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    public void initializeButtonListeners(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setPressedButtonStyle();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setFreeButtonStyle();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(null);
            }
        });

    }

}
