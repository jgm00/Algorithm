import java.util.*;
import java.io.*;

public class Main
{
    static int A,B,C;
    static int mx,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	StringTokenizer st = new StringTokenizer(br.readLine());
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        if(A == B && B == C){
            ans = 10000 + A * 1000;
        }else if( A== B || B == C || C == A){
            ans = 1000 + A * 100;
            if(B==C){
                ans = 1000 + B * 100;
            }
        }else if( A != B && B != C && C != A){
            mx = Math.max(A,B);
            mx = Math.max(mx,C);
            ans = mx * 100;
        }
        System.out.println(ans);
	}
}