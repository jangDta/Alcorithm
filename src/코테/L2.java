package 코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class L2 {

    public static void main(String[] args) throws IOException {

        ArrayList<Rec> arr = new ArrayList<>();
        int max = 0;

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                int w = Integer.parseInt(tokenizer.nextToken());
                int h = Integer.parseInt(tokenizer.nextToken());

                arr.add(new Rec(x,y,w,h));
                // @todo Write your code here.
            }

            for(int i=0;i<arr.size();i++){
                Rec current = arr.get(i);
                for(int j=0;j<arr.size();j++){

                    if(j!=i){

                        current.check(arr.get(j));


                    }
                }

                if(max < current.count) max = current.count;

//                System.out.println("rec"+i+"   count: "+current.count);
            }

            System.out.println(max);




            // @todo Write your code here.
        }
    }


    static class Rec{
        int x,y,width,height;
        int count;

        public Rec(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.count = 1;
        }


        void check(Rec rec2){
            if(x<rec2.x && x+width>rec2.x && y<rec2.y && y+height>rec2.y){
                this.count++;
            }
        }
    }
}
