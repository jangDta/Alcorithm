package 알코리즘;

import java.util.ArrayList;
import java.util.Scanner;

// 토마토
public class Baek7576 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count = 1;

    static int m,n;
    static int[][] box;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        box = new int[n][m];

        ArrayList<Point> dict = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                box[i][j] = sc.nextInt();
            }
        }

        while(isBoxHasSpace()){

            printBox();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(box[i][j] == count){
                        dict.add(new Point(i,j));
                    }
                }
            }

            for(int i=0;i<dict.size();i++){
                System.out.println(dict.get(i).getX()+","+dict.get(i).getY());
                counting(dict.get(i).getX(),dict.get(i).getY());
            }

            count++;
            dict.clear();

        }


        printBox();


    }


    static void counting(int i,int j){
        for(int k=0;k<4;k++){
            int nx = i+dx[k];
            int ny = j+dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m){
                if(box[nx][ny] == 0){
                    box[nx][ny] = count+1;
                }
            }

        }
    }

    static boolean isBoxHasSpace(){
        boolean flag = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(box[i][j] == 0){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    static void printBox(){
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(box[i][j]);
            }
            System.out.println();
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
