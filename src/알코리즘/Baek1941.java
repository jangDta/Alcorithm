package 알코리즘;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// 소문난 칠공주
public class Baek1941 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static int count = 0;
    static int n = 0;
    static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        map = new char[5][5];

        ArrayList<Dasom> arr = new ArrayList<>();

        for(int i=0;i<5;i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 5; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if(c == 'S') arr.add(new Dasom(i,j));
            }
        }

        Combination combination = new Combination(arr);
        combination.doCombination(arr.size(),4,0);

        System.out.println(" ------------------------------ ");
        System.out.println(combination.getSolve());




    }

//    static void dfs(int x,int y){
//        if(count == 7)
//        count++;
//        System.out.println("count:"+count);
//
//        for(int i=0;i<4;i++){
//            int nx = x+dx[i];
//            int ny = y+dy[i];
//
//            if(nx<0 || ny<0 || nx>=5 || ny>=5) {
//                continue;
//            }
//            if(map[nx][ny] == 'S') count++;
//
//            dfs(nx,ny);
//        }
//    }

    static class Dasom{
        private int x;
        private int y;

        public Dasom(int x,int y){
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


    static class Combination{
        private ArrayList<Dasom> arr;     //기준 배열
        private Stack<Dasom> st; //조합을 저장할 스택
        int res = 0;
        int solve = 0;
        public Combination(ArrayList<Dasom> arr){
            this.arr = arr;             //배열을 받아 객체에 저장한다.
            st = new Stack<Dasom>(); //스택에 메모리를 할당한다.
        }
        public void showStack(){
            //스택에 있는 값들을 출력한다.
            for(int i=0;i<st.size();i++){
                System.out.print(st.get(i)+" ");
            }
            System.out.println("");

            for(int i=0;i<st.size()-1;i++){
                System.out.println("cal:   "+calculate(st.get(i),st.get(i+1)));
                res += calculate(st.get(i),st.get(i+1));
            }

            System.out.println("res : "+res);
            if( res <= 7 ) solve++;
            res = 0;
        }

        public int calculate(Dasom d1,Dasom d2){
            //System.out.println("math ======>  "+Math.abs(d1.getX()-d2.getX()) + Math.abs(d1.getY()-d2.getY()));
            if (d1.getX() == d2.getX()) return Math.abs(d1.getY()-d2.getY());
            else return Math.abs(d1.getX()-d2.getX());
        }

        public void doCombination(int n, int r, int index){
            if(r==0){
                showStack();
                return;
            }
            else if(n==r){
                for(int i=0;i<n;i++)st.add(arr.get(index+i));//index부터 n개를 차례대로 스택에 넣고
                showStack(); //스택을 보여준다.
                for(int i=0;i<n;i++)st.pop(); //이후 전부 pop을 시켜 다음 과정을 진행한다.
            }
            else{
                st.add(arr.get(index));
                doCombination(n-1,r-1,index+1); //index를 스택에 넣은상태로 index를 1옮겨 그대로 진행.

                //index를 포함하지 않는 경우
                st.pop(); //index를 제거해주고
                doCombination(n-1, r, index+1); //index를 제외한 상태에서 n-1Cr 진행.


            }
        }

        public int getSolve() {
            return solve;
        }
    }


}



