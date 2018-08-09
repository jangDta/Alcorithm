package 다이나믹프로그래밍;

import java.util.Scanner;

// 이친수
public class Baek2193 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n자리 수

        long[] dp = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++) dp[i] = dp[i-1] + dp[i-2];

        System.out.println(dp[n]);

    }
}
