package test;

import functions.utility;

import java.math.BigInteger;

/**
 * Created by taylor hudson on 3/2/2017.
 */
public class driver {
    public static void main(String args[]){
        (new utility()).generatePrimeList(BigInteger.valueOf(99999999999L));
    }
}
