import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] nums;
    static ArrayList<Integer> cal(int a){
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0;i<N;i++){
		    if((a&(1<<i)) != 0){
		        tmp.add((i+1));
		    }
		}
		return tmp;
    }
    static boolean chk(int am, int bm){
        ArrayList<Integer> a = cal(am);
        ArrayList<Integer> b = cal(bm);
        int len = Math.min(a.size(), b.size());
        for(int i=0;i<len;i++){
            if(!a.get(i).equals(b.get(i))){
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N][5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mp = Integer.parseInt(st.nextToken());
		int mf = Integer.parseInt(st.nextToken());
		int ms = Integer.parseInt(st.nextToken());
		int mv = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<5;j++){
		        nums[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int ansnum = 0;
		int a = 0; int b = 0; int c = 0; int d = 0; int e = 0;
		for(int i=0;i<=(1<<N)-1;i++){
		    a = 0; b = 0; c = 0; d = 0; e = 0;
		    for(int j=0;j<N;j++){
		        if((i&(1<<j)) != 0){
		            a += nums[j][0];
		            b += nums[j][1];
		            c += nums[j][2];
		            d += nums[j][3];
		            e += nums[j][4];
		        }
		    }
		    if(a >= mp && b >= mf && c >= ms && d >= mv){
                 if (e < ans) {                 
                        ans = e;
                        ansnum = i;
                    } else if (e == ans && chk(i, ansnum)) {
                        ansnum = i;               
                    }
		        ans = Math.min(ans, e);
		    }
		}
    	if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
		System.out.println(ans);
		for(int i=0;i<N;i++){
		    if((ansnum&(1<<i)) != 0){
		        System.out.print((i+1)+ " ");
		    }
		}
	}
}