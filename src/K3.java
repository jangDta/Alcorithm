import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class K3 {
    static int N;
    static int M;
    static char[][] map;
    static int[][] isVisit;
    static int[] dx = {0, 0, -1, 1};		//좌, 우, 상, 하 
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());
            map = new char[N][M];
            isVisit = new int[N][M];

            for (int i = 0; i < N; i++) {
                String tmp = br.readLine();

                for(int j = 0; j < M; j++) {
                    map[i][j] = tmp.charAt(j);
                    isVisit[i][j] = -1;
                }
            }

            isVisit[0][0] = 0;
//            print();
            bfs(0, 0);
            print(isVisit);
            System.out.println(isVisit[N - 1][M - 1]);

        }

    }

    public static boolean checkIndex(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M)		//outOfIndex
            return false;

        if (isVisit[x][y] != -1)		//방문했던 곳이면
            return false;

        if (map[x][y]==M)		// 막다른 길이면
            return false;

        return true;
    }

    public static void bfs(int x, int y) {
        Point point = new Point(x,y);
        Queue<Point> queue = new LinkedList<Point>();

        queue.add(point);	//insert

        while(!queue.isEmpty()){
            Point p = queue.poll();		//pop
            //p.print();

            for(int i=0;i<4;i++){
                int nx = p.getX()+dx[i];
                int ny = p.getY()+dy[i];

                if(!checkIndex(nx, ny))
                    continue;

                queue.add(new Point(nx,ny));

                isVisit[nx][ny] = 0;
                isVisit[nx][ny] = isVisit[p.getX()][p.getY()]+1;

            }

        }

    }

    public static class Point{
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

    }

    public static void print(int[][] arr) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }
}