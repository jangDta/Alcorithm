package 코테;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N2 {
    static int n;
    static int rotate;
    static String[][] map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rotate = sc.nextInt();
        sc.nextLine();
        map = new String[n][n];

        for(int i=0;i<n;i++){

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for(int j=0;j<n;j++){
                map[i][j] = st.nextToken();
            }
        }


        //printmap(map);

        doRotate(map);



    }

    static void printmap(String[][] pr){
        for(int i=0;i<pr.length;i++){
            for(int j=0;j<pr.length;j++){
                System.out.print(pr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void doRotate(String[][] matrix){

        ArrayList<String> outer = new ArrayList<>();

        for(int i=0;i<matrix.length;i++) outer.add(matrix[0][i]);
        for(int i=1;i<matrix.length;i++) outer.add(matrix[i][n-1]);
        for(int i=matrix.length-2;i>=0;i--) outer.add(matrix[n-1][i]);
        for(int i=matrix.length-2;i>0;i--) outer.add(matrix[i][0]);




        System.out.println(outer.toString());
        int a;

        if(rotate > 0){ // 시계방향
            System.out.println("시계뱡향");
            a = rotate%n;
        }else{ // 반시계방향
            System.out.println("반시계방향");
            a = (-rotate)%n;
        }



        if(n%2 != 0){ // 홀수

            System.out.println(" 홀 ");
            System.out.println(a);


        }else{ // 짝수

            System.out.println(" 짝 ");
            System.out.println(a);

        }

    }
}
