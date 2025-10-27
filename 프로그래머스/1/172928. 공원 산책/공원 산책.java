import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M;
    static int curx = 0; static int cury = 0;
    static HashMap<String, Integer> hmap = new HashMap<>();
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static char[][] board;
    static boolean chk(int x, int y, int k, int dir){
        for(int i =1; i<=k;i++){
            int nx = i*dx[dir] + x;
            int ny = i*dy[dir] + y;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(board[nx][ny] == 'X'){
                return false;
            }
        }
        return true;
    }
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        N = park.length;
        M = park[0].length();
        hmap.put("S",0); hmap.put("E",1); hmap.put("N",2); hmap.put("W",3);
        board = new char[N][M];
        for(int i=0;i<N;i++){
            String str = park[i];
            for(int j=0;j<M;j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'S'){
                    curx = i; cury =j;
                }
            }
        }
        for(int i=0;i<routes.length;i++){
            String[] strs = routes[i].split(" ");
            int dir = hmap.get(strs[0]);
            int k = Integer.parseInt(strs[1]);
            int nx = curx + k*dx[dir];
            int ny = cury + k*dy[dir];
            if(chk(curx,cury,k,dir) == false) continue;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            curx = nx; cury = ny;
        }
        answer[0] = curx;
        answer[1] = cury;
        return answer;
    }
}