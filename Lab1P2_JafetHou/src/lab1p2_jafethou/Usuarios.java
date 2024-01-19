
package lab1p2_jafethou;

import java.awt.Color;
import java.util.Date;


public class Usuarios {
    
    String nombre;
    String apellido;
    String edad;
    String correo;
    String contra;
    
    public Usuarios(String nombreN, String apellidoN, String edadN, String correoN, String contraN){
        this.nombre = nombreN;
        this.apellido = apellidoN;
        this.edad = edadN;
        this.correo = correoN;
        this.contra = contraN;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getedad() {
        return edad;
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

    public void setedad(String edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public String toString() {
        
        return " nombre: " + nombre + ", apellido: " + apellido + ", edad: " + edad + ", correo: " + correo + ", contra: " + contra + '}';
    }
    
    
}
