import java.io.*;
import java.util.*;


public class Main
{
    static int N,M,T;
    static int[] num;
    static int[] pri;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Pair> q = new LinkedList<>(); 
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            q = new LinkedList<>(); 
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            pri = new int[10];
            num = new int[N];
            for(int i=0;i<N;i++){
                num[i] = Integer.parseInt(st.nextToken());
                q.add(new Pair(num[i],i));
                pri[num[i]] += 1;
            }
            int cnt = 0;
            while(!q.isEmpty()){
                Pair p = q.poll();
                int flag = 0;
                for(int i=p.x+1; i<10; i++){
                    if(pri[i] != 0){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    q.add(p);
                }else{
                    cnt+=1;
                    pri[p.x] -=1;
                    if(p.y == M){
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
        
        
	}
}