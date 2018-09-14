package 알코리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek1068 {

    static int n;
    static int[] nodes;
    static int[][] matrix;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // node
        nodes = new int[n];
        matrix = new int[n][n];


        for(int i=0;i<n;i++) nodes[i] = i;

        for(int i=0;i<n;i++){
            int current = sc.nextInt();

            if(current!=-1) matrix[current][i] = 1;
        }

        int delete = sc.nextInt();

        //print();


        delete(delete);



        int count = 0;

        for(int i=0;i<n;i++){
            if(matrix[i][delete] == 1) matrix[i][delete] = 0;
        }

        //print();


        for(int i=0;i<n;i++){
            boolean isLeaf = true;
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1 || matrix[i][j] == -1){
                    isLeaf = false;
                    break;
                }
            }

            if(isLeaf) count++;
        }

        System.out.println(count);

    }

    static void print(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void delete(int d){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(d);


        while(!queue.isEmpty()){

            //System.out.println(queue.toString());
            int p = queue.poll();
            matrix[p][p] = -1;
            //System.out.println(p);

            for(int i=0;i<n;i++){
                if(matrix[p][i] == 1){
                    queue.add(i);
                    matrix[p][i] = -1;
                }
            }
        }
    }




}
