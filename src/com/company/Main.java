package com.company;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	/*File archivo = new File("resources/jugadores.csv");
    if (archivo.exists()){
        System.out.println("El archivo existe ");
        System.out.println("La ruta absoluta: "+archivo.getAbsolutePath());
        System.out.println("¿Es un archivo? "+ archivo.isFile());
        System.out.println("se puede leer "+archivo.canRead());
    }else{
        System.out.println("el archivo no existe");
    }*/


        ServiceJugador service = new ServiceJugador("","jugadores.csv");
        String name = JOptionPane.showInputDialog("Esrciba nombre:");
        String location = JOptionPane.showInputDialog("Escribir ubicacion");
        int startingNumber = Integer.parseInt(JOptionPane.showInputDialog("Escribir numero de partida"));
        int pointsObtained = Integer.parseInt(JOptionPane.showInputDialog("Escribir puntos obtenidos"));
        int numberMatches = Integer.parseInt(JOptionPane.showInputDialog("Escribir numero de partidos"));
        Jugador jugador = new Jugador(name,location,startingNumber,pointsObtained,numberMatches);
        service.addPlayer(jugador);
       // service.removePlayer();
        try {
            service.loadDate();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //service.removePlayer();
            service.dumpData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //service.removePlayer();
        System.out.println(service.getJugadores());
        System.out.println("Nuetsro jugadores: ");
        System.out.println(service.getJugador());

    }
}
