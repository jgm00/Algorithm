import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static int[][] vis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Integer> q = new LinkedList<>();
    static void bfs(int[][] board){
        while(!q.isEmpty()){
            int curx = q.poll();
            int cury = q.poll();
            for(int dir =0; dir < 4; dir++){
                int nx = dx[dir] + curx;
                int ny = dy[dir] + cury;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(vis[nx][ny] != 0 || board[nx][ny] == 0) continue;
                vis[nx][ny] = vis[curx][cury] + 1;
                q.add(nx);
                q.add(ny);
            }
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        vis = new int[N][M];
        vis[0][0] = 1;
        q.add(0); q.add(0);
        bfs(maps);
        answer = vis[N-1][M-1];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}