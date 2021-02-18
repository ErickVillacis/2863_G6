package fifastreet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ConexionDB
{
   private final String server="jdbc:mysql://localhost:3306/fifastreet";
   public boolean conectar()
   {
   
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(server,"root","");
            conexion.close();
           
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return false;
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
            return false;
        }
     
   return true;
    }

   public String[][] datosLogin()
    {
        
        String[][] tabla=new String[2][3];
       int cont=0;
       if(!this.conectar())
       {
               JOptionPane.showMessageDialog(null, "Error al obtener los datos de inicio sesión", "ERROR", JOptionPane.ERROR_MESSAGE);
               System.exit(0);
           return null;
           
       }
        Connection conexion=null;
        Statement sentencia=null;
        ResultSet rs=null;
        try 
        {
            
            conexion = DriverManager.getConnection(server,"root","");
            String consulta = "SELECT * FROM usuario";
            sentencia = conexion.createStatement();
             rs = sentencia.executeQuery(consulta);
            
          while (rs.next())
          {
                Integer id = rs.getInt("USU_ID");
                String user = rs.getString("USU_NICK");
                String password = rs.getString("USU_PASS");
                
                tabla[cont][0]=id.toString();
                tabla[cont][1]=user;
                tabla[cont][2]=password;

                cont++;
          }
          
      sentencia.close();
     
        }    
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            tabla=null;
        } 
     return tabla;

    }
    
    public int registrarEquipo(String nombre, String responsable, String contacto)
    {
  
        Connection conexion=null;
        ResultSet rs=null;
        Statement sentencia=null;
        int id=0;
        try 
        {           
            conexion = DriverManager.getConnection(server,"root","");
             sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO equipo (EQUIPO_NOMBRE, EQUIPO_CONTACTO, EQUIPO_RESPONSABLE) VALUES ('"+nombre+"','"+contacto+"','"+responsable+"')");
              
          String queryForId = "SELECT LAST_INSERT_ID() FROM equipo";
          
            ResultSet rs2 = sentencia.executeQuery(queryForId);
   
            while ( rs2.next() ) 
            {
                id= rs2.getInt("LAST_INSERT_ID()");          
            }

            
            sentencia.close();
              conexion.close();

        }    
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 

        return id;
    }
    
     public void registrarJugador(int equipo, String cedula, String posicion, String nombre, int num, String camiseta, String nacimiento, String foto)
    {
  
        Connection conexion=null;
        ResultSet rs=null;
        Statement sentencia=null;
        int id=0;
        try 
        {           
            conexion = DriverManager.getConnection(server,"root","");
             sentencia = conexion.createStatement();
              sentencia.executeUpdate("INSERT INTO jugador (EQUIPO_ID, JUG_CEDULA, JUG_POSICION, JUG_NOMBRE, JUG_NUM, JUG_CAMISETA, JUG_NACIMIENTO, JUG_FOTO) VALUES ('"+new Integer(equipo).toString()+"','"+cedula+"','"+posicion+"','"+nombre+"','"+new Integer(num).toString()+"','"+camiseta+"','"+nacimiento+"','"+foto+"')");
            
            sentencia.close();
              conexion.close();

        }    
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 

       
    }
     
    public boolean getEquipos()
    {
       if(!this.conectar())
       {
          JOptionPane.showMessageDialog(null, "Error al obtener los datos del asiento", "ERROR", JOptionPane.ERROR_MESSAGE);
           return false;
       }
        Connection conexion=null;
        ResultSet rs=null;
        Statement sentencia=null;
        try 
        {           
            conexion = DriverManager.getConnection(server,"root","");
            String consulta = "SELECT * FROM equipo";
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(consulta);

               if(!rs.next())
                {
                   return false;
                   
               }
               else
               {
                  sentencia.close();
                   conexion.close();
                    return true;
               }
             

        }    
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 
             return false;
        
    }
    
    public void dataCampeonato()
    {
         int f=0;
         int g=-1;

      Campeonato team = Campeonato.getInstancia();
       Jugadores jugadores=null;
        
       if(!this.conectar())
       {
          JOptionPane.showMessageDialog(null, "Error al obtener los datos del asiento", "ERROR", JOptionPane.ERROR_MESSAGE);
           return;
       }
        Connection conexion=null;
        ResultSet rs=null;
       ResultSet rs2=null;
        ResultSet rs3=null;
        Statement sentencia=null;
      Statement sentencia2=null;
        Statement sentencia3=null;
       int amaCount=0;
       int rojCount=0;
      
        
        try 
        {           
            
             conexion = DriverManager.getConnection(server,"root","");
            sentencia = conexion.createStatement();
             sentencia2 = conexion.createStatement();
             sentencia3 = conexion.createStatement();
             rs = sentencia.executeQuery("SELECT * FROM equipo");
            rs2 = sentencia2.executeQuery("SELECT * FROM jugador");
             Equipos equipos = new Equipos();
            
         while (rs.next())
          {

                
                equipos.setNombreEquipo(rs.getString("EQUIPO_NOMBRE"));
                equipos.setPersonaResponsable(rs.getString("EQUIPO_RESPONSABLE"));
                equipos.setContactoResponsable(rs.getString("EQUIPO_CONTACTO"));
                
                team.AñadirEquipo(equipos);
                
        
                
                   while (rs2.next())
                   {
                           jugadores = new Jugadores(); 
                       g++;
                         rs3=sentencia3.executeQuery("SELECT * FROM tarjeta WHERE EQUIPO_ID='"+rs.getString("EQUIPO_ID")+"' AND JUG_ID='"+rs2.getString("JUG_ID")+"'");
                         
                        jugadores.setCedula(rs2.getString("JUG_CEDULA"));
                         jugadores.setFechaNacimiento(rs2.getString("JUG_NACIMIENTO"));
                        jugadores.setNombre(rs2.getString("JUG_NOMBRE"));
                        jugadores.setNumeroCamisa(rs2.getString("JUG_CAMISETA"));
                        jugadores.setPosicionCampo(rs2.getString("JUG_POSICION"));
                         f  = team.getContadorEquipos();
                            team.getEquipos().get(f).AñadirJugador(jugadores);  
                         
                         while (rs3.next())
                          {
                            amaCount=rs3.getInt("TARJETA_AMARILLA");
                            rojCount=rs3.getInt("TARJETA_ROJA");
                          }
                         
                          if(amaCount!=0)
                          {
                              for(int i=0; i<amaCount; i++)
                              {
                                     team.getEquipos().get(f).getJugadores().get(g).AñadirAmarilla();
                                    team.getEquipos().get(f).getJugadores().get(g).setAuxAmarilla(team.getEquipos().get(f).getJugadores().get(g).getAuxAmarilla()+1);
                                    team.getEquipos().get(f).getJugadores().get(g).CalcularMulta();
                              }
                              

                          }
                          
                          if(rojCount!=0)
                          {
                               for(int i=0; i<rojCount; i++)
                              {
                                        team.getEquipos().get(f).getJugadores().get(g).AñadirRoja();
                                    team.getEquipos().get(f).getJugadores().get(g).setAuxRoja(team.getEquipos().get(f).getJugadores().get(g).getAuxRoja()+1);
                                    team.getEquipos().get(f).getJugadores().get(g).CalcularMulta();
                              }
                          }
                         
                          amaCount=0;
                          rojCount=0;
                         jugadores=null;
                             
                   }
                   
                  g=-1;
      
          }
         try
         {
             sentencia3.close(); 
         }
         catch(Exception ex)
         {}
    
      sentencia.close();
      sentencia2.close();    
      
   

        }    
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 
        
        
    }
    
     public void insertTarjeta(String Equipo, String Nombre, boolean Amarilla, boolean Roja)
     {
          if(!this.conectar())
       {
          JOptionPane.showMessageDialog(null, "Error al obtener los datos del asiento", "ERROR", JOptionPane.ERROR_MESSAGE);
           return;
       }
               
        Connection conexion=null;
        ResultSet rs=null;
        Statement sentencia=null;
        ResultSet rs2=null;
        ResultSet rs3=null;
        Statement sentencia2=null;
        Statement sentencia3=null;
        Statement sentencia4=null;
        
        String equipoId="";
        String jugId="";
        
        try 
        {           
            conexion = DriverManager.getConnection(server,"root","");
            String consulta = "SELECT a.JUG_ID, a.EQUIPO_ID from jugador a INNER JOIN equipo b ON a.EQUIPO_ID=b.EQUIPO_ID WHERE a.JUG_NOMBRE='"+Nombre+"' AND b.EQUIPO_NOMBRE='"+Equipo+"'";
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(consulta);

         while (rs.next())
          {
                equipoId=rs.getString("EQUIPO_ID");
                jugId=rs.getString("JUG_ID");
              
          }
         
          sentencia.close();
          
          String cns2="SELECT * FROM tarjeta WHERE EQUIPO_ID='"+equipoId+"' AND JUG_ID='"+jugId+"'";
          sentencia2 = conexion.createStatement();
          rs2=sentencia2.executeQuery(cns2);
                    
               if(!rs2.next())
               {
                   
                   if(Amarilla)
                   {
                         sentencia3 = conexion.createStatement();
                         sentencia3.executeUpdate("INSERT INTO tarjeta (EQUIPO_ID, JUG_ID, TARJETA_AMARILLA,TARJETA_ROJA) VALUES ('"+equipoId+"','"+jugId+"','1','0')");
                              sentencia3.close();
                   
                   }
                   
                   if(Roja)
                   {
                         sentencia3 = conexion.createStatement();
                         sentencia3.executeUpdate("INSERT INTO tarjeta (EQUIPO_ID, JUG_ID, TARJETA_AMARILLA,TARJETA_ROJA) VALUES ('"+equipoId+"','"+jugId+"','0','1')");
                        sentencia3.close();
                   }
                   
                   
               }
               
               else
               {
                   Integer temp=0;
                   Integer temp2=0;
                   
                        String cnsalt="SELECT * FROM tarjeta WHERE EQUIPO_ID='"+equipoId+"' AND JUG_ID='"+jugId+"'";
                        sentencia4 = conexion.createStatement();
                        rs3=sentencia4.executeQuery(cnsalt);
                   
                   while (rs3.next())
                   {
                       temp=rs3.getInt("TARJETA_AMARILLA");
                       temp2=rs3.getInt("TARJETA_ROJA");
                   }
                   
                       sentencia4.close();
                   if(Amarilla)
                   {
                       temp++;
                         String csn3 = "UPDATE tarjeta SET TARJETA_AMARILLA = ? WHERE EQUIPO_ID = ? AND JUG_ID = ?";
                          PreparedStatement preparedStmt = conexion.prepareStatement(csn3);
                          preparedStmt.setString   (1, (temp).toString());
                         preparedStmt.setString(2, equipoId);
                        preparedStmt.setString(3, jugId);
                        preparedStmt.executeUpdate();
                   
                   }
                   
                   if(Roja)
                   {
                          temp2++;
                         String csn3 = "UPDATE tarjeta SET TARJETA_ROJA = ? WHERE EQUIPO_ID = ? AND JUG_ID = ?";
                          PreparedStatement preparedStmt = conexion.prepareStatement(csn3);
                          preparedStmt.setString   (1, (temp2).toString());
                         preparedStmt.setString(2, equipoId);
                        preparedStmt.setString(3, jugId);
                        preparedStmt.executeUpdate();
                   }
                   

               }
                
           sentencia2.close();     
    
   
           conexion.close();

        }    
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 

       
     }
     
       public void pagar(String Equipo)
      {
          if(!this.conectar())
            {
                    JOptionPane.showMessageDialog(null, "Error al obtener los datos del asiento", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
               
        Connection conexion=null;
        ResultSet rs=null;
        Statement sentencia=null;
        ResultSet rs2=null;
        ResultSet rs3=null;
        Statement sentencia2=null;
        Statement sentencia3=null;
        Statement sentencia4=null;
        
        String equipoId="";
        String jugId="";
        
        try 
        {                                                                                                                               
            conexion = DriverManager.getConnection(server,"root","");
            String consulta = "SELECT EQUIPO_ID from equipo WHERE EQUIPO_NOMBRE='"+Equipo+"'";
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(consulta);

         while (rs.next())
          {
                jugId=rs.getString("EQUIPO_ID");
          }
         
          sentencia.close();
          
          String cns2="SELECT * FROM tarjeta WHERE EQUIPO_ID='"+jugId+"'";
          sentencia2 = conexion.createStatement();
          rs2=sentencia2.executeQuery(cns2);
                    
               if(rs2.next())
               {
                    String csns3 = "DELETE FROM tarjeta WHERE EQUIPO_ID = ?";
                 PreparedStatement preparedStmt = conexion.prepareStatement(csns3);
                 preparedStmt.setString (1, jugId);
                  preparedStmt.executeUpdate();
                 conexion.close();
               }
  
           sentencia2.close();     
           conexion.close();

        }    
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 

       
     }
    
   
}
