package 알코리즘;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Baek1325 {
    static int n,m;
    static ArrayList<Integer>[] list;
    static ArrayList<Computer> computers;
    static boolean[] visited;
    static int count;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // node
        m = sc.nextInt(); // edge
        count = 0;

        list = new ArrayList[n+1];
        computers = new ArrayList<>();
        visited = new boolean[n+1];


        for(int i=1;i<list.length;i++){
            list[i] = new ArrayList<>();
            computers.add(new Computer(i));
        }

        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            list[to].add(from);

        }

        for(int i=1;i<=n;i++){
            dfs(list,i);
            computers.get(i-1).hackingCount = count;
            count = 0;
            cleanVisited();
        }

//        for(int i=0;i<computers.size();i++){
//            System.out.print(computers.get(i).hackingCount+" ");
//        }



        computers.sort(new MyComparator());


        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(computers.get(0).data);
        int max = computers.get(0).hackingCount;

        for(int i=1;i<computers.size();i++){
            if(max == computers.get(i).hackingCount){
                answer.add(computers.get(i).data);
            }else{
                break;
            }
        }

        for(int i=0;i<answer.size();i++) System.out.print(answer.get(i)+" ");



    }

    static void dfs(ArrayList<Integer>[] list,int start){
        ArrayList<Integer> reliables = list[start];

        visited[start] = true;

        for(int i=0;i<reliables.size();i++){
            int d = reliables.get(i);
            if(!visited[d]){
                count++;
                dfs(list,d);
            }
        }

    }

    static void cleanVisited(){
        for(int i=0;i<visited.length;i++) visited[i] = false;
    }

    static class Computer{
        int data;
        int hackingCount;

        public Computer(int data) {
            this.data = data;
            this.hackingCount = 0;
        }
    }

    static class MyComparator implements Comparator<Computer>{

        @Override
        public int compare(Computer o1, Computer o2) {

            if(o1.hackingCount > o2.hackingCount){
                return -1;
            }else if(o1.hackingCount < o2.hackingCount){
                return 1;
            }else{
                if(o1.data < o2.data){
                    return -1;
                }else{
                    return 1;
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }



}
