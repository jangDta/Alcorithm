import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class L4 {

    static HashMap<String,String> server;
    static String[] requestArr;
        public static void main(String[] args) throws IOException {

            server = new HashMap<>();


            try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                final int n = Integer.parseInt(br.readLine());
                requestArr = new String[n];
                for (int i = 0; i < n; i++) {
                    final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                    String method = tokenizer.nextToken();
                    String url = tokenizer.nextToken();
                    String body = null;
                    if (tokenizer.hasMoreTokens()) {
                        body = tokenizer.nextToken();
                    }

                    String request;
                    if(body == null){
                        request = method +" "+ url;
                    }else{
                        request = method +" "+ url+" "+body;
                    }

                    requestArr[i] = request;

                   // System.out.println(request);

                    //System.out.println("----------"+i+"--------------");
                    come(request);


                }
            }
        }

        static void come(String request){
            String[] arr = request.split(" ");
            String method = arr[0];
            String s = arr[1];

            //System.out.println("request:"+request);

            if(s.split("/").length == 4){

                if(arr.length == 3){
                    //System.out.println("save");
                    save(arr[0],arr[1],arr[2]);
                }else{
                    //System.out.println("show");
                    showdata(arr[0],arr[1]);
                }

            }else if (s.split("/").length == 3){
                if(arr[1].split("/").length == 3){
                    //System.out.println("create");
                    create(arr[0],arr[1]);
                }
            }else{
                System.out.println("404 NOT_FOUND");
            }
        }


        static void create(String method, String s){

            if(method.equals("GET")){
                System.out.println("405 METHOD_NOT_ALLOWED");
            }else{
                String[] arr = s.split("/");

                String id = arr[2];
                //System.out.println(id);

                if(!server.containsKey(id)){
                    server.put(id,null);
                    System.out.println("201 CREATED");
                }else{
                    System.out.println("403 FORBIDDEN");
                }
            }

        }



        static void save(String method, String s, String body){

            if(method.equals("GET")){
                System.out.println("405 METHOD_NOT_ALLOWED");
            }else{
                String[] arr = s.split("/");

                String id = arr[2];

                String data = body.substring(6);

                if(!server.containsKey(id)){
                    System.out.println("403 FORBIDDEN");
                }else{
                    server.put(id,data);
                    System.out.println("200 OK");
                }
            }
        }

        static void showdata(String method, String s){
            if(method.equals("POST")){
                System.out.println("405 METHOD_NOT_ALLOWED");
            }else{

                String[] arr = s.split("/");

                String id = arr[2];

                if(!server.containsKey(id)){
                    System.out.println("403 FORBIDDEN");
                }else{

                    if(server.get(id) == null){
                        System.out.println("404 NOT_FOUND");
                    }else{
                        System.out.println("200 OK "+ server.get(id));

                    }
                }



            }
        }

}
