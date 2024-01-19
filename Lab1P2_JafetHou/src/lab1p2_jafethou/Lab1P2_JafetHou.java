
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
                case 2:{
                    
                    break;
                }
                case 3:{
                    
                    break;
                }
                case 4:{
                    seguir = false;
                    break;
                }
            }
            
        }
    }
    public static void agregar(ArrayList <Usuarios> registro) throws ParseException{
        
        boolean valido = false;
        boolean valcontra = false;
        
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
        validarcontra(contra, valcontra);
        
        if(valido == true && valcontra == true){
            
            Usuarios inventario = new Usuarios (nombre, apellido, fecha, correo, contra);
            registro.add(inventario);
            
        }
        
    }
    public static String validar(String correo, boolean valido){
        
        while(valido == false){
        
            String dominio[] = correo.split("@");
            String c = "";
            c = dominio[1];
            
            if(c.equalsIgnoreCase("gmail.com")){
                valido = true;
            }
            if(c.equalsIgnoreCase("outlook.com")){
                valido = true;
            }
            if(c.equalsIgnoreCase("yahoo.com")){
                valido = true;
            }
            if(c.equalsIgnoreCase("icloud.com")){
                valido = true;
            }
            if(c.equalsIgnoreCase("protonmail.com")){
                valido = true;
            }
            if(c.equalsIgnoreCase("fastmail.com")){
                valido = true;
            }
            else if(valido == false){
                System.out.println("Ingrese un dominio de correo valido: ");
                correo = leer.next();
            }
        }       
        return correo;
    }
    public static String validarcontra(String contra, boolean valcontra){
        
        while(valcontra == false){
            
            boolean mayusculas = false;
            boolean minusculas = false;
            boolean numero = false;
            boolean simbolo = false;
            
            if(contra.length() >= 8){

               for (int i = 0; i < contra.length(); i++) {

                   char carac = contra.charAt(i);

                   if(carac >= 65 && carac <= 90 ){

                        mayusculas = true;
                   }
               }
                for (int i = 0; i < contra.length(); i++) {

                    char carac = contra.charAt(i);

                    if(carac >= 97 && carac <= 122){
                        minusculas = true;
                    }
                }
                for (int i = 0; i < contra.length(); i++) {

                    char carac = contra.charAt(i);

                    if(carac >= 48 && carac <= 57){
                        numero = true;
                    }
                }
                for (int i = 0; i < contra.length(); i++) {

                    char carac = contra.charAt(i);

                    if(carac == 33 || carac == 63 || carac == 60 || carac == 62 || carac == 36 || carac == 37){
                        simbolo = true;
                    }
                }
                
                if(mayusculas == true && minusculas == true && numero == true && simbolo == true){
                    
                    valcontra = true;
                    
                }else{
                    
                    System.out.println("Ingrese una contrasena correcta: ");
                    contra = leer.next();
                
                }
            }
        }
        return contra;
    }
    
}
