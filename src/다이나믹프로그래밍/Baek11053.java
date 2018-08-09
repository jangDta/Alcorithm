package 다이나믹프로그래밍;

import java.util.Scanner;

// 가장 긴 증가하는 부분수열
public class Baek11053 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] num = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++) num[i] = sc.nextInt();

        dp[0] = 0;
        dp[1] = 1;

        // 본인이 증가하는 수열의 마지막 수 가 될 떄를 생각

        for(int i=2;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(num[j] < num[i] && dp[i] < dp[j]+1) dp[i] = dp[j]+1; // 작은 놈 찾으면 그놈의 dp값+1(자기자신)
            }
        }

        int res = 0;
        for(int i=1;i<=n;i++){
            if(res < dp[i]) res = dp[i]; // 구해놓은 dp들 중의 최대
        }

        System.out.println(res);



    }
}
