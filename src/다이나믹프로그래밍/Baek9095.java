package 다이나믹프로그래밍;

import java.util.Scanner;

// 1,2,3 더하기
public class Baek9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] problems = new int[n];

        for(int i=0;i<n;i++) problems[i] = sc.nextInt();

        for(int i=0;i<n;i++) cal(problems[i]);


    }

    static void cal(int x){
        if (x==1) System.out.println(1);
        else if (x==2) System.out.println(2);
        else if (x==3) System.out.println(4);
        else if (x>=4){
            int[] dp = new int[x+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i=4;i<=x;i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(dp[x]);
        }


     }
}
