import java.util.*;
import java.io.*;

public class Main {
    static int N,S;
    static int[] num;
    static int cnt = 0;
    static void dfs(int k, int sum){
        if(k == N){
            if(sum == S){
                cnt+=1;
            }
            return;
        }
        dfs(k+1, sum);
        dfs(k+1, sum + num[k]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        if(S == 0){
            cnt -= 1;
        }
        System.out.println(cnt);
    }
}
