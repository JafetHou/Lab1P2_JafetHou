
package lab1p2_jafethou;

import java.awt.Color;
import java.util.Date;


public class Usuarios {
    
    String nombre;
    String apellido;
    Date fecha;
    String correo;
    String contra;
    
    public Usuarios(String nombreN, String apellidoN, Date fechaN, String correoN, String contraN){
        this.nombre = nombreN;
        this.apellido = apellidoN;
        this.fecha = fechaN;
        this.correo = correoN;
        this.contra = contraN;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContra() {
        return contra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public String toString() {
        return " nombre: " + nombre + ", apellido: " + apellido + ", fecha: " + fecha + ", correo: " + correo + ", contra: " + contra + '}';
    }
    
    
}
