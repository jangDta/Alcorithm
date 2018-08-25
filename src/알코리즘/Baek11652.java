package 알코리즘;

import java.util.Arrays;
import java.util.Scanner;

public class Baek11652 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] arr = new long[n];

        for(int i=0;i<n;i++) arr[i] = sc.nextLong();

        Arrays.sort(arr);

        long max = 0;
        long count = 0;
        long current = arr[0];
        long res = 0;


//        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
//        System.out.println();

        for(int i=0;i<n;i++){
            if(current == arr[i]){
                count++;
            }else{
                current = arr[i];
                count = 1;

            }



            if(max < count){
                max = count;
                res = current;
            }else if(max == count){
                max = count;
            }

            //System.out.println("current:"+current+" count:"+count+"  res:"+res+"  max:"+max);
        }

        System.out.println(res);


    }
}
