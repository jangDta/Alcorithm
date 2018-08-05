import java.util.Scanner;

// 조교는 새디스트야!
public class Baek14656 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] line = new int[n];
        int count = 0;

        for(int i=0;i<n;i++) line[i] = sc.nextInt();

        for(int i=0;i<n;i++){
            if(line[i] != i+1) count++;
        }

        System.out.println(count);

    }
}
