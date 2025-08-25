import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int func(long k){
        int ret = 0;
        int cnt1 = 0; int cnt2 = 0;
        for(long i=2;i<=k;i*=2){
            cnt1 += (k/i);
        }
        for(long i=5;i<=k;i*=5){
            cnt2 += (k/i);
        }
        ret = Math.min(cnt1,cnt2);
        return ret;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            long k = Long.parseLong(br.readLine());
            System.out.println(func(k));
        }
		
	}
}