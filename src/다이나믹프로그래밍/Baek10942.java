package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팰린드롬?
public class Baek10942 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // n개의 수
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // m개의 질문

        for(int i=0;i<m;i++){
            StringTokenizer question = new StringTokenizer(br.readLine());
            System.out.println(palindrome(Integer.parseInt(question.nextToken()),Integer.parseInt(question.nextToken())));
        }

    }

    static int palindrome(int s, int e){

        s--;
        e--;

        while(s<e){
            if(arr[s++] != arr[e--]) return 0;
        }
        return 1;
    }
}
