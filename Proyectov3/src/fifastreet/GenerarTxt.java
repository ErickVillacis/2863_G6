/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifastreet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Christopher
 */
public class GenerarTxt {
    private FileWriter archivo;
    private BufferedWriter escribir;

    public GenerarTxt() throws IOException {
        archivo=new FileWriter("ListaJugadores.txt",false);
        escribir=new BufferedWriter(archivo);
    }
    
    public void escribir(Campeonato team) throws IOException{
        archivo=new FileWriter("ListaJugadores.txt",false);
        escribir=new BufferedWriter(archivo);
        
        for (int i = 0; i < team.getEquipos().size(); i++) {
            escribir.write(team.getEquipos().get(i).getNombreEquipo());
            escribir.newLine();
            escribir.write(team.getEquipos().get(i).getPersonaResponsable()+" ");
            escribir.write(team.getEquipos().get(i).getContactoResponsable());
            escribir.newLine();
            
            for (int j = 0; j < 15; j++) {
                
                escribir.write(team.getEquipos().get(i).getJugadores().get(j).getNombre()+" ");
                escribir.write(team.getEquipos().get(i).getJugadores().get(j).getNumeroCamisa()+" ");
                escribir.write(team.getEquipos().get(i).getJugadores().get(j).getTarjetaAmarilla()+" ");
                escribir.write(team.getEquipos().get(i).getJugadores().get(j).getTarjetaRoja()+" ");
                escribir.newLine();
            }
        }
        escribir.close();
    }
    
    
}




