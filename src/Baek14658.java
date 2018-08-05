import java.util.Scanner;

// 하늘에서 별똥별이
public class Baek14658 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt(); // NxM 구역
        int l = sc.nextInt(); // LxL 트램펄린
        int k = sc.nextInt(); // K개의 별똥별

        int[] x_arr = new int[k];
        int[] y_arr = new int[k];

        for(int i=0;i<k;i++){
            x_arr[i] = sc.nextInt();
            y_arr[i] = sc.nextInt();
        }

        // 각 출발점 x_arr[i],y_arr[j]에 대하여 L짜리 트램펄린 배치

        int max = 0; // 최대로 팅겨낼 수 있는 별똥별 수

        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                int point_x = x_arr[i];
                int point_y = y_arr[j];
                // 트램펄린 꼭지점
                int count = 0;

                for(int s=0;s<k;s++){
                    if(point_x <= x_arr[s] && x_arr[s] <= point_x+l && point_y <= y_arr[s] && y_arr[s] <= point_y+l) count++;
                }


                if(count > max){
                    max = count;
//                    System.out.println("x:"+point_x+" y:"+point_y);
//                    System.out.println("max:"+max);
                }
            }
        }

        System.out.println(k-max);


    }
}
