import java.util.*;
import java.io.*;

public class Main
{
    static HashSet<String> hset = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0;i<s.length();i++){
		    for(int k=0;k<s.length();k++){
		        sb = new StringBuilder();
		       	for(int j=i;j<=k;j++){
		        sb.append(s.charAt(j));
		    }
		        hset.add(sb.toString()); 
		    }
		}
		System.out.println(hset.size()-1);
	}
}