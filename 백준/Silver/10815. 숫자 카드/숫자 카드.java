import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] num1;
    static HashSet<Integer> hset = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num1 = new int[N+1];
        for(int i=0;i<N;i++){
            num1[i] = Integer.parseInt(st.nextToken());
            hset.add(num1[i]);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int k = Integer.parseInt(st.nextToken());
            if(hset.contains(k)){
                System.out.print(1 + " ");
            }else{
                System.out.print(0 + " ");
            }
        }
    }
}