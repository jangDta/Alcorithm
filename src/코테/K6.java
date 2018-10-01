import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class K6 {
    static Page[] pageArr;

    public static void main(String[] args){
        String word = "blind";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};

        pageArr = new Page[pages.length];

//        for(int i=0;i<pages.length;i++){
//            System.out.println(pages[i]);
//            System.out.println();
//        }

        for(int i=0;i<pages.length;i++){
            System.out.println("------------------PAGE"+i+"-------------------------------");
            whoamI(pages[i]);
            basic(pages[i],word);

            System.out.println();
        }



    }


    static void whoamI(String result){

        String tag_start = "content=\"";
        String tag_end = "\"/>";
        int pt_start = result.indexOf(tag_start);
        int pt_end = result.indexOf(tag_end);

        String word = result.substring(pt_start+tag_start.length(),pt_end);
        System.out.println("i am: "+word);

    }

    static void basic(String result,String word){

        String tag_start = "<body>\n";
        String tag_end = "\n</body>";
        int pt_start = result.indexOf(tag_start);
        int pt_end = result.indexOf(tag_end);

        int basic_count = 0;

        String body = result.substring(pt_start+tag_start.length(),pt_end);
        System.out.println(body);

        String[] lines = body.split("\n");
        //System.out.println(lines.length);

        for(int i=0;i<lines.length;i++){
            if(i%2 == 0){ // 기본 점수 계산
                String line = lines[i].toLowerCase();

                Pattern pattern = Pattern.compile(word);
                Matcher matcher = pattern.matcher(line);
                while(matcher.find()) basic_count++;

            }else{ // 링크점수 계산

            }
        }

        double link_count = (double)basic_count/(lines.length/2);

        System.out.println("기본 점수:"+basic_count);
        System.out.println("외부 링크 수:"+lines.length/2);
        System.out.println("링크 점수:"+link_count);

    }

    static class Page{
        String url;
        int basic_score;
        int link_count;
        double link_score;



    }
}
