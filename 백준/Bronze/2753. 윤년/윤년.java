import java.util.*;
import java.io.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans = 0;
        if(N%4 == 0 && N % 100 != 0){
            ans = 1;
        }
        if( N % 400 == 0){
            ans = 1;
        }
        System.out.println(ans);
	}
}