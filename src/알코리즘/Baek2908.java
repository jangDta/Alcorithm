package 알코리즘;

import java.util.Scanner;

// 상수
public class Baek2908 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        String aa = String.valueOf(a.charAt(2))+String.valueOf(a.charAt(1))+String.valueOf(a.charAt(0));
        String bb = String.valueOf(b.charAt(2))+String.valueOf(b.charAt(1))+String.valueOf(b.charAt(0));

        if(Integer.parseInt(aa) > Integer.parseInt(bb)) System.out.print(aa);
        else System.out.print(bb);



    }
}
