package 자료구조;

import java.util.Scanner;
import java.util.Stack;

//쇠막대기
public class Baek10799 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String question = sc.nextLine();
        char[] arr = question.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int i=0;i<arr.length;i++){
            char element = arr[i];

            if (element == '('){
                stack.push(i);
            }else{ // element == ')'
                if (stack.peek() == i-1){ // 인접해있음 () -> 레이저
                    stack.pop();
                    count += stack.size();
                }else{ // 인접하지 않음 -> 레이저에게 잘린 끝자락 1개 추가해줌
                    stack.pop();
                    count += 1;
                }
            }

            //System.out.println(stack);
        }

        System.out.println(count);

    }
}
