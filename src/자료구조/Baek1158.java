package 자료구조;

import java.util.*;

// 조세퍼스
public class Baek1158 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n명의 사람
        int m = sc.nextInt(); // m번째 사람부터 제거하겠음

        ArrayList<Integer> circularQueue = new ArrayList<>();

        for(int i=0;i<n;i++) circularQueue.add(i+1); // 자리에 다 앉히기

        int current = 0;
        m = m-1;

        ArrayList<Integer> answer = new ArrayList<>();

        while (!circularQueue.isEmpty()){
            if(current+m < circularQueue.size()){ // 순환 안해도 될 떄
                current = current+m;
                //System.out.println(circularQueue.get(current));
                answer.add(circularQueue.get(current));
                circularQueue.remove(current);
            }else{ // 순환 될 때
                current = (current+m)%circularQueue.size();
                //System.out.println(circularQueue.get(current));
                answer.add(circularQueue.get(current));
                circularQueue.remove(current);

            }
            //System.out.println("current:"+current);
            //System.out.println(circularQueue);
        }

        System.out.print("<");
        for(int i=0;i<answer.size();i++){
            if(i != answer.size()-1){
                System.out.print(answer.get(i)+", ");
            }else{
                System.out.print(answer.get(i)+">");
            }
        }

    }

}
