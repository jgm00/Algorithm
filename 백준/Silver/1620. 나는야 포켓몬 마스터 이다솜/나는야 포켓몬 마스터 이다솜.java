import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static HashMap<String, Integer> hmap = new HashMap<>();
    static HashMap<Integer, String> hmap2 = new HashMap<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            String s = br.readLine();
            hmap.put(s,(i+1));
            hmap2.put((i+1),s);
        }
        for(int i=0;i<M;i++){
            String s = br.readLine();
            char c = s.charAt(0);
            if('0' <= c && c <= '9'){
                int k = Integer.parseInt(s);
                System.out.println(hmap2.get(k));
            }else{
                System.out.println(hmap.get(s));
            }
        }
	}
}