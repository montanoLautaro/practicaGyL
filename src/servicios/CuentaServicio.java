package servicios;

import entidades.Cuenta;
import entidades.Usuario;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CuentaServicio {

    public void menuCuenta(ArrayList<Usuario> usuarios, Usuario user){
        int opcion;
        do{
            System.out.println("\t\t MENÚ DE USUARIOS");
            System.out.println("1. Ingresar saldo.");
            System.out.println("2. Consultar Saldo.");
            System.out.println("3. Enviar dinero.");
            System.out.println("4. Salir");
            System.out.println("Elíja una opción: ");
            opcion = Validador.validarIngresoEnteroPositivo();
            switch (opcion){
                case 1:
                    ingresarDinero(user);
                    break;
                case 2:
                    mostrarDatosCuenta(user);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("VOLVIENDO AL MENÚ PRINCIPAL...");
                    break;
                default:
                    System.out.println("La opción ingresada no es válida, intentelo nuevamente");
            }
        }while(opcion != 4);
    }
    public Cuenta crearCuenta(ArrayList<Usuario> usuarios){
        Cuenta nuevaCuenta = new Cuenta();
        System.out.println("\t\t MENÚ DE CREACIÓN DE CUENTA");
        nuevaCuenta.setContrasenia(crearContrasenia());
        nuevaCuenta.setNumeroTarjeta(otorgarNumTarjeta(usuarios));
        return nuevaCuenta;
    }

    public int crearContrasenia(){
        int contrasenia;
        boolean resultado = true;

        do{
            System.out.println("Ingrese una nueva contraseña númerica para su cuenta, de 4 digitos: ");
            contrasenia = Validador.validarIngresoEnteroPositivo();
            if(Integer.toString(contrasenia).length() == 4){
                resultado = false;
            }else{
                System.out.println("La contraseña debe tener 4 digitos númericos, intentelo nuevamente.");
            }
        }while(resultado);


        return contrasenia;
    }

    public String crearNumeroTarjeta(){
        int numeros;
        Random numRandom = new Random();
        String resultado = "";
        String aux;

        for(int i=0; i<16; i++){
            numeros = numRandom.nextInt(9);
            aux = String.valueOf(numeros);
            resultado = resultado + aux;
        }
        return resultado;
    }

    public String otorgarNumTarjeta(ArrayList<Usuario> usuarios){
        String numeroNuevo;
        boolean validador;
        do{
            numeroNuevo = crearNumeroTarjeta();
            validador = false;
            for (Usuario user: usuarios) {
                if (user.getCuenta().getNumeroTarjeta().equals(numeroNuevo)){
                    validador = true;
                    break;
                }
            }
        }while(validador);
        return numeroNuevo;
    }

    public void ingresarDinero(Usuario user){
        double dinero;
        System.out.println("-- INGRESO DE DINERO");
        System.out.println("Ingrese la cantidad de dinero que va a ingersar a su cuenta: ");
        dinero = Validador.validarIngresoDoublePositivo();
        dinero = dinero + user.getCuenta().getSaldo();
        user.getCuenta().setSaldo(dinero);
        System.out.println("El ingreso se realizo con éxito.");
    }

    public void mostrarDatosCuenta(Usuario user){
        System.out.println("Tarjeta Nro " + user.getCuenta().getNumeroTarjeta());
        System.out.println("Dinero disponible: $" + user.getCuenta().getSaldo());
        System.out.println("");
    }

    public void enviarDinero(ArrayList<Usuario> usuarios, Usuario user){
        System.out.println("-- ENVIAR DINERO");
        String usuarioDestino = validarNombreUsuario();
        realizarTransferencia(encontrarUsuario(usuarios, usuarioDestino));

    }

    public Usuario encontrarUsuario(ArrayList<Usuario> usuarios, String nombre){
        for (Usuario aux: usuarios) {
            if(aux.getNombre().equalsIgnoreCase(nombre)){
                return  aux;
            }
        }
        return null;
    }

    public String validarNombreUsuario(){
        String nombre;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        boolean validador;
        System.out.println("Ingrese el nombre del usuario al cual le quiere enviar dinero: ");
        do{
            nombre = sc.next();
            validador = Validador.validarIngresoSoloLetras(nombre);
        }while(validador);
        return nombre;
    }

    public void realizarTransferencia(Usuario userBase, Usuario userDestino ){

    }



}
