package 알코리즘;

import java.util.ArrayList;
import java.util.Scanner;

// 연결요소의 개수
public class Baek11724 {

    static int n, m;
    static Node[] nodes;
    static boolean[] visited;
    static int component;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // node
        m = sc.nextInt(); // edge

        nodes = new Node[n+1];
        visited = new boolean[n+1];
        component = 0;

        for(int i=1;i<=n;i++){
            nodes[i] = new Node(i);
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodes[a].list.add(b);
            nodes[b].list.add(a);
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(i);
                component++;
            }
        }


        System.out.println(component);



    }

    static class Node{
        int data;
        ArrayList<Integer> list;

        public Node(int data) {
            this.data = data;
            this.list = new ArrayList<>();
        }
    }


    static void dfs(int a){
        visited[a] = true;

        Node node = nodes[a];

        for(int i=0;i<node.list.size();i++){
            int cur = node.list.get(i);
            if(!visited[cur]){ // 방문한 적이 없으면
                dfs(cur);
            }
        }
    }


}
