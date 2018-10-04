package 코테;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class K2 {
    public static void main(String[] args){
        int n = 4;
        int[] stages = {1,1,1,1,1};

        solution(n,stages);

    }

    static int[] solution(int N, int[] stages) {

        int[] arr = new int[N+2];
        int[] dp = new int[N+2];

        for(int i=0;i<stages.length;i++){
            arr[stages[i]]++;
        }

        for(int i=1;i<arr.length;i++){
            dp[i] = dp[i-1]+arr[i];
        }

//        System.out.println("arr -------");
//
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//
//        System.out.println();
//        System.out.println("dp -------");
//
//        for(int i=0;i<dp.length;i++){
//            System.out.print(dp[i]+" ");
//        }

        double[] failure = new double[N+1];
        HashMap<Integer,Double> hashMap = new HashMap<>();

        for(int i=1;i<failure.length;i++){

            if(arr[i] == 0) failure[i] = 0;
            else{
                failure[i] = (double)arr[i]/(double)(dp[dp.length-1]-dp[i-1]);
            }

        }


        System.out.println("failure");
        for(int i=1;i<failure.length;i++){
            System.out.print(failure[i]+" /");
        }

        System.out.println();

        double[] failure2 = new double[failure.length];

        System.arraycopy(failure,0,failure2,0,failure.length);

        Arrays.sort(failure2);

        ArrayList<Integer> a = new ArrayList<>();

        System.out.println("failure2");
        for(int i=1;i<failure2.length;i++){
            System.out.print(failure2[i]+" /");
        }

        System.out.println();

        for(int i=failure2.length-1;i>=1;i--){
            double current = failure2[i];
            System.out.println("current:"+current);

            for(int j=1;j<failure.length;j++){
                if(current == failure[j]){
                    System.out.println("j:"+j);
                    a.add(j);
                    failure[j] = 2;
                    break;
                }
            }
        }



        System.out.println("aaaaaaa");
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }

        int[] answer = new int[N];

        for(int i=0;i<a.size();i++){
            answer[i] = a.get(i);
        }

        return answer;
    }

}
