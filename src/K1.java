import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class K1 {

    static HashSet<String> hashSet;
    static String ipAddressString;
    static ArrayList<String> answerList;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ipAddressString = sc.nextLine();
        answerList = new ArrayList<>();
        hashSet = new HashSet<>();


        if(ipAddressString.length() == 9){
            arr = new int[]{3,3,2,1};
            calculate(arr);
        }else if(ipAddressString.length() == 10){
            arr = new int[]{3,3,2,2};
            calculate(arr);
            arr = new int[]{3,3,3,1};
            calculate(arr);

        }else if(ipAddressString.length() == 11){
            arr = new int[]{3,3,3,2};
            calculate(arr);
        }else if(ipAddressString.length() == 12){
            arr = new int[]{3,3,3,3};
            calculate(arr);
        } else if(ipAddressString.length()>=4 && ipAddressString.length()<9){
            System.out.println("see ya");
        }




    }

    static void calculate(int[] arr){
        perm(arr, 0);


        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){

            String current = iterator.next();

            move(current);

            //System.out.println(" ===================== ");

        }



    }

    static void perm(int[] arr, int pivot) {
        if (pivot == arr.length) {
            hashSet.add(toStr(arr));
            return;
        }
        for (int i = pivot; i < arr.length; i++) {
            swap(arr, i, pivot);
            perm(arr, pivot + 1);
            swap(arr, i, pivot);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static String toStr(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += String.valueOf(arr[i]);
        }

        return result;
    }

    static boolean move(String s){
        int start = 0;
        String answer = "";
        for(int i=0;i<s.length();i++){
            int idx = (int)s.charAt(i) - 48;
            //System.out.println("     idx : " + idx);

            String subString = ipAddressString.substring(start,start+idx);
            start += idx;
            //System.out.println(subString);


            if(!check(subString)) return false;

            if(i != s.length()-1) answer += subString+".";
            else answer += subString;

        }

        answerList.add(answer);
        return true;

    }

    static boolean check(String s){
        int a = Integer.parseInt(s);
        if(a>255) return false;
        else return true;
    }

}
