import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class L1 {
    static ArrayList<Integer> arr;
    static int money;
    public static void main(String[] args){
        String input = new Scanner(System.in).nextLine().trim();
        arr = new ArrayList<>();
        money = 20000;

        final StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // @todo Write your code here.
            arr.add(distance);
        }

        for(int i=0;i<arr.size();i++){
            int current = arr.get(i);


            if(money < 0) break;

            if(current > 40){

                int a = (current-40);

                if(a%8 == 0){
                    money -= (720+(a/8)*80);
                }else{
                    money -= (720+((a/8)+1)*80);
                }


            }else{
                money -= 720;
            }

        }


        System.out.println(money);

    }
}
