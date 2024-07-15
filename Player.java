package com.example.ap_assignment03.Game;

import java.util.*;
import com.example.ap_assignment03.GameMechanics.Score;

public class Player {
    private final String name;
    private final int age;
    private final long phoneNo;
    private List<Score> scoreList;
    private Score reviveScore;
    public Player(String name, int age, long phoneNo) {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.scoreList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setReviveScore(Score reviveScore) {
        this.reviveScore = reviveScore;
    }
    public Score getReviveScore() {
        return reviveScore;
    }
    public List<Score> getScoreList() {
        return scoreList;
    }
    public void updateScoreList(Score score){
        getScoreList().add(score);
    }
}
