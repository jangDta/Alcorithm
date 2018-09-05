package 알코리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 외판원 순회2
public class Baek10971 {

    static int n;
    static int[][] cost;
    static ArrayList<Integer> arr;
    static int min = 2147483647;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        cost = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j] = sc.nextInt();
            }
        }

        arr = new ArrayList<>();
        for(int i=0;i<n;i++) arr.add(i);

        for(int i=0;i<n;i++) except(i);

        System.out.println(min);


    }

    static void except(int x){
        arr.remove(x);
        int[] arr2 = new int[n-1];


        for(int i=0;i<arr2.length;i++) arr2[i] = arr.get(i);

        System.out.println(x+"에서 출발해 "+x+"로 돌아오는 경우");

        for(int i=0;i<arr2.length;i++) System.out.print(arr2[i]+" ");
        System.out.println("--------------------");

        perm(arr2,0,x);

        arr.add(x);
        Collections.sort(arr);

    }

    static void perm(int[] arr, int pivot,int except) {
        if (pivot == arr.length) {
            print(arr);
            System.out.println("except:"+except+"일때 ,     cal:"+calculatePath(arr,except));
            if(calculatePath(arr,except) > 0 && min > calculatePath(arr,except)) min = calculatePath(arr,except);
            return;
        }
        for (int i = pivot; i < arr.length; i++) {
            swap(arr, i, pivot);
            perm(arr, pivot + 1,except);
            swap(arr, i, pivot);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    static int calculatePath(int[] arr,int x){
        int res = 0;
        if(cost[x][arr[0]] == 0 || cost[arr[arr.length-1]][x] == 0) {
            return -2147483647;
        }
        res+= cost[x][arr[0]];
        res+= cost[arr[arr.length-1]][x];
        //System.out.println(cost[x][arr[0]]+"+"+cost[arr[arr.length-1]][x]);

        for(int i=0;i<arr.length-1;i++){
            if(cost[arr[i]][arr[i+1]] == 0) res+= -2147483647;
            res+= cost[arr[i]][arr[i+1]];
        }

        return res;
    }


}


