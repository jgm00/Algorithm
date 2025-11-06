import java.util.*;
import java.io.*;

public class Main
{
    static int A,B;
    static int[] As, Bs;
    static boolean binarySearch(int l, int r, int tar, int[] arr){
        while(l <= r){
            int mid = (l + r) / 2;
            if(tar == arr[mid]){
                return true;
            }else if(tar < arr[mid]){
                r = mid - 1;
            }else if(tar > arr[mid]){
                l = mid + 1;
            }
        }
        return false;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        As = new int[A]; Bs = new int[B];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++){
            As[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<B;i++){
            Bs[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        Arrays.sort(Bs); Arrays.sort(As);
        if(B > A){
            for(int i=0;i<B;i++){
                if(binarySearch(0,A-1,Bs[i], As)){
                    cnt += 1;
                }
            }
        }else{
            for(int i=0;i<A;i++){
                if(binarySearch(0,B-1,As[i], Bs)){
                    cnt += 1;
                }
            }
        }
        System.out.println(A+B-cnt-cnt);
	}
}