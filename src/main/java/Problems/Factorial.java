package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(factorial(n));
    }
    private static BigInteger factorial(int n){
        BigInteger bigInteger = BigInteger.ONE;
        for(int i=2;i<=n;i++){
            bigInteger=bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }
}
