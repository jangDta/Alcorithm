package 다이나믹프로그래밍;

import java.util.Scanner;

// 제곱수의 합
public class Baek1699 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = i;

            int a = (int)Math.sqrt(i); // 여기까지가 최대로 제곱해서 가까워 질 수 있는

            for(int j=1;j<=a;j++){
                int b = i - j*j;

                if(dp[i] > 1+dp[b]) dp[i] = 1+dp[b];
            }

        }

        System.out.println(dp[n]);

        //for(int i=1;i<=n;i++) System.out.println(i+" >> "+dp[i]);

    }
}
