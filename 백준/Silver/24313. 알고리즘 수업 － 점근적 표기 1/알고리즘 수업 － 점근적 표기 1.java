import java.util.*;
import java.io.*;

public class Main {
    static int a1, a0, c, n0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a0 = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());
        if(a1*n0+a0 <= c*n0 && c >= a1){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}