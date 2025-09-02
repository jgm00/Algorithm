import java.util.*;
import java.io.*;

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
    static Pair[] alist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		alist = new Pair[N+2];
		alist[0] = new Pair(0,0);
		for(int i=1;i<N+1;i++){
		  StringTokenizer st = new StringTokenizer(br.readLine());
		  int a = Integer.parseInt(st.nextToken());
		  String s = st.nextToken();
		  String[] ss = s.split(":");
		  int b = (Integer.parseInt(ss[1]) + Integer.parseInt(ss[0]) * 60);
		  alist[i] = new Pair(a,b);
		}
		alist[N+1] = new Pair(0, 48*60);
		int cnt1 = 0; int cnt2 = 0;
		int ans1 = 0; int ans2 = 0;
        for(int i=1;i<N+2;i++){
            if(cnt1 < cnt2){
                ans2 += (alist[i].y - alist[i-1].y);  
            }
            if(cnt1 > cnt2){
                ans1 += (alist[i].y - alist[i-1].y); 
            }
            Pair p = alist[i];
            
            if(p.x == 1){
                cnt1 += 1;}
            if(p.x == 2){
                cnt2 += 1;
            }
            
        }
        String h1q = "";
        int h1 = ans1 / 60; int m1 = ans1 % 60;
        if(h1 < 10){
            h1q = "0" + Integer.toString(h1);
        }else{
            h1q = Integer.toString(h1);
        }
        if(ans1 % 60 < 10){
            h1q += ":0" + Integer.toString(m1);
        }else{
            h1q += ":" + Integer.toString(m1);
        }
        String h2q = "";
        int h2 = ans2 / 60; int m2 = ans2 % 60;
        if(h2 < 10){
            h2q = "0" + Integer.toString(h2);
        }else{
            h2q = Integer.toString(h2);
        }
        if(ans2 % 60 < 10){
            h2q += ":0" + Integer.toString(m2);
        }else{
            h2q += ":" + Integer.toString(m2);
        }
        System.out.println(h1q);
        System.out.println(h2q);
    }
}