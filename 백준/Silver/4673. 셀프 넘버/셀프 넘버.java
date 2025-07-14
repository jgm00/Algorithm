import java.util.*;
import java.io.*;

public class Main
{   
    static int selfnum(int a){
        int ans = a;
        while(a > 0){
            ans += (a % 10);
            a/=10;
        }
        return ans;
    }
    static HashSet<Integer> hset = new HashSet<>();
    static ArrayList<Integer> alist = new ArrayList<>();
	public static void main(String[] args) throws IOException {
	    for(int i=1;i<=10000;i++){
	        if(selfnum(i)<=10000){
	        hset.add(selfnum(i));}
	    }
	    for(int i=1;i<=10000;i++){
	       if(hset.contains(i) == false){
	           System.out.println(i);
	           }
	    }
	}
}