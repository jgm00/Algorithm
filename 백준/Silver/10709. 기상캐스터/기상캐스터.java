import java.util.*;
import java.io.*;

public class Main
{
    static int W,H;
    static char[][] board;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new char[W][H];
        for(int i=0;i<W;i++){
            int tmp = -1;
            int flag = 0;
            String s = br.readLine();
            for(int j=0;j<H;j++){
                if(s.charAt(j) == 'c'){
                    tmp = 0;
                    flag = 1;
                }else if(flag == 1){
                    tmp+=1;
                }
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
	}
}