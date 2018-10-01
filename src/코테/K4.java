import java.util.ArrayList;
import java.util.Collections;

public class K4 {
    public static void main(String[] args){
        int[] food_times = {3,1,2};
        long k = 5;

        solution(food_times,k);
    }


    static int solution(int[] food_times, long k) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<food_times.length;i++) arr.add(food_times[i]);

        Collections.sort(arr);

        while(!arr.isEmpty()){
            System.out.println(arr.toString());
            int count = 0;


            if(arr.get(0) != 1){
                count++;
                for(int i=0;i<arr.size();i++){
                    arr.set(i,arr.get(i)-1);
                }
            }else{ // 1

                arr.remove(0);
                count = 0;
            }
            System.out.println("count:"+count);
        }



        return answer;
    }


}
