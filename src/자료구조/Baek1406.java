package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//에디터
public class Baek1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();

        Stack<Character> stack_left = new Stack<>();
        Stack<Character> stack_right = new Stack<>();

        //처음에 커서는 맨 뒤에
        for(int i=0;i<arr.length;i++) stack_left.push(arr[i]);

        int n = Integer.parseInt(br.readLine()); // 명령어 개수

        String[] orderList = new String[n];
        for(int i=0;i<n;i++) orderList[i] = br.readLine();

        for(int i=0;i<n;i++){
            String order = orderList[i];
            String[] split = order.split(" ");

            switch (split[0]){
                case "L":{
                    if(!stack_left.isEmpty()){
                        stack_right.push(stack_left.pop());
                    }
                    break;
                }
                case "D":{
                    if(!stack_right.isEmpty()){
                        stack_left.push(stack_right.pop());
                    }
                    break;
                }
                case "B":{
                    if(!stack_left.isEmpty()){
                        stack_left.pop();
                    }
                    break;
                }
                case "P":{
                    stack_left.push(split[1].charAt(0));
                    break;
                }
            }

//            System.out.println("left : "+stack_left);
//            System.out.println("right : "+stack_right);
        }

        while(!stack_left.isEmpty()){
            stack_right.push(stack_left.pop());
        }

        while(!stack_right.isEmpty()){
            System.out.print(stack_right.pop());
        }

        // String에 character 이어 붙여서 출력하려 했다가 time limit 났음
        // 왼쪽 stack에 있는 걸 오른쪽 stack으로 다 몰아넣고 pop하면서 출력하니 해결됨


    }
}
