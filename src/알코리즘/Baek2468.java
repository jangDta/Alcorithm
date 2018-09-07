package 알코리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 안전영역
public class Baek2468 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count = 2;

    static int n;
    static int[][] map;
    static int min = 101;
    static int max = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];

        ArrayList<Integer> arr = new ArrayList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int p = sc.nextInt();
                map[i][j] = p;

                if(min > p) min = p;
                if(max < p) max = p;
            }
        }

        for(int k=min;k<max;k++){
            int[][] floodmap = new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (map[i][j] <= k) floodmap[i][j] = 0; // 침수 되면 0
                    else floodmap[i][j] = 1;
                }
            }

//            System.out.println(k+" 이하는 0이다. ");
//            printmap(floodmap);
//            System.out.println();

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(floodmap[i][j] == 1){
                        dfs(i,j,floodmap);
                        count++;
                    }
                }
            }

            arr.add(count-2);

            count = 2;

//            System.out.println("dfs 돌린 후");
//            printmap(floodmap);
//            System.out.println();


        }

//        System.out.println("----------------------");
//        for(int i=0;i<arr.size();i++){
//            System.out.println(arr.get(i));
//        }
        Collections.sort(arr);

        if(arr.size() == 0) System.out.println(1);
        else System.out.println(arr.get(arr.size()-1));








    }

    static void dfs(int x,int y,int[][] floodmap){

        floodmap[x][y] = count;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(floodmap[nx][ny] == 1){
                        dfs(nx,ny,floodmap);
                    }
                }
            }


    }

    static void printmap(int[][] map){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
