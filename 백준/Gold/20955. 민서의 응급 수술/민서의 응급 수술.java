import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int[] p,r;
    static int find(int x){
        if(x==p[x]){
            return x;
        }
        return p[x] = find(p[x]);
    }
    static boolean union(int a, int b){
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cnt = 0;
        p = new int[N+1];
        r = new int[N+1];
        for(int i=1;i<=N;i++){
            p[i] = i;
        }
        for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
            if(union(u,v) == false){
                cnt += 1;
            }
		}
        int Ccnt = 0;
        for(int i=1;i<=N;i++){
            if(find(i) == i){
                Ccnt += 1;
            }
        }
        System.out.println(Ccnt - 1 + cnt);
	}
}