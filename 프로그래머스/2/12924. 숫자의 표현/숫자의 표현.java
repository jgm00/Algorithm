import java.util.*;
import java.io.*;

class Solution {
    static int N;
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            int sm = 0;
            for(int j=i;j<=n;j++){
                sm += j;
                if(sm == n){
                    answer += 1;
                    break;
                }
                if(sm > n){
                    break;
                }
            }
        }
        return answer;
    }
}