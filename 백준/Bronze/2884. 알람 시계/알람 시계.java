import java.util.*;
import java.io.*;

public class Main
{
    static int H,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	StringTokenizer st = new StringTokenizer(br.readLine());
	    H = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
        M -= 45;
        if(M < 0){
            H -= 1;
            M += 60;
        }
        if(H < 0){
            H += 24;
        }
        System.out.println(H + " " + M);
	}
}