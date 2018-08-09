package 다이나믹프로그래밍;

import java.util.Scanner;

// 오르막 수
public class Baek11057 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n 자리수

        int[][] dp = new int[n+1][10];

        for(int i=0;i<=9;i++) dp[1][i] = 1; // 1자리 수 1,2,3,4,5,6,7,8,9 각각 1가지 경우

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                dp[i][j] = 0;
                for(int k=j;k<=9;k++) dp[i][j] += dp[i-1][k];
                dp[i][j] %= 10007;
            }
        }

        long res = 0;
        for(int i=0;i<=9;i++) res += dp[n][i];

        System.out.println(res%10007);
    }
}
