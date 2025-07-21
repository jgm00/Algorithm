import java.io.*;
import java.util.*;

public class Main
{
    static int N,M;
    static int[] A;
    static int binary_search(int k, int l, int r){
        while(l<=r){
            int mid = (l+r) / 2;
            if(A[mid] < k){
                l = mid + 1;
            }else if(A[mid] > k){
                r = mid - 1;
            }else{
                return 1;
            }
        }
        return 0;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(A);
		for(int i=0;i<M;i++){
		    int k = Integer.parseInt(st.nextToken());
		    System.out.println(binary_search(k,0,N-1));
		}
	}
}