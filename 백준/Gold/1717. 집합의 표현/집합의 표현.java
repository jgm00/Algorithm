import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int[] p;
    static int[] r;
    static int find(int x){
        if(p[x] == -1) return x;
        return p[x] = find(p[x]);
    }
    static void merge(int a, int b){
        a = find(a); 
        b = find(b);
        if(a==b) return;
        if(r[a] < r[b]){
            p[a] = b;
        }else{
            p[b] = a; 
            if(r[a] == r[b]){
                r[a]++;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
        r = new int[N+1];
		Arrays.fill(p,-1);
		for(int i=1;i<=M;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    if(a == 0){
		        merge(b,c);
		    }else{
		        if(find(b)==find(c)){
		            System.out.println("YES");
		        }else{
		            System.out.println("NO");
		        }
		        
		    }
		}
	}
}