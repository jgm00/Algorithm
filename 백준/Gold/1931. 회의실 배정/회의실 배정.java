import java.io.*;
import java.util.*;

public class Main
{   
    static int N;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Pair[] pair;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pair = new Pair[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pair[i] = new Pair(a,b);
        }
        Arrays.sort(pair, (o1,o2) -> {
            if(o1.y==o2.y){
                return o1.x - o2.y;
            }
           return o1.y - o2.y; 
        });
        int cnt =1;
        int start = pair[0].y;
        for(int i=1;i<N;i++){
            if(start <= pair[i].x){
                cnt+=1;
                start = pair[i].y;
            }
        }
        System.out.println(cnt);
	}
}