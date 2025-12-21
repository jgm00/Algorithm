import java.util.*;
import java.io.*;

public class Main
{
    static int a,b,c,mxx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            boolean flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
            if(a==0 && b == 0 && c == 0){
                break;
            }
            mxx = Math.max(a,b);
            mxx = Math.max(mxx,c);
            if(mxx==a){
                if(a < (b+c)){
                    flag = true;
                }
            }else if(mxx==b){
                if(b < (a+c)){
                    flag = true;
                }
            }else if(mxx==c){
                if(c < (b+a)){
                    flag = true;
                }
            }
            if(flag == true){
                if(a==b && b== c && c==a){
                    System.out.println("Equilateral");
                }else if((a==b && b!=c) || (a==c && c!=b) || (b==c && b!=a)){
                    System.out.println("Isosceles");
                }else if(a!=b&&b!=c&&c!=a){
                    System.out.println("Scalene");
                }
            }else{
                System.out.println("Invalid");
            }
        }
        
	}
}