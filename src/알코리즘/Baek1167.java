package 알코리즘;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek1167 {
    static int n;
    static ArrayList<Edge>[] list;
    static int[] parents;

    static int root;
    static ArrayList<Integer> leaf;
    static int[] weightSum;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        list = new ArrayList[n+1];
        parents = new int[n+1];
        leaf = new ArrayList<>();

        root = 0;


        for(int i=0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }

        System.out.println();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine()," ");

            int from = Integer.parseInt(st.nextToken());

            System.out.println("me : "+from);


            while(st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken());

                if(to != -1){
                    int w = Integer.parseInt(st.nextToken());
                    System.out.println("  to:"+to+" , weight:"+w);

                    list[from].add(new Edge(to,w));
                    list[to].add(new Edge(from,w));

                }
            }
        }

        System.out.println("----------------------------------");


        dfs(list,parents,n,1,0);

        for(int i=1;i<=n;i++){
            boolean isLeaf = true;
            int cur = parents[i];

            if(cur == 0) root = i;

            for(int j=1;j<=n;j++){
                if(i == parents[j]){
                    isLeaf = false;
                    break;
                }
            }

            //System.out.println("cur:"+cur+",    "+isLeaf);

            if(isLeaf) leaf.add(i);
        }

        System.out.println("root : "+root);

        System.out.println(leaf.toString());

        weightSum = new int[leaf.size()];


//        for(int i=0;i<leaf.size();i++){
//            find(leaf.get(i),root,i);
//        }


        for(int i=0;i<weightSum.length;i++){
            System.out.println("weightSum "+i+" : "+ weightSum[i]);
        }



    }


    static class Edge{
        int data;
        int weight;

        public Edge(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    static void dfs(ArrayList<Edge>[] list, int[] parents, int n, int start, int parent){
        parents[start] = parent;

        for(int i=0;i<list[start].size();i++){
            int item = list[start].get(i).data;
            if (item != parent) dfs(list,parents,n,item,start);
        }
    }


}
