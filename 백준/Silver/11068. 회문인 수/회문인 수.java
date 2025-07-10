import java.util.*;
import java.io.*;

public class Main
{   
    static int T,N,B;
    static String bi(int k, int b){
        String ans = "";
        while(k>0){
            int temp = k%b;
            if(temp >= 10){
                ans += (char)(temp - 10 + 'A');
            }else{
                ans+= temp;
            }
            k/=b;
        }
        String revans = "";
        for(int i =ans.length()-1; i>=0; i--){
            revans += ans.charAt(i);
        }
        return revans;
    }
    static Boolean check(String s){
        String revs = "";
        for(int i =s.length()-1; i>=0; i--){
            revs += s.charAt(i);
        }
        if(s.equals(revs)){
            return true;
        }
        return false;
    }
    static int flag = 0;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    for(int tc = 0; tc <T; tc++){
	        flag = 0;
	        N = Integer.parseInt(br.readLine());
	        for(int i =2;i<65; i++){
	            if(check(bi(N,i))){
	                flag = 1;
	                break;
	            }
	        }
	    	    if(flag == 1){
	        System.out.println("1");
	    }else{
	        System.out.println("0");
	    }
	        
	    }
	}
}