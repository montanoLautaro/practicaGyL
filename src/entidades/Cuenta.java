/*
 * hasta 10 usuarios
 * controlar q nada llegue vacio
 * nombre apellido direc tel correo
 * usuario
 * contraseña
 * usuario > 18 para abrir cuenta
 * menu para transaccion de usuario 1 a usuario 2
 * tarjeta con unico numero
 */


package entidades;

public class Cuenta {
    private String contrasenia;
    private double saldo;

    private String tarjeta;



    public Cuenta() {
        saldo = 0;
    }

    public Cuenta(String contrasenia, String tarjeta) {
        this.tarjeta = tarjeta;
        this.contrasenia = contrasenia;
        saldo = 0;
    }

    public Cuenta(String contrasenia, double saldo, String tarjeta) {
        this.contrasenia = contrasenia;
        this.saldo = saldo;
        this.tarjeta = tarjeta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
