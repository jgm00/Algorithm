import java.util.*;
import java.io.*;

public class Main { 
    static int N;
    static double p, mx;
    static double[] num;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new double[N+1];
        for(int i=0;i<N;i++){
            num[i] = Double.parseDouble(br.readLine());
        }
        p = num[0];
        for(int i=1;i<N;i++){
            if(num[i] > p*num[i]){
                p = num[i];
            }else{
                p = p*num[i];
            }
            mx = Math.max(p,mx);
        }
        System.out.printf("%.3f", mx);
    } 
}
