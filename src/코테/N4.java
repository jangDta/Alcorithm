package 코테;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N4 {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static String[][] map;
    static int n;
    static ArrayList<Country> countries;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new String[n][n];
        countries = new ArrayList<>();

        sc.nextLine();

        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            String[] arr = s.split(" ");

            for(int j=0;j<arr.length;j++){
                map[i][j] = arr[j];

                if(arr[j].charAt(0) >= 65){
                    countries.add(new Country(arr[j],0,i,j));
                }
            }

        }

//
//        for(int i=0;i<countries.size();i++){
//            System.out.println(countries.get(i).name);
//        }

        printmap(map);

        countries.get(0).bfs();


        System.out.println();
        System.out.println();

        countries.get(1).bfs();




        printmap(map);

    }

    static void printmap(String[][] pr){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(pr[i][j]+" " );
            }
            System.out.println();
        }
    }


    static class Country{
        String name;
        int yard;
        int x,y;
        Queue<Point> queue;

        public Country(String name, int yard, int x, int y) {
            this.name = name;
            this.yard = yard;
            this.x = x;
            this.y = y;
            this.queue = new LinkedList<>();
            queue.add(new Point(x,y));

        }

        void bfs(){
            Queue<Point> queue2 = new LinkedList<>();

            while(!queue.isEmpty()){
                Point current = queue.poll();

                for(int i=0;i<4;i++){
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];



                    if(nx>=0 && nx<n && ny>=0 && ny<n){
                        System.out.println("nx:"+nx+" ny:"+ny);
                        if(map[nx][ny].equals("0")){
                            map[nx][ny] = name;
                            queue2.add(new Point(nx,ny));
                        }
                    }


                }
            }

            queue.addAll(queue2);
        }
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
