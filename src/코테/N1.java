package 코테;

import java.util.ArrayList;
import java.util.Scanner;

public class N1 {
    static ArrayList<Integer> card;
    static int div;

    static ArrayList<ArrayList<Integer>> resultList;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        card = new ArrayList<>();
        resultList = new ArrayList<>();

        for(int i=0;i<c;i++){
            card.add(i+1);
        }

        int p = sc.nextInt();


        for(int i=0;i<p;i++){
            int n = sc.nextInt();

            shuffle(card,n);


            card.clear();

            for(int j=0;j<resultList.size();j++){
                card.addAll(resultList.get(resultList.size()-j-1));
            }

            resultList.clear();

        }

//        System.out.println("nnnnn");
//        for(int i=0;i<resultList.size();i++) System.out.println(resultList.get(i).toString());
//
//



        //System.out.println("card :::: "+card.toString());

        for(int i=0;i<5;i++){
            System.out.println(card.get(i));
        }

    }

    static void shuffle(ArrayList<Integer> list,int n){

        ArrayList<Integer> front = new ArrayList<>();
        ArrayList<Integer> back = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            if(i<n || i>list.size()-n-1) back.add(list.get(i));
            else front.add(list.get(i));
        }

        //System.out.println(front.toString());
       // System.out.println("back:"+back.toString());



        resultList.add(back);
        if(front.size() > 2*n){
            shuffle(front,n);
        }else{
            resultList.add(front);
        }

    }
}
