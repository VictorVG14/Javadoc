package damBank;

import java.util.Scanner;

/**
 * @author Victor
 * @version 1.0
 */

public class DamBank {

    int eleccion = 0;
    String titular = "";

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria("", "");
        cuenta.crearCuenta();
        int eleccion = 0;

        do {

            eleccion = mostrarMenu();
            accion(eleccion, cuenta);

        } while (eleccion != 8);

    }

    /**
     * Esta función muestra por pantalla el menú con las opciones disponibles que puede realizar el usuario (Visibilidad "public" para que se muestre en el javadoc)
     * @see #accion(int, CuentaBancaria)
     * @since 1.0
     * @return devuelve el número entero que representa la opción elegida por el usuario
     */

    public static int mostrarMenu(){

        Scanner teclado = new Scanner(System.in);
        int eleccion = 0;
        System.out.println("1. Datos de la cuenta\n2. IBAN\n3. Titular\n4. Saldo\n5. Ingreso\n6. Retirada\n7. Movimientos\n8. Salir");

        do {

            System.out.print("¿Qué operación quieres realizar? ");
            eleccion = teclado.nextInt();

            if ((eleccion < 1) || (eleccion > 8)){

                System.out.println("El número introducido no es válido. Sólo se permiten números del 1 al 8.");

            }

        } while ((eleccion < 1) || (eleccion > 8));

        return eleccion;

    }

    /**
     * Esta función se encarga de realizar la acción elegida por el usuario en el menú (Visibilidad "public" para que se muestre en el javadoc)
     * @see #mostrarMenu()
     * @param eleccion Valor entero que representa la elección del usuario
     * @param cuentaBancaria Objeto de la clase CuentaBancaria que representa la cuenta bancaria del usuario
     * @since 1.0
     */
    public static void accion(int eleccion, CuentaBancaria cuentaBancaria){

        Scanner teclado = new Scanner(System.in);

        switch (eleccion){

            case 1:

                System.out.println("Titular: " + cuentaBancaria.getTitular() + "\nIBAN: " + cuentaBancaria.getIban() + "\n");
                break;

            case 2:

                System.out.println("IBAN: " + cuentaBancaria.getIban());
                break;

            case 3:

                System.out.println("Titular: " + cuentaBancaria.getTitular());
                break;

            case 4:

                System.out.println("Saldo disponible: " + cuentaBancaria.getSaldo());
                break;

            case 5:

                int dineroIngresado = 0;

                do {

                    System.out.print("¿Cuánto dinero quieres ingresar? ");
                    dineroIngresado = teclado.nextInt();
                    if (dineroIngresado <= 0){

                        System.out.println("Introduce una cantidad mayor que 0.");

                    }

                } while (dineroIngresado <= 0);

                if (dineroIngresado > CuentaBancaria.CANTIDAD_HACIENDA){

                    System.out.println("AVISO: Notificar a hacienda.");

                }
                cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() + dineroIngresado);
                cuentaBancaria.guardarMovimientos(dineroIngresado);
                break;

            case 6:

                int dineroRetirado = 0;

                do {

                    System.out.print("¿Cuánto dinero quieres retirar? ");
                    dineroRetirado = teclado.nextInt();
                    if (dineroRetirado < 0){

                        System.out.println("Introduce una cantidad mayor que 0.");

                    }
                    if (cuentaBancaria.getSaldo() - dineroRetirado < CuentaBancaria.SALDO_MINIMO){

                        System.out.println("AVISO: Saldo negativo.");

                    }

                } while ((dineroRetirado < 0) || (cuentaBancaria.getSaldo() - dineroRetirado < -50));
                cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() - dineroRetirado);
                cuentaBancaria.guardarMovimientos(-dineroRetirado);
                break;

            case 7:

                cuentaBancaria.mostrarMovimientos();
                break;

            case 8:

                System.out.println("Adiós");
                break;

        }

    }



}
