package 자료구조;

import java.util.Scanner;

// ROT13
public class Baek11655 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        char[] chars = s.toCharArray();


        for(int i=0;i<chars.length;i++){
            int current = (int)chars[i];

            if(current != 32){ // ' ' (띄어쓰기)
                if(current >= 65 && current <=90){ // 'A' to 'Z'
                    int pos = current+13;
                    if(pos <= 90) chars[i] = (char)pos;
                    else {
                        chars[i] = (char)(65+12-(90-current));
                    }
                }else if(current >=97 && current <=122){ // 'a' to 'z'
                    int pos = current+13;
                    if(pos <= 122) chars[i] = (char)pos;
                    else {
                        chars[i] = (char)(97+12-(122-current));
                    }
                }
            }
        }

        for(int i=0;i<chars.length;i++){
            System.out.print(chars[i]);
        }

    }
}
