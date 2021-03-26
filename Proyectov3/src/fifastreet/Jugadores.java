
package fifastreet;

import java.io.ByteArrayOutputStream;
import javax.swing.ImageIcon;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


class Jugadores {
    
    private String cedula, nombre, fechaNacimiento, posicionCampo, numeroCamisa, tarjetaAmarilla, tarjetaRoja, multa;
    int auxAmarilla = 0;
    int auxRoja = 0;
    ImageIcon foto,QR;

    public Jugadores() {
        cedula="";
        nombre="";
        fechaNacimiento="";
        posicionCampo="";
        numeroCamisa="";
        tarjetaAmarilla="0";
        tarjetaRoja="0";
        multa="0";
        auxAmarilla=0;
        auxRoja=0;
    }

    public void AñadirAmarilla(){
        tarjetaAmarilla = Integer.toString(Integer.parseInt(tarjetaAmarilla)+1);
    }
            
    public void AñadirRoja(){
        tarjetaRoja = Integer.toString(Integer.parseInt(tarjetaRoja)+1);
    }
    
    public void CalcularMulta(){
        multa = Integer.toString(auxAmarilla*10+auxRoja*50);
        //multa = Integer.toString((Integer.parseInt(tarjetaRoja)*50) + (Integer.parseInt(tarjetaAmarilla)*10));
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPosicionCampo() {
        return posicionCampo;
    }

    public void setPosicionCampo(String posicionCampo) {
        this.posicionCampo = posicionCampo;
    }

    public String getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(String numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public String getTarjetaAmarilla() {
        return tarjetaAmarilla;
    }

    public void setTarjetaAmarilla(String tarjetaAmarilla) {
        this.tarjetaAmarilla = tarjetaAmarilla;
    }

    public String getTarjetaRoja() {
        return tarjetaRoja;
    }

    public void setTarjetaRoja(String tarjetaRoja) {
        this.tarjetaRoja = tarjetaRoja;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public int getAuxAmarilla() {
        return auxAmarilla;
    }

    public void setAuxAmarilla(int auxAmarilla) {
        this.auxAmarilla = auxAmarilla;
    }

    public int getAuxRoja() {
        return auxRoja;
    }

    public void setAuxRoja(int auxRoja) {
        this.auxRoja = auxRoja;
    }
    
    public void CrearQR(){
        ByteArrayOutputStream out= QRCode.from(nombre+"\n"+cedula+"\n"+fechaNacimiento+"\n"+posicionCampo+"\n"+numeroCamisa).to(ImageType.PNG).stream();
        ImageIcon QR=new ImageIcon(out.toByteArray());
    }
    
    public ImageIcon MostrarQR(){
        return QR;
    }
    
}
