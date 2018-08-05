import java.util.Scanner;

//한조 서열정리
public class Baek14659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 봉우리의 수
        int max = 0;

        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        for(int i=0;i<n-1;i++){
            int current = arr[i];
            int count = 0;

            for(int j=i+1;j<n;j++){
                if(current > arr[j]) count++;
                else break;
            }

            if(max < count) {
                max = count;
            }
        }

        System.out.println(max);
    }
}
