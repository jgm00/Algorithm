import java.util.*;
import java.io.*;

public class Main
{   
    static void func1(int k, int curx, int cury){
        if(k == 0 || k == 2){
        if(board[curx][cury] == 2 || board[curx][cury] == 3){
                    board[curx][cury] = 3;
                }else{
                    board[curx][cury] = 1;
                }
    }else if(k == 1 || k == 3){
            if(board[curx][cury] == 1|| board[curx][cury] == 3){
                    board[curx][cury] = 3;
                }else{
                    board[curx][cury] = 2;
                }
        }
    }
    static int[][] board;
    static char[][] ans;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static HashMap<Character, Integer> hmap = new HashMap<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        hmap.put('U', 2); hmap.put('D',0 ); hmap.put('R', 1); hmap.put('L', 3);
        board = new int[N][N];
        ans = new char[N][N];
        int curx = 0; int cury = 0;
        for(int C =0;C<s.length();C++){
            char c = s.charAt(C);
            int k = hmap.get(c);
                int nx = curx+dx[hmap.get(c)];
                int ny = cury+dy[hmap.get(c)];
                if(nx >= N || nx <0 ||ny >=N || ny < 0 ){
                    continue;
                }
                func1(k, curx, cury);
                curx=nx; cury = ny;
                func1(k, curx, cury);       
        }
	   
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++){
                if(board[i][j] == 1){
                    ans[i][j] = '|';
                }else if(board[i][j] == 2){
                     ans[i][j] = '-';
                }else if(board[i][j] == 3){
                     ans[i][j] = '+';
                }else{
                     ans[i][j] = '.';
                }
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
        
	}
}