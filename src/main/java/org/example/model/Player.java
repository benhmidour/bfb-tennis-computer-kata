package org.example.model;

public class Player {
    private char id;
    private int points = 0;
    private boolean winner = false;

    public Player(char id) {
        this.id = id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public char getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void incrementPoints() {
        this.points++;
    }

    public void resetPoints() {
        this.points = 0;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public String getScore() {
        return switch (points) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "Invalid";
        };
    }
}