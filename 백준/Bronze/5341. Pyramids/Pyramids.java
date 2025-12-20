import java.util.*;
import java.io.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
		    N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int sm = 0;
            for(int i=1;i<=N;i++){
                sm += i;
            }
		    System.out.println(sm);
		}
	}
}