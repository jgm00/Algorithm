import java.util.*;
import java.io.*;


public class Main
{
    static int N, M;
    static int[] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ridx = 0;
        int mn = arr[N-1] - arr[0];
        for(int i=0;i<N;i++){
            while(arr[ridx] - arr[i] < M && ridx < N-1){
                ridx+=1;
            }
            int diff = arr[ridx] - arr[i];
            if(diff >= M){
                mn = Math.min(mn, diff);
            }
        }
        System.out.println(mn);
	}
}