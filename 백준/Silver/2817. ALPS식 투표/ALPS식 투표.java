import java.util.*;
import java.io.*;

public class Main
{   
    static int X,N;
    static class Pair{
        String x;
        int y;
        Pair(String x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Pair[] ar;
    static int[] arr;
    static int k = 0;
    static String[] name;
    static HashMap<Integer, Integer> hmap = new HashMap<>();
    static ArrayList<Integer> lst = new ArrayList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        name = new String[N];
        int cnt =0;
        HashSet<String> hset = new HashSet<>();
        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String na = st.nextToken();
            int kk = Integer.parseInt(st.nextToken());
            name[i] = na;
            if(kk>=(X*0.05)){
                cnt+=1;
            for(int b=1;b<=14;b++){
                lst.add(kk/b);
                hmap.put(kk/b, i);
        }}else{
            hset.add(na);
        }
        }
        arr = new int[N];
        ar = new Pair[cnt];

     Collections.sort(lst,Collections.reverseOrder());
     for(int i=0;i<14;i++){
         arr[hmap.get(lst.get(i))] += 1;
     }
    int idx =0;
     for(int i=0;i<N;i++){
         if(hset.contains(name[i])) continue;
         ar[idx++] = new Pair(name[i], arr[i]); 
     }
     Arrays.sort(ar,(o1,o2)->{

             return o1.x.compareTo(o2.x);

     });
     for(int i=0;i<cnt;i++){
         System.out.println(ar[i].x + " " + ar[i].y);
     }
	}
}