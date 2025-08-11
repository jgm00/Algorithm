import java.util.*;
import java.io.*;

public class Main
{   
    static int n,m;
    static int[] p,r;
	static int find(int x){
	    if(p[x] == x) return x;
	    return p[x] = find(p[x]);
	}
	static boolean merge(int a, int b){
	    a = find(a); b = find(b);
	    if(a==b) return false;
	    if(r[a] < r[b]){
	        p[a] = b;
	    }else{
	        p[b] = a;
	        if(r[a] == r[b]){
	            r[a]+=1;
	        }
	    }
	    return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    int ans = 0;
	    p = new int[n];
	    r = new int[n];
        for(int i=0;i<n;i++){
            p[i] = i;
        }
	    for(int i=0;i<m;i++){
	        st = new StringTokenizer(br.readLine());
	        int u1 = Integer.parseInt(st.nextToken());
	        int v1 = Integer.parseInt(st.nextToken());	
	        if(merge(u1,v1) == false){
	            ans = (i+1);
                break;
	        }

	    }
	    System.out.println(ans);
	    
	}
}