import java.util.*;
import java.io.*;

public class Main
{
    static int N, ans, len;
    static int[] num, lst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N]; lst = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++){
		    int pos = Arrays.binarySearch(lst, 0, len, num[i]);
		    if(pos < 0 ) pos = -pos -1;
		    lst[pos] = num[i];
		    if(pos == len) len += 1;
		}
		System.out.println(len);
	}
}