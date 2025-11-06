import java.util.*;
import java.io.*;

public class Main
{
    static int N,num;
    static int[] mon = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mon[0] = 25; mon[1] = 10; mon[2] = 5; mon[3] = 1; 
        for(int i=0;i<N;i++){
            StringBuilder sb = new StringBuilder();
            num = Integer.parseInt(br.readLine());
            for(int j=0;j<4;j++){
                sb.append(num / mon[j]).append(" ");
                num %= mon[j];
            }
            System.out.println(sb.toString());
        }
	}
}