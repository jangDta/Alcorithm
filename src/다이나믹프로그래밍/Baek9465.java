package 다이나믹프로그래밍;

import java.util.Scanner;

// **********
// 스티커
public class Baek9465 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int T = sc.nextInt();

        for(int i=0;i<T;i++) System.out.println(cal(sc.nextInt()));;
    }

    static long cal(int n){

        long[][] map = new long[2][n+1];
        long[][] dp = new long[2][n+1];

        for(int i=0;i<2;i++){
            for(int j=1;j<=n;j++){
                map[i][j] = sc.nextLong();
            }
        }

        dp[0][1] = map[0][1];
        dp[1][1] = map[1][1];

        for(int i=2; i<=n; i++){
            dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2] ) + map[0][i]; // 내 바로 대각선, 내 바로 전의 대각선
            dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2] ) + map[1][i];
        }

        long res = Math.max(dp[0][n],dp[1][n]);

        return res;
    }
}
