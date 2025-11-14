import java.util.*;
import java.io.*;

public class Main
{
	static int[] day;
	static int N, K, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		day = new int[32];
		for(int i=0; i < N;i++ ){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    for(int j=a;j<b;j++){
		        day[j]+=1;
		    }
		}
		K = Integer.parseInt(br.readLine());
		int ans = 1;
		for(int i=1;i<32;i++){
            if(day[i] > K){
                ans = 0;
                break;
            }
		}
	    System.out.println(ans);
	}
}