package 자료구조;

import java.util.Scanner;

// 알파벳 개수
public class Baek10808 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] chars = s.toCharArray();
        int[] arr = new int[26];

        for(int i=0;i<chars.length;i++){
            int ascii = (int)chars[i] - 97;
            arr[ascii]++;
        }

        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");

    }
}
