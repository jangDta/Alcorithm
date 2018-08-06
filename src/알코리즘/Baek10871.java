package 알코리즘;

import java.util.Scanner;

// X보다 작은 수
public class Baek10871 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 배열 길이
        int x = sc.nextInt(); // 주어진 정수
        String res = "";

        int[] arr = new int[n];


        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        for(int i=0;i<n;i++){
            if(arr[i] < x){
                res += String.valueOf(arr[i])+" ";
            }
        }

        System.out.println(res);

    }
}
