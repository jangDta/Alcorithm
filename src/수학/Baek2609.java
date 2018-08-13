package 수학;

import java.util.Scanner;

// 최대공약수와 최소공배수
public class Baek2609 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(gcd(x,y));
        System.out.println(lcm(x,y));

    }

    static int gcd(int x,int y){ // 최대공약수
        int mod = x%y;

        while(mod > 0){
            x = y;
            y = mod;
            mod = x%y;
        }

        return y;
    }

    static int lcm(int x,int y){
        // 최소공배수*최대공약수 = x*y

        return x*y/gcd(x,y);

    }
}
