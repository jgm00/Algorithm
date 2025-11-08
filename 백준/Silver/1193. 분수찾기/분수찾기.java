import java.util.*;
import java.io.*;

public class Main {
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        int sm = 0; int cross = 1;
        while(true){
            if(X <= sm + cross){
                break;
            }else{
                sm += cross;
                cross +=1;
            }
        }
        int offset = (X-sm);
        int u,d;
        if(cross % 2 == 0){
            u = offset;
            d = cross - offset + 1;
        }else{
            u = cross - offset + 1;
            d = offset;
        } 
        System.out.println(u+"/"+d);
    }
}
