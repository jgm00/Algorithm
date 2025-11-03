import java.util.*;
import java.io.*;

public class Main
{
    static int N, ans, mx, len;
    static int[] num, lst, prev,idx;
    static ArrayList<Integer> anss = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N]; lst = new int[N]; prev = new int[N];
		idx = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Arrays.fill(prev,-1);
		for(int i=0;i<N;i++){
		    num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            int pos = Arrays.binarySearch(lst,0,len,num[i]);
            if(pos < 0) pos = -pos-1;
            lst[pos] = num[i];
            idx[pos] = i;
            if(pos > 0) prev[i] = idx[pos-1];
            if(pos == len) len +=1;
        }
        int t = idx[len-1];
        while(t != -1){
            anss.add(num[t]);
            t = prev[t];
        }
        System.out.println(len);
        for(int i=anss.size()-1;i>=0;i--){
            System.out.print(anss.get(i) + " ");
        }
	}
}