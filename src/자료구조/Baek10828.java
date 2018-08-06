package 자료구조;

import java.util.Scanner;
import java.util.Stack;

// 스택
public class Baek10828 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 명령의 수
        sc.nextLine();

        String[] orderList = new String[n];

        Stack<Integer> myStack = new Stack<>();

        for(int i=0;i<n;i++) orderList[i] = sc.nextLine();

        for(int i=0;i<n;i++){
            String order = orderList[i];

            switch (order){
                case "size":{
                    System.out.println(myStack.size());
                    break;
                }
                case "empty":{
                    if(myStack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "top":{
                    if (myStack.isEmpty()) System.out.println(-1);
                    else System.out.println(myStack.peek());
                    break;
                }
                case "pop":{
                    if (myStack.isEmpty()) System.out.println(-1);
                    else System.out.println(myStack.pop());
                    break;
                }
                default:{
                    String[] split = order.split(" ");
                    int element = Integer.parseInt(split[1]);
                    myStack.push(element);
                    break;
                }

            }
        }




    }
}
