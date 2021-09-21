package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServiceJugador {

    public ArrayList<Jugador> jugador;
    private FilePlane file;

    public ServiceJugador(String path, String name) {
        jugador = new ArrayList<>();
        file = new FilePlane();
        file.setPathFile(path);
        file.setNameFile(name);
    }

    //Este metodo lo que hace es cargar los datos del archivo al arreglo
    public void loadDate() throws IOException, NumberFormatException, NoSuchElementException{
        file.openFile();
        String [] content = file.getContentFile();
        for(String record: content){
            StringTokenizer tokens = new StringTokenizer(record,",");
            while (tokens.hasMoreTokens()){
                try{
                    String name = tokens.nextToken();
                    String location = tokens.nextToken();
                    int startingNumber = Integer.parseInt(tokens.nextToken());
                    int pointsObtained = Integer.parseInt(tokens.nextToken());

                    jugador.add(new Jugador(name,location,startingNumber,pointsObtained));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }catch (NoSuchElementException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //Encontrar a algun jugador
    public Jugador findPlayer(String name){
      for (Jugador p: jugador){
          if(p.getName().equalsIgnoreCase(name)){
              return p;
          }
      }
      return null;
    }

    //adicionar
    public boolean addPlayer(Jugador jugadores){
        if (findPlayer(jugadores.getName())==null){
            jugador.add(jugadores);
            return  true;
        }
        return false;
    }

    //Agregar datos al archivo plano (jugadores.csv)
    public void dumpData() throws IOException{
        file.openFile();
        String [] dump = new String[jugador.size()];
        int cont =0;
        for (Jugador j: jugador){
            String name = j.getName();
            String location = j.getLocation();
            int startingNumber = j.getStartingNumber();
            int pointsObtained = j.getPointsObtained();
            dump[cont++] = name+","+location+","+startingNumber+","+pointsObtained;
        }
        file.setContentFile(dump);
    }

    public ArrayList<Jugador> getJugador(){
        return (ArrayList<Jugador>) jugador.clone();
    }
}
