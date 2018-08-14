package 수학;

import java.util.Scanner;

// 진법
public class Baek2745 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.next(); // 주어진 수 n
        int b = sc.nextInt(); // b진법

        long res = 0;

        for(int i=0;i<n.length();i++){
            char c = n.charAt(i);

            if(c >= 'A' && c <= 'Z'){ // A - Z 진법
                int a = (int)(c-'A'+10);
                res += Math.pow(b,n.length()-i-1);
            }else{
                int a = (int)c - 48;
                res += Math.pow(b,n.length()-i-1);
            }
        }

//        System.out.println("res : "+res);
//
//        System.out.println(Math.pow(35,0)+Math.pow(35,1)+Math.pow(35,2)+Math.pow(35,3)+Math.pow(35,4));
        ss();


    }

    static void ss(){
        long r = 0;
        for(int i=0;i<5;i++){
            long a = 35*(long)Math.pow(36,i);
            System.out.println("a:"+a);
            r += a;

        }

        System.out.println("r:"+r);
    }
}
