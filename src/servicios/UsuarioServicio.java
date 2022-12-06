package servicios;

import entidades.Cuenta;
import entidades.Usuario;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UsuarioServicio {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");


    public Usuario crearUsuario(ArrayList<Usuario> usuarios){
        System.out.println("\t\t INGRESO DE DATOS PARA UN NUEVO USUARIO");
        CuentaServicio cuentaSv = new CuentaServicio();

        Usuario u = new Usuario();

        System.out.println("Ingrese el nombre del titular: ");
        u.setNombre(ingresarNombre());

        System.out.println("Ingrese el apellido: ");
        u.setApellido(ingresarNombre());

        u.setEdad(ingresarEdad());

        System.out.println("Ingrese la dirección: ");
        u.setDireccion(sc.next());

        System.out.println("Ingrese el número de teléfono: ");
        u.setTelefono(sc.next());

        System.out.println("Ingrese el correo electronico: ");
        u.setCorreo(sc.next());

        u.setCuenta(cuentaSv.crearCuenta(usuarios));

        return u;
    }
    public void agregarNuevoUsuario(ArrayList<Usuario> usuarios){
        Usuario nuevoUsuario = crearUsuario(usuarios);
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

    public String ingresarNombre(){
        String nombre;
        boolean validador;
        do{
            nombre = sc.next();
            validador = Validador.validarIngresoSoloLetras(nombre);
        }while(validador);

        return nombre;
    }

    public int ingresarEdad() {
        int edad;
        System.out.println("Ingrese la edad del usuario: ");
        edad = Validador.validarIngresoEnteroPositivo();
        while (edad < 18 || edad > 130) {
            System.out.println("La edad ingresada no es válida.");
            System.out.println("Ingrese la edad del usuario: ");
            edad = Validador.validarIngresoEnteroPositivo();
        }
        return edad;
    }
    public void ingresarCuenta(ArrayList<Usuario> usuarios){
        CuentaServicio cuentaSv = new CuentaServicio();
        String correo;
        System.out.println("Ingrese su correo electronico: ");
        correo = sc.next();
        for (Usuario user: usuarios) {
            if(user.getCorreo().equals(correo)){
                if(validarContrasenia(user)){
                    cuentaSv.menuCuenta(usuarios, user);
                }
                break;
            }
        }
    }

    public boolean validarContrasenia(Usuario user){
        boolean resultado = false;
        int contrasenia;
        int intentos = 5;
        do{
            System.out.println("Ingrese su contraseña: ");
            contrasenia = sc.nextInt();
            if(user.getCuenta().getContrasenia() == contrasenia){
                System.out.println("Bienvenido " + user.getNombre() + " " + user.getApellido());
                resultado = true;
            }else{
                System.out.println("Ingreso mal la contraseña, le quedan " + intentos + " intentos.");
            }
            intentos--;
        }while(intentos > 0 && resultado == false);

        if(!resultado){
            System.out.println("Se quedó sin intentos, volviendo al menú principal.");
        }

        return resultado;
    }

    /*
    public void mostrarUsuarios(ArrayList<Usuario> usuarios){
        System.out.println("--LISTA COMPLETAS DE USUARIOS");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|NOMBRE" + "\t\t\t\t" + "\t\t\tAPELLIDO" + "\t\t" + "EDAD" + "\t\t" + "DIRECCIÓN" + "\t\t\t\t\t\t" + "TELÉFONO" + "\t\t\t\t" + "CORREO" + "\t\t|");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Usuario user: usuarios) {
            System.out.println(user.toString());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

     */

}
