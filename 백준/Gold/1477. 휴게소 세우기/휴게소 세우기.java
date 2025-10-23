import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,L;
    static int[] num, diff;
    static int cal(int k){
        int sm = 0;
        for(int i=0;i<N+1;i++){
            sm += diff[i]/k;
        }
        return sm;
    }
    static int binaryS(int l, int r, int tar){
        int ans = 1;
        while(l <= r){
            int mid = (l + r) / 2;
            int cals = cal(mid);
            if(cals <= tar ){
                r = mid - 1;
            }else{
                l = mid + 1;
                ans = l;
            }
        }
        return ans;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        num = new int[N+2];
        num[0] = 0;
        num[N+1] = L;
        diff = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for(int i=1;i<N+2; i++){
            diff[i-1] = num[i] - num[i-1] - 1;
        }
        Arrays.sort(diff);
        int answer = binaryS(1,L-1,M);
        System.out.println(answer);
	}
}