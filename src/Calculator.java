import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();

        String postfix = infixTopostfix(infix);
        System.out.println("postfix : "+postfix);

        System.out.println(calculate(postfix));


    }

    static String infixTopostfix(String infix){
        String postfix = "";

        StringTokenizer tokenizer = new StringTokenizer(infix," ");

        Stack<String> stack = new Stack<>();

        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();

            System.out.println("token : "+token);

            if(isOperator(token)){
                if(stack.isEmpty()) stack.push(token);
                else{
                    String peek = stack.peek();

                    if(priorityOf(peek) < priorityOf(token)){ // push
                        stack.push(token);
                    }else{
                        postfix += stack.pop()+" ";
                        stack.push(token);
                    }
                }
            }else { // number or ( , )

                if(token.equals("(")) stack.push(token); // (
                else{
                    if(token.equals(")")){ // )

                        while (!(stack.peek()).equals("(")){
                            postfix += stack.pop()+" ";
                        }
                        stack.pop();

                    }else{ // number
                        postfix += token+" ";
                    }
                }

            }

            System.out.println(stack.toString());
            System.out.println(postfix);
            System.out.println("-------------------------");
        }

        while(!stack.isEmpty()) postfix += stack.pop()+" ";


        return postfix;
    }

    static boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) return true;
        else return false;
    }


    static int priorityOf(String s){
        if(s.equals("(") || s.equals(")")) return 1;
        else if(s.equals("+") || s.equals("-")) return 2;
        else if(s.equals("*") || s.equals("/")) return 3;
        else return -1;
    }

    static double calculate(String postfix){

        Stack<Double> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(postfix," ");

        while(st.hasMoreTokens()){
            String c = st.nextToken();

            if(isOperator(c)){
                double a = stack.pop();
                double b = stack.pop();

                switch (c){
                    case "+":{
                        stack.push(b+a);
                        break;
                    }
                    case "-":{
                        stack.push(b-a);
                        break;
                    }
                    case "*":{
                        stack.push(b*a);
                        break;
                    }
                    case "/":{
                        stack.push(b/a);
                        break;
                    }
                    default:{
                        break;
                    }
                }


            }else{
                stack.push(Double.parseDouble(c));
            }

        }

        return stack.pop();
    }

}
