package 알코리즘;

import java.util.ArrayList;
import java.util.Scanner;

// 트리의 부모 찾기
public class Baek11725 {

    static int n;
    static ArrayList<Integer>[] list;
    static int[] parents;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // node

        list = new ArrayList[n+1];
        parents = new int[n+1];

        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            list[from].add(to);
            list[to].add(from);

        }

        dfs(list,parents,n,1,0);

        for(int i=2;i<=n;i++) System.out.println(parents[i]);



    }

    static void dfs(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent){
        parents[start] = parent;

        for(int i=0;i<list[start].size();i++){
            int item = list[start].get(i);
            if (item != parent) dfs(list,parents,n,item,start);
        }
    }







}
