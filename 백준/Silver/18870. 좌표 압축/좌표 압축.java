import java.io.*;
import java.util.*;

public class Main
{   
    static int N;
    static int[] arr, arr2;
    static HashMap<Integer, Integer> hmap = new HashMap<>();
    static int[] ans;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr2 = new int[N];
        ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            arr2[i] = k;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        int start = arr[0];
        int cnt =0;
        for(int i=0;i<N;i++){
            if(start != arr[i]){
                hmap.put(start,cnt);
                cnt+=1;
                start = arr[i];
            }
        }
        hmap.put(start,cnt);
        for(int i=0;i<N;i++){
            sb.append(hmap.get(arr2[i])).append(" ");
        }
        System.out.println(sb.toString());
	}
}