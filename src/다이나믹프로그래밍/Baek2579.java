package 다이나믹프로그래밍;

import java.util.Scanner;

// 계단 오르기
public class Baek2579 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단 개수

        int[] num = new int[n]; // 계단 점수
        int[][] dp = new int[n][2];

        for(int i=0;i<n;i++) num[i] = sc.nextInt();

        dp[0][0] = num[0];
        dp[1][0] = num[1];
        dp[1][1] = dp[0][0] + num[1];


        for(int i=2;i<n;i++){
            dp[i][0] = Math.max(dp[i-2][0],dp[i-2][1]) + num[i]; // 1연속 ( 2단점프 한 경우 )
            dp[i][1] = dp[i-1][0] + num[i]; // 2연속 ( 1단 점프 한 경우 )
        }

//        for(int i=0;i<n;i++){
//            System.out.println(i+" >> 1연속: "+dp[i][0]);
//            System.out.println(i+" >> 2연속: "+dp[i][1]);
//        }

        System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));


    }
}
