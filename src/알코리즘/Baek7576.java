package 알코리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 토마토
public class Baek7576 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count = 1;
    static boolean amIfirst = true;

    static int m, n;
    static int[][] box;

    static ArrayList<Point> dict;
    static ArrayList<Point> tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];

        dict = new ArrayList<>();
        tmp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(tokenizer.nextToken());
                box[i][j] = input;
            }
        }


        //System.out.println("zerocountfirst:"+zeroCount);


        while (true) {


            if (amIfirst) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (box[i][j] == count) {
                            dict.add(new Point(i, j));
                        }
                    }
                }

                amIfirst = false;
            }else{
                dict.addAll(tmp);
                tmp.clear();
            }

            //System.out.println(dict);


            for (int i = 0; i < dict.size(); i++) {
                //System.out.println(dict.get(i).getX()+","+dict.get(i).getY());
                counting(dict.get(i).getX(), dict.get(i).getY());
            }

            //System.out.println(dict);

            if (dict.isEmpty()) {
                if (!isBoxHasSpace()) {
                    break;
                }
                count = 1;
                break;

            }

            count++;


//            zeroCount -= dict.size();
//
//            System.out.println("zerocOunt:"+zeroCount);

            dict.clear();

        }


        //printBox();

        System.out.println(count - 2);


    }


    static void counting(int i, int j) {

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (box[nx][ny] == 0) {
                    box[nx][ny] = count + 1;
                    tmp.add(new Point(nx, ny));
                }
            }

        }
    }

    static boolean isBoxHasSpace() {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    static void printBox() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(box[i][j]);
            }
            System.out.println();
        }
    }


    static class Point {
        int x, y;

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

        public void print() {
            System.out.println("x:" + x + " y:" + y);
        }

    }


}
