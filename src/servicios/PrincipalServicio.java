package servicios;

import entidades.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalServicio {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void menu(){
        int opcion;

        do{
            System.out.println("\t\t Menú Principal");
            System.out.println("1. Ingresar un nuevo usuario.");
            System.out.println("2. Menú de usuario");
            System.out.println("3. Salir");
            System.out.println("Elíja una opción: ");
            opcion = validarIngresoEnteroPositivo();
            switch (opcion){
                case 1:
                    agregarNuevoUsuario();
                    break;
                case 2:
                    //menuUsuario()
                    System.out.println("ingresando al menu de usuario...");
                    break;
                case 3:
                    System.out.println("SALIENDO DEL PROGRAMA...");
                    break;
                default:
                    System.out.println("La opción ingresada no es válida, intentelo nuevamente");
            }
        }while(opcion != 3);
    }

    public void agregarNuevoUsuario(){
        UsuarioServicio usuarioSV = new UsuarioServicio();
        Usuario nuevoUsuario = usuarioSV.crearUsuario();
        if(nuevoUsuario != null){
            if(usuarios.size() < 10){
                System.out.println("creando usuario...");
                usuarios.add(nuevoUsuario);
                System.out.println("Se ingresaron " + usuarios.size() + " de 10 usuarios.");
            }else{
                System.out.println("Se alcanzó el máximo de usuarios permitido.");
            }
        }
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




}
