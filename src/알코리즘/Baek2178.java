package 알코리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 미로 탐색
public class Baek2178 {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] visited;

    static int n, m;
    static int[][] maze;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        maze = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            for(int j=0;j<m;j++){
                maze[i][j] = (int)s.charAt(j) - 48;
            }
        }


        visited[0][0] = true;
        bfs(0,0);

        System.out.println(maze[n-1][m-1]);
//
//                for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(maze[i][j]);
//            }
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(visited[i][j]);
//            }
//            System.out.println();
//        }

    }

    static void bfs(int x,int y){
        Point point = new Point(x,y);
        Queue<Point> queue = new <Point>LinkedList();

        queue.add(point);

        while(!queue.isEmpty()){
            Point p = queue.poll();
            //p.print();

            for(int i=0;i<4;i++){
                int nx = p.getX()+dx[i];
                int ny = p.getY()+dy[i];



                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maze[nx][ny] == 0 || visited[nx][ny]) continue;
                //System.out.println("----- nx:"+nx+" ny:"+ny);

                    queue.add(new Point(nx,ny));

                    visited[nx][ny] = true;
                    maze[nx][ny] = maze[p.getX()][p.getY()]+1;

            }

        }
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void print(){
            System.out.println("x:"+x+" y:"+y);
        }

    }

}


