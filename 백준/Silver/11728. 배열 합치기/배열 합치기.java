import java.util.*;
import java.io.*;


public class Main
{
    static int N,M;
    static int[] A,B;
    static int[] ans;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];
        ans = new int[N+M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);Arrays.sort(B);
        int t = 0; int k = 0; int idx =0;
        while(idx != (N+M)){
            if(t>=N){
                ans[idx] = B[k];
                k+=1;
                idx+=1;
                continue;
            }
            if(k>=M){
                ans[idx] = A[t];
                t+=1;
                idx+=1;
                continue;
            }
            if(A[t] > B[k]){
                ans[idx] = B[k];
                k+=1;
            }else{
                ans[idx] = A[t];
                t+=1;
            }
            idx += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N+M; i++){
            sb.append(ans[i] + " ");
        }
        System.out.println(sb.toString());
	}
}
