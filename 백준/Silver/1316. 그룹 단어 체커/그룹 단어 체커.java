import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] nums = new int[26];
    static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	    int flag = 0;
		for(int i=0;i<N;i++){
		    flag = 0;
		    nums = new int[26];
		    String s = br.readLine();
		    nums[s.charAt(0) - 'a'] = 1;
		    for(int j=1;j<s.length();j++){
		        int k = s.charAt(j) - 'a';
		        if(nums[k] == 1 && (s.charAt(j) != s.charAt(j-1))){
		            flag = 1;
		        }
		        nums[k] = 1;
		    }
		    if(flag == 0){
		        cnt += 1;
		    }
		}
		System.out.println(cnt);
	}
}