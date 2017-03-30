package functions;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by taylor hudson on 3/2/2017.
 */
public class utility {


    /*  */
    public static ArrayList<BigInteger> primeList = FileHelper.readFile("primes.txt");

    public void generatePrimeList(BigInteger stopValue){
        ArrayList<BigInteger> prime = new ArrayList<>();
        prime.add(BigInteger.valueOf(2));
        for(BigInteger itterator = BigInteger.valueOf(3); itterator.compareTo(stopValue)<0; itterator = itterator.add(BigInteger.valueOf(2))){
            boolean isPrime = true;
            BigInteger sqr = sqrt(itterator);
            for(int i = 0; i  < prime.size() && isPrime && prime.get(i).compareTo(sqr) <= 0; i++){
                if(itterator.mod(prime.get(i)) == BigInteger.ZERO){
                    isPrime = false;
                }
            }
            if(isPrime) {
                prime.add(itterator);
                System.out.println(prime.size());
            }
        }
        try {
            FileHelper.writeFile(prime, "primes.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }
}
