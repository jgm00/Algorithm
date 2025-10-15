import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static boolean func(String[][] park, int k){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(func2(park,i,j,k) == true){
                    return true;
                };
            }
        }
        return false;
    }
    static boolean func2(String[][] board, int a, int b, int K){
        if(b+K > M) return false;
        if(a+K > N) return false;
        for(int i = a; i<a+K;i++){
            for(int j = b; j<b+K;j++){
                if(board[i][j].equals("-1") == false){
                    return false;
                }
            }   
        }
        return true;
    }
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        N = park.length;
        M = park[0].length;
        for(int i=mats.length-1; i>=0;i--){
            if(func(park,mats[i]) == true){
                answer = mats[i];
                return answer;
            }
        }
        return -1;
    }
}