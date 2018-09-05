package 알코리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 단지 번호 붙이기
public class Baek2667 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 2;
    static int sum = 0;

    static int n;
    static int[][] map;
    static ArrayList<Integer> houseArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        map = new int[n][n];
        houseArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = (int) s.charAt(j) - 48;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 1){
                    //System.out.println("i:"+i+", j:"+j);
                    dfs(i,j);
                    houseArr.add(sum);
                    sum = 0;
                    count++;
                }

            }
        }

        System.out.println(count-2);
        Collections.sort(houseArr);

        for(int i=0;i<houseArr.size();i++) System.out.println(houseArr.get(i));


//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

    }

    static void dfs(int x,int y){
        map[x][y] = count;
        sum++;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<n){
                if(map[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }
    }

}
