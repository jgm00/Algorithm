import java.util.*;
import java.io.*;

class Solution {
    static int Lx, Ly, Ex, Ey;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static char[][] board;
    static int[][] vis;
    static int N,M;
    static Queue<Pair> q = new LinkedList<>();
    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int dir = 0; dir<4; dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] == 'X' || vis[nx][ny] != 0) continue;
                vis[nx][ny] = vis[p.x][p.y] + 1;
                q.add(new Pair(nx,ny));
            }
        }
    }
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        board = new char[N][M];
        vis = new int[N][M];
        for(int i=0;i<N;i++){
            String s = maps[i];
            for(int j=0;j<M;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'S'){
                    vis[i][j] = 1;
                    q.add(new Pair(i,j));
                }else if(board[i][j] == 'L'){
                    Lx = i;
                    Ly = j;
                }else if(board[i][j] == 'E'){
                    Ex = i;
                    Ey = j;
                }
            }
        }
        bfs();
        if(vis[Lx][Ly] != 0){
            answer = vis[Lx][Ly] - 1;
            q.add(new Pair(Lx,Ly));
            vis = new int[N][M];
            vis[Lx][Ly] = 1;
            bfs();
            if(vis[Ex][Ey] == 0){
                answer = -1;
            }else{
                answer += vis[Ex][Ey] - 1; 
            }
        }else{
            answer = -1;            
        }
        return answer;
    }
}