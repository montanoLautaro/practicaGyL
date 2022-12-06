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

package main;

import servicios.PrincipalServicio;


public class main {
    public static void main(String[] args) {

        PrincipalServicio sv = new PrincipalServicio();
        sv.menu();

    }

