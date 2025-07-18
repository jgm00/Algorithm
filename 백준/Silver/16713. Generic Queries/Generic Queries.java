import java.io.*;
import java.util.*;

public class Main
{   
    static int N, Q;
    static int[] arr, psum;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        psum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            psum[i] = psum[i-1]^arr[i];
        }
        int sum =0;
        for(int i=1;i<=Q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum ^= (psum[b] ^ psum[a-1]);
        }
        System.out.println(sum);
	}
}