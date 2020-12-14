package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class MinPlatform {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []arr = new int[n];
        int []dep = new int[n];
        while(scanner.hasNext()){
            arr[i] = scanner.nextInt();
            dep[i] = scanner.nextInt();
            i++;
        }*/
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(findPlatform(arr,dep,arr.length));
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformNeeded =1;
        int result = 1;
        int i = 1;
        int j = 0;

        while (i<n && j<n){
            if(arr[i] < dep[j])
            {
                platformNeeded++;
                i++;
            }
            else if(arr[i]>dep[j]){
                platformNeeded--;
                j++;
            }
            if(platformNeeded>result)
                result = platformNeeded;
        }
        return result;
    }
}
