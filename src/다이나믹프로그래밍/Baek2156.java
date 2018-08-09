package 다이나믹프로그래밍;

import java.util.Scanner;

// 포도주 시식
public class Baek2156 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n개 포도주 잔

        int[] grape = new int[n+1];
        for(int i=1;i<=n;i++) grape[i] = sc.nextInt();

        int[][] dp = new int[n+1][3];

        dp[1][0] = 0;
        dp[1][1] = grape[1];
        dp[1][2] = 0;

        for(int i=2;i<=n;i++){
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2])); // 연속 0잔쨰 ( 전 잔들의 최대 값 )
            dp[i][1] = dp[i-1][0] + grape[i]; // 1잔째 ( 전 잔 = 연속 0잔 째 )
            dp[i][2] = dp[i-1][1] + grape[i]; // 2잔째 ( 전 잔 = 연속 1잔 째 )
        }

        System.out.println(Math.max(dp[n][0],Math.max(dp[n][1],dp[n][2])));


    }
}
