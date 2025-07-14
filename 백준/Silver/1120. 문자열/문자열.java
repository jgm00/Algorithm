import java.util.*;
import java.io.*;

public class Main
{   
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken(); String s2 = st.nextToken();
		int mn = s1.length();
		int cnt =0; int ans = 51;
		for(int i=0;i<s2.length()-mn+1; i++){
		    cnt = 0;
		    for(int j=0;j<mn;j++){
		    if(s2.charAt(i+j)!=s1.charAt(j)){
		        cnt+=1;
		    };
		} ans = Math.min(cnt,ans);
		}
		System.out.println(ans);
	}
}