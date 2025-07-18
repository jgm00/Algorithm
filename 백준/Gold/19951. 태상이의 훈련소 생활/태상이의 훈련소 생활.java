import java.io.*;
import java.util.*;

public class Main
{   
    static int[] delt;
    static int[] acc;
    static int N,M;
    static int[] h;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        delt = new int[N+2];
        h = new int[N+1];
        acc = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            h[i+1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int sts = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            delt[sts] += k;
            delt[ed+1] += -1 * k;
        }
        int sm = 0;
        for(int i =1;i<=N;i++){
            if(delt[i]!=0){
                sm += delt[i];
            }
            acc[i] = sm;
        }
        for(int i=1;i<=N;i++){
            System.out.print((h[i] + acc[i]) + " ");
        }
	}
}