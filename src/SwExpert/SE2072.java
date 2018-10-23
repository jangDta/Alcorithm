package SwExpert;

import java.util.Scanner;

// 지루하지 않은 수열
public class SE5954 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T=sc.nextInt();



        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            check(arr);



        }
    }

    static void check(int[] arr){

    }
}
