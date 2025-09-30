import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int mn = Integer.MAX_VALUE;
    static char[][] board, temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                board[i][j] = s.charAt(j);
            }
        }
        for(int i=0;i<=(1<<N)-1;i++){
            int ans = 0;
            for(int k = 0; k<N; k++){
                int tCnt =0; int rtCnt = 0;
                for(int j=0;j<N;j++){
                    char c = board[k][j];
                    if((i&(1<<j)) != 0){
                        if(c == 'T'){
                            tCnt += 1;
                        }else{
                            rtCnt += 1;
                        }
                    }else{
                        if(c == 'H'){
                            tCnt += 1;
                        }else{
                            rtCnt += 1;
                        }
                    }
                }
                ans += Math.min(tCnt, rtCnt);
            }
            mn = Math.min(mn, ans);
        }
        System.out.println(mn);
	}
}