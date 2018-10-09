import java.util.ArrayList;

public class RunLength {

    static ArrayList<Run> runs; // run list
    static int[][] rowIndex; //  row별 -> runs에 저장된 run들의 index

    public static void main(String[] args){
        int[][] image = {{1,1,0,1,1},{1,1,0,0,1},{1,1,1,0,1},{0,0,0,0,0},{0,1,1,1,1}}; //  binary image
        rowIndex = new int[5][2];
        int idx = 0;
        int labelNum = 1;

        runs = new ArrayList<>();

        System.out.println("Binary Image");
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i=0;i<5;i++){
            int[] rowArr = image[i];
            addRun(rowArr,i);
        }


        for(int i=0;i<runs.size();i++){
            if(runs.get(i).row == 0){
                runs.get(i).label = labelNum;
                labelNum++;
            }
        }

        System.out.println("Initial Runs");

        for(int i=0;i<runs.size();i++){
            Run r = runs.get(i);
            System.out.print("row:"+r.row+"  scol:"+r.scol+"  ecol:"+r.ecol+"  label:"+r.label);
            System.out.println();
        }
        System.out.println();


        for(int i=0;i<runs.size();i++){
            Run r = runs.get(i);

            if(r.row == idx){
                if(rowIndex[idx][0] == 0){
                    rowIndex[idx][0] = i+1;
                    if(i == runs.size()-1) rowIndex[idx][1] = i+1;
                }else{
                    rowIndex[idx][1] = i+1;
                }
            }else{
                idx++;
                i--;
            }
        }

        System.out.println("Initial RowIndex");

        for(int i=0;i<5;i++){
            for(int j=0;j<2;j++){
                System.out.print(rowIndex[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=1;i<5;i++){
            ArrayList<Run> prev = getRuns(i-1);
            ArrayList<Run> curr = getRuns(i);

            if(prev == null || curr == null){
                if(curr != null){
                    for(int j=0;j<curr.size();j++){
                        Run currentRun = curr.get(j);
                        currentRun.label = labelNum;
                        labelNum++;
                    }
                }
                continue;
            }


            for(int j=0;j<curr.size();j++){
                Run currentRun = curr.get(j);

                for(int k=0;k<prev.size();k++){
                    Run prevRun = prev.get(k);

                    if(prevRun.scol <= currentRun.scol && prevRun.ecol >= currentRun.scol){
                        currentRun.label = prevRun.label;
                    }

                    if(prevRun.scol <= currentRun.ecol){
                        currentRun.label = prevRun.label;
                    }
                }
            }


        }

        System.out.println("Final Runs");
        for(int i=0;i<runs.size();i++){
            Run r = runs.get(i);
            System.out.print("row:"+r.row+"  scol:"+r.scol+"  ecol:"+r.ecol+"  label:"+r.label);
            System.out.println();
        }



    }

    static void addRun(int[] arr,int row){

        for(int i=0;i<5;i++){
            if(arr[i] == 1){

                if(i == 4){
                    if(arr[i-1] == 0){
                        runs.add(new Run(row,i,i));
                    }
                }else{

                        for(int j=i+1;j<5;j++){
                            if(arr[j] != 1){
                                runs.add(new Run(row,i,j-1));
                                i = j;

                                break;
                            }
                            if(j == 4){
                                runs.add(new Run(row,i,j));
                                i = j;

                            }
                        }

                    }
            }
        }

    }

    static ArrayList<Run> getRuns(int idx){
        int a = rowIndex[idx][0]-1;
        int b = rowIndex[idx][1];

        if(a>=0){
            //System.out.println("a:"+a+" b:"+b);
            ArrayList<Run> list = new ArrayList<>(runs.subList(a,b));

            for(int i=0;i<list.size();i++){
                Run r = list.get(i);
                //System.out.println("row:"+r.row+" scol:"+r.scol+" ecol:"+r.ecol);
            }

            return list;
        }

        return null;
    }

    static class Run{
        int row;
        int scol;
        int ecol;
        int label;

        public Run(int row, int scol, int ecol) {
            this.row = row;
            this.scol = scol;
            this.ecol = ecol;
            this.label = 0;
        }
    }
}
