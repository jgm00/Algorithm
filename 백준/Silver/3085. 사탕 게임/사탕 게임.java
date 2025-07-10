import java.util.*;
import java.io.*;

public class Main
{   
    static char[][] board;
    static int N;
    static int mx = -1;
    static void changeRow(int x, int y){
        char temp = board[x][y];
        board[x][y] = board[x+1][y];
        board[x+1][y] = temp;
        checkRow();
        checkCol();
        board[x+1][y] = board[x][y];
        board[x][y] = temp;
    }
    static void changeCol(int x, int y){
        char temp = board[x][y];
        board[x][y] = board[x][y+1];
        board[x][y+1] = temp;
        checkRow();
        checkCol();
        board[x][y+1] = board[x][y];
        board[x][y] = temp;
    }
    static void checkRow(){
        int cnt = 0;
        for(int i =0; i<N; i++){
            cnt = 0;
            for(int j =1;j<N;j++){
                if(board[i][j-1] == board[i][j]){
                    cnt += 1;
                    
                }else{
                    mx = Math.max(cnt, mx);
                    cnt = 0;
                }
            }
            mx = Math.max(cnt, mx);
        }
    }
    static void checkCol(){
        int cnt = 0;
        for(int i =0; i<N; i++){
            cnt =0;
            for(int j =1;j<N;j++){
                if(board[j-1][i] == board[j][i]){
                    cnt += 1;
                }else{
                    mx = Math.max(cnt, mx);
                    cnt = 0;
                }
            }
            mx = Math.max(cnt, mx);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for(int i =0; i<N;i++){
		        String s = br.readLine();
		        for(int j=0; j<N; j++){
		            board[i][j] = s.charAt(j);
		        }
		    }
		 for(int i =0;i<N-1;i++){
		     for(int j =0 ;j<N;j++){
		         changeRow(i,j);
		        
		        }
		    }
		 for(int i =0;i<N;i++){
		     for(int j =0 ;j<N-1;j++){
		         changeCol(i,j);
		        }
		    }
		if(mx == 0){
		    System.out.println(mx);
		}else{
		     System.out.println(mx+1);
		}}
	}