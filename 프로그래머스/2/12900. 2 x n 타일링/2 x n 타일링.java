import java.util.*;
import java.io.*;

class Solution {
    static int[] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2]; 
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}