import java.util.*;
import java.io.*;

public class Main {
    static String S,T;
    static int ans = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        while(true){
            if(T.length()==S.length()){
                if(T.equals(S)){
                    ans = 1;
                }
                break;
            }else if(T.length() < S.length()){
                break;
            }
            char c = T.charAt(T.length()-1);
            if(c == 'B'){
                sb = new StringBuilder();
                sb.append(T.substring(0,T.length()-1)).reverse();
                T = sb.toString();
            }else if(c== 'A'){
                T = T.substring(0,T.length()-1);
            }
        }
        System.out.println(ans);
    }
}

