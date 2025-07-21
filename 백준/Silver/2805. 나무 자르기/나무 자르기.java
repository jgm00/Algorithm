import java.io.*;
import java.util.*;

public class Main
{
    static int N,M;
    static int[] arr;
    static boolean isT(int k){
        Long sum =0L;
        for(int i=0;i<N;i++){
            sum += Math.max((arr[i] - k),0);
        }
        if(M > sum){
            return false;
        }
        return true;
    }
	public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       arr = new int[N];
       st = new StringTokenizer(br.readLine());
       for(int i=0;i<N;i++){
           arr[i] = Integer.parseInt(st.nextToken());
       }
        Arrays.sort(arr);
       int l = 0; int r = 2000000000;
       int ans = 0;
       while(l<=r){
           int mid = (l+r) / 2;
           if(isT(mid) == false){
               r = mid -1; 
           }else
           {
               l = mid + 1;
               ans = mid;
           }
       }
       System.out.println(ans);
	}
}