import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        N = board.length; M = board[0].length;
        for(int dir = 0; dir<4; dir++){
            int nx = dx[dir] + h;
            int ny = dy[dir] + w;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(board[nx][ny].equals(board[h][w])){
                answer +=1;
            }
        }
        return answer;
    }
}