import java.util.*;
import java.io.*;

public class Main
{   
    static int N,K;
    static String[] ans;
	static int flag = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int idx =0;
        HashMap<String, Integer> hmap = new HashMap<>();
        ans = new String[N];
        Arrays.fill(ans,"?");
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            int temp = idx - move;
            while(temp < 0){
                temp += N;
            }
            idx = temp % N;
            if(ans[idx].equals(c) == false && hmap.get(c) != null){
                flag = 1;
            }else if(ans[idx].equals("?") || ans[idx].equals(c)){
                ans[idx] = c;
                hmap.put(c,1);
            }else{
                flag = 1;
            }
        }
        if(flag == 1){
            System.out.println("!");
        }else{
        for(int i=0;i<N;i++){
            int k = (idx + i)%N;
            System.out.print(ans[k]);
        }
            
        }
	}
}