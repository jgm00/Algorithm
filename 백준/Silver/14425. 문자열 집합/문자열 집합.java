import java.io.*;
import java.util.*;

public class Main
{
    static int N,M;
    static int cnt = 0;
    static String[] arr;
    static boolean bin_search(String s, int l, int r){
        while(l <= r){
            int mid = (l + r) / 2;
            if(s.equals(arr[mid])){
                return true;
            }else if(arr[mid].compareTo(s) < 0){
                l = mid + 1;
            }else if(arr[mid].compareTo(s) > 0){
                r = mid - 1;
            }
        }
        return false;
    }
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        for(int i =0;i<M;i++){
            String s = br.readLine();
            if(bin_search(s,0,N-1)){
                cnt += 1;
            }
        }
        System.out.println(cnt);
	}
}