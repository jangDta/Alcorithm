package 알코리즘;

import java.util.*;

public class Baek5567 {

    static int n,m;
    static int[][] matrix;
    static boolean[] visited;
    static ArrayList<Integer> friends;
    static ArrayList<Integer> friends2;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][n];
        visited = new boolean[n];

        friends = new ArrayList<>();
        friends2 = new ArrayList<>();

        for(int i=0;i<m;i++){
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;

            matrix[from][to] = 1;
            matrix[to][from] = 1;

        }

        friend(0);
        friend2();

        System.out.println(friends.size()+friends2.size());



    }

    static void friend(int from){
        visited[from] = true;
        for(int i=0;i<n;i++){
            if(matrix[from][i] == 1 && visited[i] == false){
                friends.add(i);
                visited[i] = true;
            }
        }
    }

    static void friend2(){
        for(int i=0;i<friends.size();i++){
            for(int j=0;j<n;j++){
                if(matrix[friends.get(i)][j] == 1 && visited[j] == false){
                    friends2.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}
