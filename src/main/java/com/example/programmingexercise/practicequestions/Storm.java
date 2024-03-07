package com.example.programmingexercise.practicequestions;

class RainStorm extends Storm{
    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;

    public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
        super(eyeRadius,eyePositionX,eyePositionY);
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
    }

    public double amountOfRain() {
        return eyeRadius * 20;
    }

}

class SnowStorm extends Storm{

    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;
    private double amountOfSnow;

    public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
        super(eyeRadius,eyePositionX,eyePositionY);
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
        this.amountOfSnow = amountOfSnow;
    }

    public double getAmountOfSnow() {
        return amountOfSnow;
    }
}

class Storm {
    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;

    public double getEyeRadius() {
        return eyeRadius;
    }

    public double getEyePositionX() {
        return eyePositionX;
    }

    public double getEyePositionY() {
        return eyePositionY;
    }

    public Storm(double eyeRadius, double eyePositionX, double eyePositionY) {
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
    }
    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }
}