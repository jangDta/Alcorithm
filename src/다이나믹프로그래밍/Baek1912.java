package 다이나믹프로그래밍;

import java.util.Scanner;

// 연속합
public class Baek1912 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] num = new int[n];
        int[] dp = new int[n];

        for(int i=0;i<n;i++) num[i] = sc.nextInt();

        dp[0] = num[0];

        int max = dp[0];

        for(int i=1;i<n;i++){
            dp[i] = num[i];

            if(dp[i] < dp[i-1] + num[i]) dp[i] = dp[i-1] + num[i]; // 다시 연속합을 시작 할지 이어갈지 정해야함

            if(max < dp[i]) max = dp[i];

        }

        System.out.println(max);


    }
}
