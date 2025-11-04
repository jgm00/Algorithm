import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		System.out.println(num[(N-1)/2]);
	}
}