import java.util.*;
import java.io.*;

public class Main
{
    static int a,b,c,mxx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
        mxx = Math.max(a,b);
        mxx = Math.max(mxx,c);
        if(mxx==a){
            if(a > (b+c)-1){
                a = (b+c)-1;
            }
        }else if(mxx==b){
            if(b > (a+c)-1){
                b = (a+c)-1;
            }
        }else if(mxx==c){
            if(c > (b+a)-1){
               c = (b+a)-1;
            }
        }
        System.out.println(a+b+c);
	}
}