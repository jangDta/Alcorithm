package 알코리즘;

import java.util.Scanner;

// 더하기 사이클
public class Baek1110 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        int origin = n;

        do{
            int a = n/10;
            int b = n%10;

            int c = a+b;

            n = b*10+c%10;

            //System.out.println("n:"+n);
            count++;


        }while(origin!=n);


        System.out.print(count);


    }
}
