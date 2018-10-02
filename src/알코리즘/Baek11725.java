package 알코리즘;

import java.util.Scanner;

// 트리의 부모 찾기
public class Baek11725 {

    static int n;
    static int[][] map;
    static int[] myparent;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // node
        map = new int[n+1][n+1];
        myparent = new int[n+1];

        for(int i=0;i<n-1;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            map[from][to] = 1;
            map[to][from] = 1;

        }

        printmap();
        System.out.println("------");
        printArr();

        checkParent(1);
        System.out.println("==============================");
        printmap();
        System.out.println("------");
        printArr();



    }

    static void printmap(){
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void printArr(){
        for(int i=1;i<n+1;i++) System.out.print(myparent[i]+" ");
        System.out.println();
    }


    static void checkParent(int c){
        if(c != 1){

        }else{
            for(int i=1;i<n+1;i++){
                if(map[c][i] == 1){
                    myparent[i] = 1;
                    map[i][c] = 0;
                }
            }
        }

    }





}
