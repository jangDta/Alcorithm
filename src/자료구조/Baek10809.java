package 자료구조;

import java.util.Arrays;
import java.util.Scanner;

// 알파벳 찾기
public class Baek10809 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int[] arr = new int[26];

        Arrays.fill(arr,-1);

        for(int i=0;i<chars.length;i++){
            int ascii = (int)chars[i] - 97;
            if(arr[ascii] == -1){
                arr[ascii] = i;
            }
        }

        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");



    }
}
