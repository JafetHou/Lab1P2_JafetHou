
package lab1p2_jafethou;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Lab1P2_JafetHou {

    static Scanner lea = new Scanner (System.in);
    static Scanner leer = new Scanner (System.in);
    
    public static void main(String[] args) throws ParseException {
        
        ArrayList <Usuarios> registro = new ArrayList();
        
        boolean seguir = true;
        
        while (seguir){
            
            System.out.println("---Menu---");
            System.out.println("1) Registrar Usuario");
            System.out.println("2) Listar Todo");
            System.out.println("3) Listar por dominio");
            System.out.println("Ingrese [4] para salir ");
            int opc = lea.nextInt();
            
            switch(opc){
                
                case 1:{
                    
                    agregar(registro);
                    
                    break;
                }
            }
            
        }
    }
    public static void agregar(ArrayList <Usuarios> registro) throws ParseException{
        
        boolean valido = false; 
        
        System.out.println("Ingrese su nombre: ");
        String nombre = leer.next();
        
        System.out.println("Ingrese su apellido: ");
        String apellido = leer.next();
    
        System.out.println("Ingrese su fecha de nacimiento [dd/MM/yyy]: ");
        String nacimiento = leer.next();
        SimpleDateFormat osd = new SimpleDateFormat("dd/MM/yyy");
        Date fecha = osd.parse(nacimiento);
        
        System.out.println("Ingrese su correo: ");
        String correo = leer.next();
        
        System.out.println("Ingrese contrasena: ");
        String contra = leer.next();
        
        validar(correo, valido);
        
        if(valido == true){
            Usuarios inventario = new Usuarios (nombre, apellido, fecha, correo, contra);
            registro.add(inventario);
        }
        
    }
    public static String validar(String correo, boolean valido){
        String dominio[] = correo.split("@");
        String c = "";
        c = dominio[1];
        
        while(valido == false){
        
            if(c.equals("gmail.com")){
                valido = true;
            }
            if(c.equals("outlook.com")){
                valido = true;
            }
            if(dominio.equals("yahoo.com")){
                valido = true;
            }
            if(dominio.equals("icloud.com")){
                valido = true;
            }
            if(dominio.equals("protonmail.com")){
                valido = true;
            }
            if(dominio.equals("fastmail.com")){
                valido = true;
            }
            else if(valido == false){
                System.out.println("Ingrese un dominio de correo valido: ");
                correo = leer.next();
            }
        }       
        return correo;
    }
    
}
