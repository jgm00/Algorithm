import java.util.*;
import java.io.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long ms = Long.MAX_VALUE;
        int flag = 0;
        for(int i=0;i<ms;i++){
            int chks = 0;
            String s = Integer.toString(i);
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '6'){
                    chks += 1;
                }else{
                    chks = 0;
                }
                if(chks >= 3){
                    flag += 1;
                    break;
                }
            }
            if(s.charAt(s.length()-1) == '6'){
                chks += 1;
            }
            
            if(flag == N){
                System.out.println(i);
                break;
            }
        }
        
	}
}