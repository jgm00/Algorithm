import java.util.*;
import java.io.*;

public class Main
{
    static int N,B;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        while(N > 0){
            if(N%B >= 10){
                sb.append((char) (N%B + 55));
            }else{
                sb.append(N%B);
            }
            N/=B;
        }
        String s = sb.toString();
        for(int i = s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
	}
}