import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static int[] T;
    static ArrayList<Integer> U = new ArrayList<>();
    static boolean bin_s(int l, int r, int k){
        while(l<=r){
            int mid = (l+r) / 2;
            if(U.get(mid) < k){
                l = mid + 1;
            }else if(U.get(mid) > k){
                r = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        for(int i=0;i<N;i++){
            int k = Integer.parseInt(br.readLine());
            T[i] = k;
        }
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
               U.add(T[i] + T[j]);
            }
        }
        Collections.sort(U);
        int mx = -1;
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                int t = T[i] - T[j];
            if(bin_s(0,U.size(),t)){
                mx = Math.max(T[i],mx);
           };}
        }
        System.out.println(mx);
	}
}