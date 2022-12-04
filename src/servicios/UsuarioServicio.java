package servicios;

import entidades.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioServicio {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Usuario crearUsuario(){
        Usuario u = new Usuario();

        System.out.println("Ingrese el nombre del usuario titular: ");
        u.setNombre(ingresarNombre());

        System.out.println("Ingrese el apellido del usuario: ");
        u.setApellido(ingresarNombre());

        u.setEdad(ingresarEdad());

        System.out.println("Ingrese la dirección: ");
        u.setDireccion(sc.next());

        System.out.println("Ingrese el número de teléfono: ");
        u.setTelefono(sc.next());

        // nuevaCuenta();
        //u.setCuenta();

        return u;
    }

    public String ingresarNombre(){
        String nombre;
        boolean validador;
        do{
            nombre = sc.next();
            validador = validarIngresoSoloLetras(nombre);
        }while(validador);

        return nombre;
    }

    public int ingresarEdad(){
        int edad;
        System.out.println("Ingrese la edad del usuario: ");
        edad = validarIngresoEnteroPositivo();
        while(edad < 18 || edad > 130){
            System.out.println("La edad ingresada no es válida.");
            System.out.println("Ingrese la edad del usuario: ");
            edad = validarIngresoEnteroPositivo();
        }
        return edad;
    }


    public int validarIngresoEnteroPositivo(){
        int num = 0;
        boolean validador = true;
        do{
            try{
                num = sc.nextInt();
                if(num > 0){
                    validador = false;
                }else{
                    System.out.println("El número ingresado no es válido, no se permite el ingreso de números negativos.");
                }
            }catch(InputMismatchException a){
            System.out.println(a.getMessage());
            System.out.println("Solo puede ingresar números enteros, intentelo nuevamente.");
            sc.nextLine();
            }catch(Exception b){
            System.out.println(b.getMessage());
            System.out.println("Error de sistema, intentelo nuevamente.");
            sc.nextLine();
            }
        }while(validador);
        return num;
    }


    public boolean validarIngresoSoloLetras(String cadena){
        boolean resultado = true;
        int contador = 0;
        int valorASCII;
        char caracter;
        if(cadena.length() > 0){
            for (int i=0; i<cadena.length(); i++){
                caracter = cadena.charAt(i);
                valorASCII = (int) caracter;
                if(valorASCII < 97 || valorASCII > 122){
                    contador++;
                }
            }
            if(contador == 0) {
                resultado = false;
            }else{
                System.out.println("Solo puede ingresar letras, intentelo nuevamente.");
            }
        }else{
            System.out.println("No ingreso ningun caracter, intentelo nuevamente.");
        }
        return resultado;
    }
}
