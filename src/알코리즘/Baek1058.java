package 알코리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek1058 {
    static int n;
    static int[][] matrix;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        max = 0;

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                if(str.charAt(j) == 'Y') matrix[i][j] = 1;
            }
        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i=0;i<n;i++){
//            System.out.println("friend"+i+": "+friend(i));
            if(max < friend(i)) max = friend(i);
        }

        System.out.println(max);

    }

    static int friend(int start){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;

        for(int i=0;i<n;i++){
            if(matrix[start][i] == 1 && visited[i] == false){
                list.add(i);
                visited[i] = true;
            }
        }
        int[] tmp = new int[list.size()];

        for(int i=0;i<list.size();i++) tmp[i] = list.get(i);

        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<n;j++){
                if(matrix[tmp[i]][j] == 1 && visited[j] == false){
                    list.add(j);
                    visited[j] = true;
                }
            }
        }

        return list.size();

    }
}
