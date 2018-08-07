package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class Baek9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] orderlist = new String[n];
        for(int i=0;i<n;i++) orderlist[i] = sc.nextLine();

        for(int i=0;i<n;i++){
            char[] arr = orderlist[i].toCharArray();
            checkVPS(arr);

        }

    }

    static void checkVPS(char[] arr){
        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        for(int i=0;i<arr.length;i++) {
            char element = arr[i];

            if (element == '(') { // 여는 괄호
                stack.push(element);
            } else { // element == ')'
                if (stack.isEmpty()) {
                    flag = true;
                    break;
                } else {
                    stack.pop();
                }
            }

            //System.out.println(stack);
        }

        if (flag) System.out.println("NO");
        else{
            if (stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }





    }
}
