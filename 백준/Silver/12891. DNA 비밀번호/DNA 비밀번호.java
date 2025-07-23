import java.util.*;
import java.io.*;


public class Main
{
    static int[] arr;
    static int[] tmp;
    static int N,P;
    static boolean check(){
        for(int i=0;i<4;i++){
            if(arr[i] > tmp[i]){
                return false;
            }
        }
        return true;
    }
    static HashMap<Character, Integer> hmap = new HashMap<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        hmap.put('A',0); hmap.put('C',1); hmap.put('G',2); hmap.put('T',3); 
        String s = br.readLine();
        arr = new int[4];
        tmp = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0; int r = P-1;
        for(int i=0;i<P;i++){
            tmp[hmap.get(s.charAt(i))] += 1;
        }
        int ans =0;
        if(check()){
            ans ++;
        }
        while(r < N-1){
            r +=1;
            tmp[hmap.get(s.charAt(l))] -= 1;
            l += 1;
            tmp[hmap.get(s.charAt(r))] += 1;
            if(check()){
                ans ++;
            }
        }
        System.out.println(ans);
	}
}
