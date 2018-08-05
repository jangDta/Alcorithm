import java.util.Scanner;

// 네 수
public class Baek10824 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String ab = sc.next()+sc.next();
        String cd = sc.next()+sc.next();

        System.out.print(Long.parseLong(ab)+Long.parseLong(cd));

    }
}
