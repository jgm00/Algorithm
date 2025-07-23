import java.util.*;
import java.io.*;


public class Main
{
    static int mn = Integer.MAX_VALUE;
    static int[] arr;
    static int N,S;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cursum = 0;
        int ridx = 0;
        for(int i=0;i<N;i++){
            while(cursum < S && ridx < N){
                cursum += arr[ridx++];
            }
            if(cursum >= S){
                mn = Math.min(ridx - i,mn);
            }
            cursum -= arr[i];
        }
        if(mn == Integer.MAX_VALUE){
            mn = 0;
        }
        System.out.println(mn);
	}
}