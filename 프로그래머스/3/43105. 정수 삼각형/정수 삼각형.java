import java.util.*;
import java.io.*;

class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<n;i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for(int j=1;j<triangle[i].length-1; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
            dp[i][triangle[i].length-1] = triangle[i][triangle[i].length-1] + dp[i-1][triangle[i-1].length-1];
        }
        answer = Integer.MIN_VALUE;
        for(int j=0;j<n;j++){
            answer = Math.max(answer, dp[n-1][j]);
        }
        return answer;
    }
}