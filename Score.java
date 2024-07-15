package com.example.ap_assignment03.GameMechanics;


import com.example.ap_assignment03.Game.Player;
public class Score {

    private double points;
    private double cherryCnt;
    private double pillarCnt;
    private int perCherryPoint;
    private int perPillarPoint;
    private int bonusMultiplier;
    private boolean status = true;

    public Score() {
        this.points = 0;
        this.cherryCnt = 0;
        this.pillarCnt = 0;
        // Points scheme
        this.bonusMultiplier = 2;// multiplier
        this.perCherryPoint = 5;
        this.perPillarPoint = 2;
    }

    public void setPerCherryPoint(int perCherryPoint) {
        this.perCherryPoint = perCherryPoint;
    }

    public void setPerPillarPoint(int perPillarPoint) {
        this.perPillarPoint = perPillarPoint;
    }

    public void setBonusMultiplier(int bonusMultiplier) {
        this.bonusMultiplier = bonusMultiplier;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPerCherryPoint() {
        return perCherryPoint;
    }

    public int getPerPillarPoint() {
        return perPillarPoint;
    }

    public int getBonusMultiplier() {
        return bonusMultiplier;
    }

    public boolean isStatus() {
        return status;
    }

    public double getPoints() {
        return points;
    }

    public double getCherryCnt() {
        return cherryCnt;
    }

    public double getPillarCnt() {
        return pillarCnt;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setCherryCnt(double cherryCnt) {
        this.cherryCnt = cherryCnt;
    }

    public void setPillarCnt(double pillarCnt) {
        this.pillarCnt = pillarCnt;
    }

    public double getTotal(){
        double total = getCherryCnt() * getPerCherryPoint() + getPillarCnt() * getPerCherryPoint();
        setPoints(total);
        return total;
    }
}
