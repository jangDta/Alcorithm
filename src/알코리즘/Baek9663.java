package 알코리즘;

import java.util.Scanner;

// N-Queen
public class Baek9663 {

    static int[] currentqueen;
    static int n;
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        currentqueen = new int[n];

        nqueen(0);
        System.out.println(count);



    }

    static void nqueen(int x){
        if(x == n){ // 마지막
            count++;
//            System.out.println("nqueen !!!");
//            for(int i=0;i<n;i++) System.out.print(currentqueen[i]+" ");
//            System.out.println();
        }else{
            for(int i=0;i<n;i++){
//                if(x==0) System.out.println("=============================");
//                System.out.println("x:"+x+" 자리에 "+i+"를 놓는다면");
                currentqueen[x] = i;
                if(isPossible(x)) {
//                    System.out.println("possible");
                    nqueen(x+1);
                }
            }
        }
    }

    static boolean isPossible(int x){
        for(int i=0;i<x;i++){
            if(currentqueen[i]==currentqueen[x] || Math.abs(x-i)== Math.abs(currentqueen[x]-currentqueen[i])){
                // 같거나 대각선
                return false;
            }
        }
        return true;
    }


}
