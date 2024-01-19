
package lab1p2_jafethou;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Lab1P2_JafetHou {

    static Scanner lea = new Scanner (System.in);
    static Scanner leer = new Scanner (System.in);
    
    public static void main(String[] args) throws ParseException {
        boolean valido = false;
        boolean valcontra = false;
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
                    
                    agregar(registro, valido, valcontra);
                    
                    break;
                }
                case 2:{
                    
                    listat(registro);
                    
                    break;
                }
                case 3:{
                    
                    listadominio(registro);
                    
                    break;
                }
                case 4:{
                    seguir = false;
                    break;
                }
            }
            
        }
    }
    public static void agregar(ArrayList <Usuarios> registro, boolean valido, boolean valcontra) throws ParseException{
        Date factual = new Date();
        
        System.out.println("Ingrese su nombre: ");
        String nombre = leer.next();
        
        System.out.println("Ingrese su apellido: ");
        String apellido = leer.next();
    
        System.out.println("Ingrese su fecha de nacimiento [dd/MM/yyyy]: ");
        String nacimiento = leer.next();
        
        SimpleDateFormat osd = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = osd.parse(nacimiento);
        int anios = factual.getYear() - fecha.getYear();
        
        Calendar actual = Calendar.getInstance();
        Calendar calnacimiento = Calendar.getInstance();
        calnacimiento.setTime(fecha);
       
        String edad = edad(anios,actual,calnacimiento);
        
        System.out.println("Ingrese su correo: ");
        String correo = leer.next();
        
        System.out.println("Ingrese contrasena: ");
        String contra = leer.next();
        
        validar(correo, valido);
        validarcontra(contra, valcontra);
        
        if(valido == false && valcontra == false && anios >= 13){
            
            Usuarios inventario = new Usuarios (nombre, apellido, edad, correo, contra);
            registro.add(inventario);
            
        }else{
            System.out.println("Debe ser mayor a 13 anios ");
        }
        
    }
    
    public static String edad(int anios, Calendar actual, Calendar calnacimiento) throws ParseException{
        
        anios = actual.get(Calendar.YEAR) - calnacimiento.get(Calendar.YEAR);
        int meses = actual.get(Calendar.MONTH) - calnacimiento.get(Calendar.MONTH);
        int dias = actual.get(Calendar.DAY_OF_MONTH) - calnacimiento.get(Calendar.DAY_OF_MONTH);
        
        if(anios < 0){
            anios = anios-anios*2;
        }
        if(meses < 0){
            meses = meses-meses*2;
        }
        if(dias < 0){
            dias = dias-dias*2;
        }
        
        String edad = anios-1+" anios "+ meses+ " meses "+ dias +" dias";
                
        return edad;
    }
    public static boolean validar(String correo, boolean valido){
        
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
        System.out.println(valido);
        return valido;
    }
    public static boolean validarcontra(String contra, boolean valcontra){
        
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
        System.out.println(valcontra);
        return valcontra;
    }
    public static void listat(ArrayList <Usuarios> registro) throws ParseException{
        
        for (int i = 0; i < registro.size(); i++) {
            System.out.println(i+1+") "+registro.get(i).toString());
        }
    }
    public static void listadominio(ArrayList <Usuarios> registro) throws ParseException{
        
        for (int i = 0; i < registro.size(); i++) {
            String dominios = "gmail.com, Outlook.com, Yahoo.com, iCloud.com, ProtonMail.com, FastMail.com";
            String dom;
            
            StringTokenizer tkns = new StringTokenizer(registro.get(i).toString(), "@");
            while(tkns.hasMoreTokens()){
                dom = tkns.nextToken();
                System.out.println(dom);
            }
            //System.out.println(i+1+") "+registro.get(i).toString());
            
        }
    }
    
}
