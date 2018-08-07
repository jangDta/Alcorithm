package 자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 큐
public class Baek10845 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 명령의 수
        sc.nextLine();

        String[] orderList = new String[n];
        Queue<Integer> queue = new LinkedList<>();
        int rear = 0; // queue의 맨 뒤

        for(int i=0;i<n;i++) orderList[i] = sc.nextLine();

        for(int i=0;i<n;i++){
            String order = orderList[i];

            //System.out.println(order);
            switch (order){
                case "size":{
                    System.out.println(queue.size());
                    break;
                }
                case "empty":{
                    if (queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "front":{
                    if (queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.element());
                    break;
                }
                case "back":{
                    if (queue.isEmpty()) System.out.println(-1);
                    else System.out.println(rear);
                    break;
                }
                case "pop":{
                    if (queue.isEmpty()) System.out.println(-1);
                    else{
                        System.out.println(queue.poll());
                    }
                    break;
                }
                default:{
                    String[] split = order.split(" ");
                    int element = Integer.parseInt(split[1]);

                    rear = element;

                    queue.offer(element);
                    break;
                }

            }

            //System.out.println(queue);
        }
    }
}
