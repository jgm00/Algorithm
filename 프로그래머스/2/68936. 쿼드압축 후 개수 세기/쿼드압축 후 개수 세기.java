import java.util.*;
import java.io.*;

class Solution {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        Pair add(Pair other){
            return new Pair(x+other.x, y+other.y);
        }
    }
    static Pair dfs(int offset, int x, int y, int[][] arr){
        int st = arr[x][y];
        int off = offset/2;
        if(offset == 1){
            if(st == 1){
                return new Pair(0,1);
            }
            return new Pair(1,0);
        }
        for(int i=x;i<x+offset;i++){
            for(int j=y;j<y+offset;j++){
                if(arr[i][j] != st){
                    return dfs(off,x,y,arr).add(dfs(off,x,y+off,arr)).add(dfs(off,x+off,y,arr)).add(dfs(off,x+off,y+off,arr));
                }
            }   
        }
        if(st == 1){
           return new Pair(0,1);
        }else{
            return new Pair(1,0); 
        }
           
    }
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        Pair p = dfs(arr.length,0,0,arr);
        answer[0] = p.x;
        answer[1] = p.y;
        return answer;
    }
}