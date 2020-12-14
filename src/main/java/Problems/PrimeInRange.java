package Problems;

import java.util.Arrays;

public class PrimeInRange {
    public static void main(String[] args) {
        int l = 10, r = 20;
        System.out.println(maxDigitInPrime(l,r));
    }

    private static int maxDigitInPrime(int l, int r) {
        boolean []prime = new boolean[r+1];
        Arrays.fill(prime,false);

        sieve(prime,r);

        int freq[] = new int[10];
        int val ;
        for ( int i =l; i<=r ; i++){
            if(!prime[i]){
                int p = i;
                while(p>0){
                    freq[p%10]++;
                    p/=10;
                }
            }
        }
        int max = freq[0], ans = 0;

        for (int j = 1; j < 10; j++) {
            if (max <= freq[j]) {
                max = freq[j];
                ans = j;
            }
        }

        return ans;
    }

    private static void sieve(boolean[] prime, int r) {
        for(int i = 2 ; i*i <= r ; i++){
            if(prime[i]==false){
                for(int j=i*2; j<=r ; j+=i){
                    prime[i]=true;
                }
            }
        }
    }
}
