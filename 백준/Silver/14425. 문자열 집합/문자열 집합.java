import java.util.*;
import java.io.*;

public class Main {
    static int N,M, ans;
    static HashSet<String> hset = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            hset.add(br.readLine());
        }
        for(int i=0;i<M;i++){
            String s = br.readLine();
            if(hset.contains(s)){
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}