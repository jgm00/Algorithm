import java.util.*;
import java.io.*;


public class Main
{
    static int N,M;
    static int[] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cursum = 0;
        int ridx = 0; int cnt =0;
        for(int i=0;i<N;i++){
            while(cursum < M && ridx < N){
                cursum += arr[ridx++]; 
            }
            if(cursum == M){
                cnt += 1;
            }
            cursum -= arr[i];
        }
        System.out.println(cnt);
	}
}