import java.io.*;
import java.util.*;

public class Main
{
    static int[][] LCS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int len1 = s1.length();
        int len2 = s2.length();
        LCS = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                if(c1 == c2){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }else{
                    LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
                }
            }
        }
        int i = len1; int j = len2;
        String ans = "";
        while(i > 0 && j > 0){
            char c1 = s1.charAt(i-1);
            char c2 = s2.charAt(j-1);
            if(c1==c2){
                ans = c1 + ans;
                i--; j--;
            }else{
                if(LCS[i-1][j] > LCS[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        System.out.println(LCS[len1][len2]);
        System.out.println(ans);
	}
}