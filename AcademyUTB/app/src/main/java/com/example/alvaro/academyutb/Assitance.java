package com.example.alvaro.academyutb;

/**
 * Created by Alvaro on 21/08/2017.
 */

public class Assitance {

    private static int contadorPersonas;

    private static Assitance assitance = new Assitance();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Assitance() { }

    /* Static 'instance' method */
    public static Assitance getInstance() {
        contadorPersonas++;
        return assitance;
    }

    // contador
    protected static int getContadorPersonas( ) {
        return contadorPersonas;
    }
}
