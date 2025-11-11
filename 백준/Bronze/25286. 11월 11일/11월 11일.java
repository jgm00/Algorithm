import java.util.*;
import java.io.*;

public class Main
{
    static int T,Y,M;
    static int[] month = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    static boolean check(int y){   
        if(y%400 == 0){
            return true;
        }
        if(y%4==0){
            if(y % 100 == 0){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T -- > 0){
		    StringTokenizer st = new StringTokenizer(br.readLine());
    		Y = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		if(M==1){
    		    M = 13;
    		    Y -= 1;
    		}
    		int day = month[M-1];
    		if(M == 3){
    		    if(check(Y)){
    		        day += 1;
    		    }
    		}
    		System.out.println(Y + " " + (M-1) + " " + day);
		}
	}
}