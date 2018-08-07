package 자료구조;

import java.util.Arrays;
import java.util.Scanner;

// 접미사 배열
public class Baek11656 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] arr = new String[s.length()];

        for(int i=0;i<arr.length;i++) arr[i] = s.substring(i);

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
