package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StockUpDown {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        while (t-->0){
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            int arr[] = new int[n];
            int i =0;
            String inputLine[] = bufferedReader.readLine().trim().split(" ");
            for(String input:inputLine){
                arr[i] = Integer.parseInt(input.trim());
                i++;
            }
            System.out.println(stockBuySell(arr,n));
        }
    }

    private static StringBuffer stockBuySell(int[] price, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        if(n==1)
            return stringBuffer;

        ArrayList<Interval> sol = new ArrayList<Interval>();
        int i=0, c=0;
        while (i<n-1){
            while((i<n-1) && price[i+1]<=price[i])
                i++;
            if(i==n-1)
                break;
            Interval e = new Interval();
            e.buy = i++;
            while((i<n-1) && price[i+1]>=price[i])
                i++;
            e.sell=i;
            sol.add(e);
            c++;
        }
        if(c==0){
            stringBuffer.append("No profit");
        }else{
            for(Interval interval : sol){
                stringBuffer.append(interval);
            }
        }
        return stringBuffer;
    }

}

class Interval{
    int buy;
    int sell;

    @Override
    public String toString() {
        return "{" +
                "" + buy +
                ", " + sell +
                '}';
    }
}