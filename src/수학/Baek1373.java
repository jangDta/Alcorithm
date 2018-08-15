package 수학;

import java.util.Scanner;

// 2진수 -> 8진수
public class Baek1373 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 뒤에서부터 3자리씩 끊어서(8진수 하나) 이어붙이기
        if(s.length()%3 == 1) s = "0"+s;
        else if(s.length()%3 == 2) s = "0"+s;

        System.out.println(s);

    }

    static int convert(String str){
        char[] arr = str.toCharArray();
        int res = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[arr.length-1-i] == '1') res += (int)Math.pow(2,i);
        }
        return res;
    }
}
