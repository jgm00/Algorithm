import java.io.*;
import java.util.*;

public class Main
{   
    static int N,C;
    static Pair[] arr;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static HashMap<Integer, Pair> hmap = new HashMap<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int k = Integer.parseInt(st.nextToken());
            if(hmap.containsKey(k)){
                hmap.put(k, new Pair(hmap.get(k).x+1, hmap.get(k).y));
            }else{
                hmap.put(k, new Pair(1, i));
            }
        }
        List<Map.Entry<Integer, Pair>> list = new ArrayList<>(hmap.entrySet());
        Collections.sort(list, (o1,o2)->{
            if(o1.getValue().x==o2.getValue().x){
                return o1.getValue().y - o2.getValue().y;
            }
            return o2.getValue().x - o1.getValue().x;
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<(list.get(i).getValue().x);j++){
                sb.append(list.get(i).getKey()).append(" ");
        }}
        System.out.println(sb.toString());
	}
}