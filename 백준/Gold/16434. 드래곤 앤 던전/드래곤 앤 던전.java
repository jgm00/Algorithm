import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static long HATK_INIT, HATK, HP, HCUR;
    static class Pair{
        int x;
        long y,z;
        Pair(int x, long y, long z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static Pair[] p;
    static boolean cal(long a, long h){
        long hit = (h + HATK - 1) / HATK;
        long damage =(hit - 1) * a;
        if(HCUR > damage){
            HCUR -= damage;
            return true;
        }
        return false;
    }
    
    static void cal2(long a, long h){
        HCUR = Math.min(h+HCUR,HP);
        HATK = HATK + a;
    }
    
    static boolean cal3(){
        HCUR = HP;
        HATK = HATK_INIT;
        for(Pair ps : p){
            int t = ps.x;
            long a = ps.y;
            long h = ps.z;
            if(t == 1){
                if(cal(a,h)==false){
                    return false;
                }
		    }else if(t == 2){
		        cal2(a,h);
		    }
        }
        return true;
    }
    
    static long binarySearch(long l, long r){
        long ans = r;
        while(l <= r){
            long mid = (l+r) >>> 1;
            HP = mid;
            if(cal3() == true){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		HATK_INIT = Long.parseLong(st.nextToken());
		p = new Pair[N];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    int t = Integer.parseInt(st.nextToken());
		    long a = Long.parseLong(st.nextToken());
		    long h = Long.parseLong(st.nextToken());
		    p[i] = new Pair(t,a,h);
		}
		System.out.println(binarySearch(0,(long)1e18));
	}
}