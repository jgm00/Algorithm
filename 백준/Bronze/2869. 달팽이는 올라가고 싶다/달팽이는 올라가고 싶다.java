import java.util.*;
import java.io.*;

public class Main
{
    static int A, B, V;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int ans = ((V-B)/(A-B));
        if((V-B) % (A-B) == 0){
            System.out.println(ans);
        }else{
            System.out.println(ans + 1);
        }
	}
}