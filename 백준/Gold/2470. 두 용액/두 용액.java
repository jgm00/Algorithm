import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static int[] arr;
    static int bin_s(int tar){
        int l = 0; int r = N-1;
        int idx = 0;
        while(l<=r){
            int mid = (r+l) / 2;
            if(arr[mid] < tar){
                l = mid + 1;
                idx = l;
            }else if(arr[mid] > tar){
                r = mid - 1;
            }else {
                return mid; 
            }
        }
        return idx;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int mn = Integer.MAX_VALUE;
        int a = 0; int b = 0;
        for(int i=0;i<N;i++){
            int k = bin_s(-1 * arr[i]);
            if(N > k && k > -1){
            if(arr[k] != arr[i]) {
                if(mn > Math.abs(arr[i] + arr[k])){
                    mn = Math.abs(arr[i] + arr[k]);
                    a = Math.min(arr[i], arr[k]);
                    b = Math.max(arr[i], arr[k]);
                }}}
            if(k-1>=0){
            if(arr[k-1] != arr[i]){
                if(mn > Math.abs(arr[i] + arr[k-1])){
                    mn = Math.abs(arr[i] + arr[k-1]);
                    a = Math.min(arr[i], arr[k-1]);
                    b = Math.max(arr[i], arr[k-1]);
                }
            }}
        }
        System.out.println(a + " " + b);
	}
}