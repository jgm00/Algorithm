import java.util.*;
import java.io.*;

public class Main {
    static String[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static HashSet<String> set = new HashSet<>();
    static void dfs(int k, int curx, int cury, String str){
        if(k == 5) {
            set.add(str);
            return;
        }
        for(int dir = 0; dir<4; dir++){
            int nx = dx[dir] + curx;
            int ny = dy[dir] + cury;
            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            dfs(k+1, nx, ny, str+board[nx][ny]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new String[5][5];
        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5; j++){
                board[i][j] = st.nextToken();
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(0,i,j,board[i][j]);
            }
        }
        System.out.println(set.size());
    }
}
