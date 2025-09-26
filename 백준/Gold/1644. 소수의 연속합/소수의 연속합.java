import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static ArrayList<Integer> pnum = new ArrayList<>();
    static boolean[] isP;
    static void isPrime(int k){
        isP = new boolean[k+1];
        Arrays.fill(isP, true);
        isP[0] = false; isP[1] = false;
        for(int i=2;i<=Math.sqrt(k);i++){
            if(isP[i]){
                for(int j=i*i; j<=k;j+=i){
                    isP[j] = false;
                }
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N < 2){
            System.out.println(0);
            return;
        }
        isPrime(N);
	    for(int i=2;i<=N;i++){
	        if(isP[i] == false) continue;
	        pnum.add(i);
	    }	
	    int ans = 0;
		int st = 0; int en = 1; int sm = pnum.get(0);
		while(true){
            if(sm >= N){
                if(sm == N) ans+=1;
                sm -= pnum.get(st++);
            }else if(en == pnum.size()){
                break;
            }else{
                sm += pnum.get(en++);
            }
		}
		System.out.println(ans);
	}
}