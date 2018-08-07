package 다이나믹프로그래밍;

import java.util.Scanner;

// 1로 만들기
public class Baek1463 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1]; // 1부터 n까지 차례대로 채워질꺼임 (dp[i] = i를 만드는데 필요한 연산 수)

        dp[0] = dp[1] = 0; // 0,1은 0으로 세팅 (연산 0번)

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+1; // 1을 빼는 방법 먼저 넣고
            if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2]+1); // 1을 빼는 방법 vs 2배수로 만들 수 있는 방법
            if(i%3==0) dp[i] = Math.min(dp[i],dp[i/3]+1); // vs 3배수로 만들 수 있는 방법
        }

        System.out.println(dp[n]);
    }
}
