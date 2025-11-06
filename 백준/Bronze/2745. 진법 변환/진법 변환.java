import java.util.*;
import java.io.*;

public class Main
{
    static String N;
    static int B, sm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		for(int i=N.length()-1;i>=0;i--){
		    char c = N.charAt(i);
		    int k = 0;
		    if('A' <= c && c <= 'Z'){
		        k = c - 'A' + 10;
		    }else{
		        k = c - '0';
		    }
		    sm += k * Math.pow(B,(N.length()-1-i));
		}
		System.out.println(sm);
	}
}