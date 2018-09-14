package 알코리즘;

import java.util.*;

public class Baek1260 {

    static int[][] matrix;
    static int n,m,v;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // node
        m = sc.nextInt(); // edge
        v = sc.nextInt(); // start node

        matrix = new int[n][n];
        visited = new boolean[n];

        for(int i=0;i<m;i++){
            int from = sc.nextInt() -1;
            int to = sc.nextInt() -1;

            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }

        dfs(v-1);

        for(int i=0;i<visited.length;i++) visited[i] = false;

        System.out.println();
        bfs(v-1);




    }

    static void dfs(int start){
        visited[start] = true;

        System.out.print((start+1)+" ");

        for(int i=0;i<n;i++){
            if(matrix[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }

    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int p = queue.poll();
            visited[p] = true;
            //System.out.println(queue.toString());
            System.out.print((p+1)+" ");

            for(int i=0;i<n;i++){
                if(matrix[p][i] == 1 && visited[i] == false){
                    queue.add(i);

                    visited[i] = true;

                }
            }
        }
    }


}
