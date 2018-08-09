package 다이나믹프로그래밍;

import java.util.Scanner;

// 붕어빵 판매하기
public class Baek11052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] price = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++) price[i] = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]+price[j]); // 마지막에 산 사람이 price[j] 이면 나머지는 dp[i-j]
            }
        }

        System.out.println(dp[n]);

    }
}
