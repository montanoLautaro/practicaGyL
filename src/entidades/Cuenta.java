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
    private Usuario titular;
    private String contrasenia;
    private double saldo;

    public Cuenta() {
        saldo = 0;
    }

    public Cuenta(Usuario titular, String contrasenia) {
        this.titular = titular;
        this.contrasenia = contrasenia;
        saldo = 0;
    }

    public Cuenta(Usuario titular, String contrasenia, double saldo) {
        this.titular = titular;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
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
