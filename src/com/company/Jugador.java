package com.company;

public class Jugador {
    //startingNumber: es el puesto en todo el juego
    //pointsObtained: son los puntos obtenidos en todo el juego
    private String name;
    private String location;
    private int startingNumber;
    private int pointsObtained;


    public Jugador(String name, String location, int startingNumber, int pointsObtained) {
        this.name = name;
        this.location = location;
        this.startingNumber = startingNumber;
        this.pointsObtained = pointsObtained;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStartingNumber() {
        return startingNumber;
    }

    public void setStartingNumber(int startingNumber) {
        this.startingNumber = startingNumber;
    }

    public int getPointsObtained() {
        return pointsObtained;
    }

    public void setPointsObtained(int pointsObtained) {
        this.pointsObtained = pointsObtained;
    }
}
