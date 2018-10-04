package 코테;

import java.util.ArrayList;
import java.util.HashMap;

public class K1 {
    public static void main(String[] args){
        String[] record = 	{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};


        String[] ans = solution(record);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }

    static String[] solution(String[] record){
        String[] answer = {};
        ArrayList<String> answer2 = new ArrayList<>();

        HashMap<String,String> hashMap = new HashMap<>();



        for(int i=0;i<record.length;i++){
            String[] tokens = record[i].split(" ");
            if(tokens.length == 3){ // Enter, Change
//                    System.out.println("reccord:"+record[i]);
                    hashMap.put(tokens[1],tokens[2]); // ( uid , nickname )
            }
        }

        for(int i=0;i<record.length;i++){
            String[] tokens = record[i].split(" ");

            if(tokens[0].equals("Enter")) answer2.add(hashMap.get(tokens[1])+"님이 들어왔습니다.");
            if(tokens[0].equals("Leave")) answer2.add(hashMap.get(tokens[1])+"님이 나갔습니다.");

        }


        answer = new String[answer2.size()];

        answer2.toArray(answer);


        return answer;
    }

}
