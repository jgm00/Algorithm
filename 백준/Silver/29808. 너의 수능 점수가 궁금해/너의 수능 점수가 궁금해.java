import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int sm, diff1, diff2;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static HashSet<String> hset = new HashSet<>();
    static ArrayList<Pair> alst = new ArrayList<>();
    static void cal(int k, int d1){
        int tmp = N - k*d1;
        if(tmp % 305  == 0){
            diff2 = tmp / 305;
            diff1 = k;
            if(diff2 <= 200 && diff2 >= 0){
                if(!hset.contains((diff1 +","+diff2))){
                    alst.add(new Pair(diff1,diff2));
                    hset.add((diff1+","+diff2));
                }
            }
        }
        if(tmp % 212 == 0){
            diff2 = tmp / 212;
            diff1 = k;
            if(diff2 <= 200 && diff2 >= 0){
                if(!hset.contains((diff1 +","+diff2))){
                    alst.add(new Pair(diff1,diff2));
                    hset.add((diff1+","+diff2));
                }
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N % 4763 != 0){
		    System.out.println("0");
		    return;
		}
		N /= 4763;
		for(int i=0;i<=200;i++){
		    cal(i,508);
		    cal(i,108);
		}
		Collections.sort(alst,(o1,o2)->{
		    if(o1.x==o2.x){
		        return o1.y - o2.y;
		    }
		    return o1.x - o2.x;
		});
		System.out.println(alst.size());
		for(Pair p : alst){
		    System.out.println(p.x + " " + p.y);
		}
	}
}