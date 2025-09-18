import java.util.*;
import java.io.*;

class Solution {
    static int chk(int k){
        int ans = 0;
        while(k>0){
            if(k%2 == 1){
                ans += 1;
            }
            k/=2;
        }
        return ans;
    }
    public int solution(int n) {
        int answer = 0;
        int origin = chk(n);
        n+=1;
        while(true){
            if(origin==chk(n)){
                break;
            }
            n+=1;
        }
        return n;
    }
}