package 알코리즘;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점프

public class Baek1890 {
    static int n;
    static int[][] map;
    static long[][] dp;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(dp[i][j] == 0 || (i == n-1) && (j == n-1)) continue;

                int data = map[i][j];

                int nx = data + i;
                int ny = data + j;

                if(nx < n) dp[nx][j] += dp[i][j];
                if(ny < n) dp[i][ny] += dp[i][j];
            }
        }



        System.out.println(dp[n-1][n-1]);


    }


    static void printmap(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
