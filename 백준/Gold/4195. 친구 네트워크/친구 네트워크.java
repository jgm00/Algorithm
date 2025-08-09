import java.util.*;
import java.io.*;

public class Main
{
    static int T,F;
    static int[] r,p;
    static HashMap<String, Integer> hmap;
    static int find(int x){
        if(p[x] == -1) return x;
        return p[x] = find(p[x]);
    }
    static void merge(int a, int b){
        a = find(a); b = find(b);
        if(a==b) return;
        if(r[a]<r[b]){
            p[a] = b;
            r[b] += r[a];
        }else{
            p[b] = a;
            r[a]+=r[b];
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0){
		    F = Integer.parseInt(br.readLine());
		    hmap = new HashMap<>();
		    p = new int[200001];
		    r = new int[200001];
		    Arrays.fill(r,1);
		    Arrays.fill(p,-1);
		    int idx = 1;
		    for(int i=0;i<F;i++){
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        String s1 = st.nextToken();
		        String s2 = st.nextToken();
		        int si1 = 0; int si2 = 0;
                if(!hmap.containsKey(s1)){
                    hmap.put(s1, idx);
                    idx+=1;
                }
                if(!hmap.containsKey(s2)){
                    hmap.put(s2, idx);
                    idx+=1;
                }
                si1 = hmap.get(s1); si2 = hmap.get(s2);
                merge(si1,si2);
                if(find(si1)==find(si2)){
                    System.out.println(r[find(si1)]);
                }
            }
        }
	}
}