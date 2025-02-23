package damBank;

import java.util.Scanner;

/**
 * @author Victor
 * @version 2.0
 */

public class CuentaBancaria {

    public static final double SALDO_MINIMO = -50, CANTIDAD_HACIENDA = 3000;
    private String iban, titular;
    private double saldo;
    double[] movimientos = new double[10];

    /**
     * Constructor de la cuenta bancaria
     * @since 1.0
     * @deprecated
     */
    public CuentaBancaria(String iban, String titular, int dinero){



    }
    /**
     * Constructor de la cuenta bancaria
     * @since 2.0
     */
    public CuentaBancaria(String iban, String titular){



    }

    /**
     * Esta función permite crear la cuenta bancaria del usuario tras introducir los datos necesarios
     * @since 1.0
     */
    public void crearCuenta() {

        Scanner teclado = new Scanner(System.in);
        String iban = "", titular = "";
        boolean esValido = true;

        System.out.print("Introduce tu IBAN: ");

        do {

            esValido = true;
            iban = teclado.nextLine();

            if (iban.length() != 24){

                esValido = false;

            }

            for (int i = 0; i < 2; i++) {

                if (!Character.isLetter(iban.charAt(i))){

                    esValido = false;

                }

            }
            for (int i = 2; i < iban.length(); i++) {

                if (!Character.isDigit(iban.charAt(i))){

                    esValido = false;;

                }

            }

            if (!esValido){

                System.out.print("El IBAN introducido no es válido, inténtalo de nuevo: ");

            }

        } while (!esValido);

        System.out.print("Introduce el nombre completo del titular: ");
        titular = teclado.nextLine();

        this.iban = iban;
        this.titular = titular;

    }

    /**
     * Esta función se encarga de guardar los movimientos de la cuenta del usuario
     * @param dinero Valor decimal que representa la cantidad de dinero retirada o ingresada
     * @since 1.0
     */
    public void guardarMovimientos(double dinero){

        int posicion = 0;
        boolean huecoEncontrado = false;

        do {

            if (movimientos[posicion] == 0){

                movimientos[posicion] = dinero;
                huecoEncontrado = true;

            }

            posicion++;

        } while ((posicion < movimientos.length) && !huecoEncontrado);

        if (!huecoEncontrado){

            for (int i = 1; i < movimientos.length; i++) {

                movimientos[i - 1] = movimientos[i];

            }

            movimientos[movimientos.length - 1] = dinero;

        }

    }

    /**
     * Esta función muestra por pantalla los movimientos (ingresos o retiradas) que ha realizado el usuario
     * @since 1.0
     */
    public void mostrarMovimientos(){

        for (int i = 0; i < movimientos.length; i++) {

            if (movimientos[i] != 0){

                System.out.println(movimientos[i]);

            }

        }

    }

    /**
     * Método get para obtener el IBAN
     * @since 1.0
     * @return devuelve el IBAN
     */
    public String getIban() {
        return iban;
    }

    /**
     * Método set para establecer el IBAN
     * @param iban Valor String que representa el IBAN de la cuenta
     * @since 1.0
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Método get para obtener el nombre del titular de la cuenta
     * @since 1.0
     * @return devuelve el titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Método set para establecer el nombre del titular de la cuenta
     * @param titular Valor String que representa el titular de la cuenta
     * @since 1.0
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Método get para obtener el saldo de la cuenta
     * @since 1.0
     * @return devuelve el saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método set para establecer el saldo de la cuenta
     * @param saldo Valor decimal que representa el saldo disponible de la cuenta
     * @since 1.0
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
