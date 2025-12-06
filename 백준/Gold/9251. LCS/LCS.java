import java.io.*;
import java.util.*;

public class Main
{
    static int[][] LCS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        LCS = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if(c1==c2){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }else{
                    LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
                }
            }
        }
        System.out.println(LCS[s1.length()][s2.length()]);
	}
}