package com.example.ap_assignment03.GameMechanics;

import com.example.ap_assignment03.Model.GameButtons;
import com.example.ap_assignment03.UI.GameOverUI;
import com.example.ap_assignment03.UI.GamePlayUI;
import com.example.ap_assignment03.UI.MenuUI;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import com.example.ap_assignment03.Game.Player;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Random;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.animation.RotateTransition;



public class GameBackEnd {
    private final double minGap = 10, maxGap = 400;
    private Pillar pillar1, pillar2;
    private Stage stage;
    private Scene scene;
    private Player player;
    private Stick stick;
    private Score score;
    private AnchorPane layout;
    private Cherry cherry;

    private Character hero;
    private boolean isOut = false;
    private boolean isStickIncreasing = false; // used as button pressed flag
    private int lengthInc = 0;
    private boolean isHeroMoving = false;
    private int isHeroUp = 1;
    private boolean isCherryThere = false;

    private GameButtons exitButton;
    private GameButtons reviveButton;

    public GameBackEnd(Stage mainStage, GamePlayUI playUI, Player player, boolean flag) {
        this.stage = mainStage;
        this.pillar1 = playUI.getPillar1();
        this.pillar2 = playUI.getPillar2();
        this.scene = playUI.getPlayScene();
        this.layout = playUI.getPlayLayout();
        this.player = player;
        if (!flag){
            this.score = new Score();
        }else{
            this.score = getPlayer().getReviveScore();
        }
        // this.hero = new Character();
        stage.setScene(scene);
        runGame();
        try {
            createPauseExitGameButton();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        initializeButtonListeners();
    }

    public void setCherry(Cherry cherry) {
        this.cherry = cherry;
    }

    public Player getPlayer() {
        return player;
    }

    public Cherry getCherry() {
        return cherry;
    }

    public Stick getStick() {
        return stick;
    }

    public Pillar getPillar1() {
        return pillar1;
    }

    public Pillar getPillar2() {
        return pillar2;
    }

    public void setPillar1(Pillar pillar1) {
        this.pillar1 = pillar1;
    }

    public void setPillar2(Pillar pillar2) {
        this.pillar2 = pillar2;
    }

    public void setLengthInc(int lengthInc) {
        this.lengthInc = lengthInc;
    }

    public void setStick(Stick stick) {
        this.stick = stick;
    }

    public AnchorPane getLayout() {
        return layout;
    }

    public Character getHero() {
        return hero;
    }

    public Scene getScene() {
        return scene;
    }

    public Score getScore() {
        return score;
    }

    public Stage getStage() {
        return stage;
    }

    public void setHero(Character hero) {
        this.hero = hero;
    }

    public GameButtons getExitButton() {
        return exitButton;
    }

    public GameButtons getReviveButton() {
        return reviveButton;
    }

    public void setExitButton(GameButtons exitButton) {
        this.exitButton = exitButton;
    }

    public void setReviveButton(GameButtons reviveButton) {
        this.reviveButton = reviveButton;
    }

    public boolean rotateHero = false;

    private void endGame(){
        getPlayer().setReviveScore(getScore());
        new GameBackEnd(getStage(), new GamePlayUI(), getPlayer(), true);
    }

    private static int generateRandomZeroOrOne() {
        Random random = new Random();
        return random.nextInt(2); // Generates a random number either 0 or 1
    }

    private void createReviveButton() throws FileNotFoundException {
        GameButtons button1 = new GameButtons("Revive");
        layout.getChildren().add(button1);
        button1.setLayoutX(322);
        button1.setLayoutY(236);
        setReviveButton(button1);
        button1.setOnAction(e->{
            layout.getChildren().remove(getReviveButton());
            layout.getChildren().remove(getExitButton());
            endGame();
        });
    }

    private void createPauseExitGameButton() throws FileNotFoundException{
        GameButtons button3 = new GameButtons("X");
        layout.getChildren().add(button3);
        button3.setLayoutX(32);
        button3.setLayoutY(45);
        button3.setPrefHeight(45);
        button3.setPrefWidth(39);
        button3.setOnAction(e->{
           score.setStatus(false);
           player.getScoreList().add(score);
            try {
                new MenuUI(getStage());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void createExitButton() throws FileNotFoundException {
        GameButtons button2 = new GameButtons("Exit");
        layout.getChildren().add(button2);
        button2.setLayoutX(322);
        button2.setLayoutY(356);
        setExitButton(button2);
        button2.setOnAction(e->{
            getScore().setStatus(true);
            player.updateScoreList(score);
            GameOverUI gameOverUI = null;
            try {
                gameOverUI = new GameOverUI(getScore(), getStage());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            Scene gameOverScene = gameOverUI.getOverScene();
            getStage().setScene(gameOverScene);
        });
    }

    private void runGame(){
        insertStick();
        insertHero();
        new AnimationTimer(){
            @Override
            public void handle(long now) {

                if (isOut){
                    stop();
                    getLayout().getChildren().remove(getHero().getCharacterImageView());
                    getLayout().getChildren().remove(getStick().getShape());
                    try {
                        createReviveButton();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        createExitButton();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

                if (isStickIncreasing && !isHeroMoving){
                    animateStickInc();
                }
            }
        }.start();

    }

    private void insertHero(){
        Pillar pillar1 = getPillar1();
        Character hero = new Character();
        hero.getCharacterImageView().setLayoutX(pillar1.getShape().getLayoutX() + pillar1.getWidth() - hero.getWidth() - 20);
        hero.getCharacterImageView().setLayoutY(pillar1.getShape().getLayoutY()-55);
        setHero(hero);
        getLayout().getChildren().add(hero.getCharacterImageView());
    }

    private void initializeButtonListeners(){

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (isHeroMoving ){
                    if (isHeroUp == 1){
                        isHeroUp = 0;
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.05), getHero().getCharacterImageView());
                        rotateTransition.setAxis(Rotate.X_AXIS);
                        rotateTransition.setByAngle(180);
                        getHero().getCharacterImageView().setLayoutY(getHero().getCharacterImageView().getLayoutY() + getHero().getHeight() + getStick().getWidth() - 3);
                        rotateTransition.play();
                    }else if (isHeroUp == 0){
                        isHeroUp = 1;
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.05), getHero().getCharacterImageView());
                        rotateTransition.setAxis(Rotate.X_AXIS);
                        rotateTransition.setByAngle(180);
                        getHero().getCharacterImageView().setLayoutY(getHero().getCharacterImageView().getLayoutY() - getHero().getHeight() - getStick().getWidth());
                        rotateTransition.play();
                    }
                }
            }
        });
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                isStickIncreasing = true;
                if (!isHeroMoving && !isOut){
                    new AnimationTimer(){
                        @Override
                        public void handle(long l) {
                            increaseStickLength();
                            if (!isStickIncreasing){
                                stop();
                            }
                        }
                    }.start();
                }
            }
        });

        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!isHeroMoving){
                    isStickIncreasing = false;
                    rotateStick();
                }
            }
        });
    }

    private void increaseStickLength(){
        this.lengthInc += 3;
    }

    private void animateStickInc() {
        Stick stick = getStick();

        Duration duration = Duration.millis(10);

        double heightIncrease = lengthInc;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(stick.getShape().scaleYProperty(), 1), new KeyValue(stick.getShape().translateYProperty(), 0)),
                new KeyFrame(duration, new KeyValue(stick.getShape().scaleYProperty(), 1 + heightIncrease / stick.getHeight()), new KeyValue(stick.getShape().translateYProperty(), -heightIncrease / 2))
        );
        timeline.play();
    }

    private void rotateStick() {
        Stick stick = getStick();
        Stick stick1 = new Stick(15 + lengthInc, 10);
        setStick(stick1);
        layout.getChildren().remove(stick.getShape());

        double x = pillar1.getShape().getLayoutX() + pillar1.getWidth() - stick1.getWidth();
        double y = pillar1.getShape().getLayoutY() - stick1.getHeight();

        stick1.getShape().setLayoutX(x);
        stick1.getShape().setLayoutY(y);

        layout.getChildren().add(stick1.getShape());
        addRotationAndTranslation((Rectangle) stick1.getShape());

    }

    private void addRotationAndTranslation(Rectangle stickShape) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), stickShape);

        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(90);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), stickShape);

        translateTransition.setByX(stickShape.getHeight() / 2 + 5);
        translateTransition.setByY(stickShape.getHeight() / 2);

        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, translateTransition);

        parallelTransition.setOnFinished(event -> {

            moveHeroOnStick();

        });

        parallelTransition.play();

    }

    private void insertStick(){
        Pillar pillar1 = getPillar1();
        Stick stick1 = new Stick(15, 10);
        setStick(stick1);
        double x = pillar1.getShape().getLayoutX() + pillar1.getWidth() - stick1.getWidth();
        double y = pillar1.getShape().getLayoutY() - stick1.getHeight();
        stick1.getShape().setLayoutX(x);
        stick1.getShape().setLayoutY(y);
        layout.getChildren().add(stick1.getShape());
    }

    public int getLengthInc() {
        return lengthInc;
    }

    private void moveHeroOnStick(){

        Character player = getHero();

        isHeroMoving = true;

        double destinationX = getLengthInc() + player.getWidth() + 20;

        double time = ( destinationX-getHero().getCharacterImageView().getLayoutX() ) / getHero().getSpeed();

        double displacementCherry = 0;

        if (isCherryThere){
            displacementCherry = getCherry().getCherryImageView().getLayoutX() - getHero().getCharacterImageView().getLayoutX();
        }
        double timeCherry = displacementCherry / getHero().getSpeed();

        double timePillar2 = (getPillar2().getShape().getLayoutX() - getHero().getCharacterImageView().getLayoutX()) / getHero().getSpeed();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(time), player.getCharacterImageView());


        translateTransition.setToX(destinationX);

        Timeline cherryTimer = new Timeline(
            new KeyFrame(Duration.seconds(timeCherry), event -> {
                if (isHeroUp == 0){
                    getLayout().getChildren().remove(getCherry().getCherryImageView());
                    getScore().setCherryCnt(getScore().getCherryCnt()+1);
                }

            })
        );
        cherryTimer.setCycleCount(10);

        Timeline pillar2Timer = new Timeline(
            new KeyFrame(Duration.seconds(timePillar2), event -> {
                if (isHeroUp == 0){
                    isOut = true;
                }
            })
        );
        pillar2Timer.setCycleCount(10);

        translateTransition.setOnFinished(event -> {

            isHeroMoving = false;
            checkCondition();

        });

        // Play the translation
        translateTransition.play();
        cherryTimer.play();
        pillar2Timer.play();

    }

    private void checkCondition() {

        Stick stick = getStick();
        Pillar pillar1 = getPillar1();
        Pillar pillar2 = getPillar2();

        // +- 3 is a marginal error
        if (stick.getHeight() + 3 + pillar1.getShape().getLayoutX() + pillar1.getWidth() >= pillar2.getShape().getLayoutX() && stick.getHeight() - 3 + pillar1.getShape().getLayoutX() + pillar1.getWidth() <= pillar2.getShape().getLayoutX()+pillar2.getWidth()){

            isOut = false;
            System.out.println("Level Cleared");

            if (stick.getHeight() + 3 + pillar1.getShape().getLayoutX() + pillar1.getWidth() == pillar2.getShape().getLayoutX()+(pillar2.getWidth()/2)){
                getScore().setPillarCnt(getScore().getPillarCnt() + getScore().getBonusMultiplier());
            }else{
                getScore().setPillarCnt(getScore().getPillarCnt()+1);
            }
            moveToNextStage();

        }else{
            setScore(getScore());
            System.out.println("Out");
            System.out.println("Score: "+getScore().getTotal());
            isOut = true;
        }
    }

    public void setScore(Score score) {
        this.score = score;
    }

    private void moveToNextStage(){

        Stick stick1 = getStick();
        Character player = getHero();

        layout.getChildren().remove(getPillar1().getShape());
        layout.getChildren().remove(stick1.getShape());
        layout.getChildren().remove(getHero().getCharacterImageView());

        Pillar pillar1 = getPillar2();
        setPillar1(pillar1);

        player.getCharacterImageView().setLayoutY(getPillar1().getShape().getLayoutY()-55);
        player.getCharacterImageView().setLayoutX(getPillar1().getShape().getLayoutX());

        Random randomLeftMargin = new Random();

        double leftMargin = 0;
        while (leftMargin < 10){
            leftMargin = randomLeftMargin.nextDouble(30);
        }

        pillar1.getShape().setLayoutX(leftMargin);

        Pillar pillar2 = createNewPillar();
        setPillar2(pillar2);
        double gap = generateGap(pillar1, pillar2);
        pillar2.getShape().setLayoutX(gap);
        pillar2.getShape().setLayoutY(458);
        layout.getChildren().add(pillar2.getShape());

        insertStick();
        insertHero();
        if (isCherryThere){
            getLayout().getChildren().remove(getCherry().getCherryImageView());
        }
        generateCherry();
        setLengthInc(0);

        isHeroUp = 1;
    }

    private double generateGap(Pillar pillar1, Pillar pillar2){

        Random randomGap = new Random();
        double gap = 0;

        while (gap<pillar1.getShape().getLayoutX()+100+pillar1.getWidth()){
            gap = randomGap.nextDouble(600 - pillar2.getWidth());
        }

        return gap;
    }

    private Pillar createNewPillar(){

        Pillar pillar = new Pillar();
        setPillar2(pillar);
        return pillar;

    }

    private void insertCherry(){
        Cherry cherry = new Cherry();
        Pillar pillar1 = getPillar1();
        Pillar pillar2 = getPillar2();
        Random coordinate = new Random();

        // Check if there is enough space between pillars for cherry insertion
        if (pillar2.getShape().getLayoutX() - pillar1.getShape().getLayoutX() - pillar1.getWidth() < 100) {
            return;
        }

        double x;

        do {
            x = pillar1.getShape().getLayoutX() + pillar1.getWidth() + coordinate.nextDouble(pillar2.getShape().getLayoutX() - pillar1.getShape().getLayoutX() - pillar1.getWidth() - 20);
        } while (x + cherry.getWidth() + 20 > pillar2.getShape().getLayoutX());


        cherry.getCherryImageView().setLayoutX(x);
        cherry.getCherryImageView().setLayoutY(pillar1.getShape().getLayoutY() + 40);

        setCherry(cherry);
        getLayout().getChildren().add(cherry.getCherryImageView());
    }

    private void generateCherry(){
        if (generateRandomZeroOrOne() == 1){
            isCherryThere = true;
            insertCherry();
        }else{
            isCherryThere = false;
        }
    }
}
