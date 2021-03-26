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
class Equipos {
    
    ArrayList<Jugadores> jugadores;
    private String nombreEquipo, personaResponsable, contactoResponsable;

    public Equipos() {
    jugadores = new ArrayList();
    nombreEquipo="";
    personaResponsable="";
    contactoResponsable="";
    }  

    public ArrayList<Jugadores> getJugadores() {
        return jugadores;
    }

    public void AñadirJugador(Jugadores j){ //Metodo
        jugadores.add(j);
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getPersonaResponsable() {
        return personaResponsable;
    }

    public void setPersonaResponsable(String personaResponsable) {
        this.personaResponsable = personaResponsable;
    }

    public String getContactoResponsable() {
        return contactoResponsable;
    }

    public void setContactoResponsable(String contactoResponsable) {
        this.contactoResponsable = contactoResponsable;
    }
    
    
}
