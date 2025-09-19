import java.util.*;
import java.io.*;

public class Main
{
    static HashSet<String> hset = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0;i<s.length();i++){
		    String str = "";
		       	for(int j=i;j<s.length()+1;j++){
		        str = s.substring(i,j);
		        hset.add(str); 
		    }
		}
		System.out.println(hset.size()-1);
	}
}