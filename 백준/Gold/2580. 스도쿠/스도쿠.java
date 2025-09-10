import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean isOkay(int x, int y, int cur){
        for(int j=0;j<9;j++){
            if(board[x][j] == cur){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(board[i][y] == cur){
                return false;
            }
        }

        int fx = (x/3)*3;
        int fy = (y/3)*3;

        for(int i = fx; i<fx+3;i++){
            for(int j=fy; j<fy+3; j++){
                if(board[i][j] == cur){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean dfs(int k){
        if(k==81){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        int curx = k/9;
        int cury = k%9;

        if(board[curx][cury] != 0){
            return dfs(k+1);
        }

        for(int i=1;i<=9;i++){
            if(isOkay(curx,cury,i)){
                board[curx][cury] = i;
                if(dfs(k+1)){
                    return true;
                }
                board[curx][cury] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
    }
}
