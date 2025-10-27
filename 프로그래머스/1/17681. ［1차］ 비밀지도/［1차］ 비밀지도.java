import java.util.*;
import java.io.*;

class Solution {
    static int[][] board;
    static int N;
    static void cal(int[] arr){
        for(int i=0;i<N;i++){
            for(int j=0; j<N;j++){
                if((arr[i]&1<<j)!= 0){
                    board[i][N-1-j] = 1;
                }
            }
        }
    }
    static StringBuilder sb = new StringBuilder();
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        N = n;
        board = new int[n][n];
        cal(arr1);
        cal(arr2);
        for(int i=0;i<N;i++){
            sb = new StringBuilder();
            for(int j=0;j<N;j++){
                if(board[i][j] == 1){
                   sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}