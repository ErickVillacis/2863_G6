/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifastreet;

import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class Campeonato {
    
    //ATRIBUTOS
    ArrayList<Equipos> equipos;
    private String nombreCampeonato, premio1, premio2, premio3;    
    public static Campeonato Instancia;
    private int contadorEquipos;
    
    //CONSTRUCTOR
    private Campeonato() {
        equipos = new ArrayList();
        nombreCampeonato = "";
        premio1 = "";
        premio2 = "";
        premio3 = "";
        contadorEquipos = -1;
    }

    //SINGLETON
    public static Campeonato getInstancia(){
        if (Instancia == null){
            Instancia = new Campeonato();
        }
        return Instancia;
    }
    
    //METODO ANADIR EQUIPO
    public void AñadirEquipo (Equipos e) {
        equipos.add(e);
        contadorEquipos++;
    }

    // GETTER Y SETTERS
    public ArrayList<Equipos> getEquipos() {
        return equipos;
    }

    public String getNombreCampeonato() {
        return nombreCampeonato;
    }

    public void setNombreCampeonato(String nombreCampeonato) {
        this.nombreCampeonato = nombreCampeonato;
    }

    public String getPremio1() {
        return premio1;
    }

    public void setPremio1(String premio1) {
        this.premio1 = premio1;
    }

    public String getPremio2() {
        return premio2;
    }

    public void setPremio2(String premio2) {
        this.premio2 = premio2;
    }

    public String getPremio3() {
        return premio3;
    }

    public void setPremio3(String premio3) {
        this.premio3 = premio3;
    }

    public int getContadorEquipos() {
        return contadorEquipos;
    }

    public void setContadorEquipos(int contadorEquipos) {
        this.contadorEquipos = contadorEquipos;
    }

    
    
    
}
