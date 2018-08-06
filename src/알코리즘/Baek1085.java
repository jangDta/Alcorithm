package 알코리즘;

import java.util.Scanner;

// 직사각형에서 탈출
public class Baek1085 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int min = x;

        if(min > w-x) min = w-x;
        if(min > y) min = y;
        if(min > h-y) min = h-y;

        System.out.println(min);
    }
}
