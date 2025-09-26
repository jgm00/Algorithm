import java.util.*;
import java.io.*;

class Solution {
    static class Pair{
        long x,y;
        Pair(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static Pair cal(long a, long b, long e, long c, long d, long f){
        if(a*d == b*c){
            return null;
        }
        double x = (double) (b*f - e*d) / (a*d - b*c);
        double y = (double) (e*c - a*f) / (a*d - b*c);
        if(x % 1 != 0 || y % 1 != 0) return null;
        return new Pair( (long) x, (long) y);
    }
    static ArrayList<Pair> points = new ArrayList<>();
    static char[][] board;
    public String[] solution(int[][] line) {
        String[] answer = {};
        for(int i=0;i<line.length;i++){
            for(int j=(i+1); j<line.length;j++){
                Pair p = cal(line[i][0],line[i][1],line[i][2], line[j][0], line[j][1],line[j][2]);
                if(p != null){
                    points.add(p);
                }
            }
        }
        long mxx = Long.MIN_VALUE; long mnx = Long.MAX_VALUE;
        long mxy = Long.MIN_VALUE; long mny = Long.MAX_VALUE;
        for(int i=0;i<points.size();i++){
            long x = points.get(i).x; long y = points.get(i).y;
            mxx = Math.max(x,mxx); mnx = Math.min(mnx,x);
            mxy = Math.max(y,mxy); mny = Math.min(mny,y);
        }
        int dx = (int) (mxx-mnx+1);
        int dy = (int) (mxy-mny+1);
        board = new char[dy][dx];
        for(int i=0;i<dy;i++){
            Arrays.fill(board[i],'.');
        }
        for(int i=0;i<points.size();i++){
            long x = points.get(i).x; long y = points.get(i).y;
            board[(int) (mxy-y)][(int) (x - mnx)] = '*';
        }
        answer = new String[dy];
        for(int i=0;i<dy;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<dx;j++){
                sb.append(board[i][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}