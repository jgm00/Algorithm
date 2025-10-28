import java.util.*;
import java.io.*;

class Solution {
    static int[] mtimes;
    static long cal(long k){
        long sm = 0;
        for(int i=0;i<mtimes.length;i++){
            sm += (k/mtimes[i]);
        }
        return sm;
    }
    static long ans;
    static void bin(long l, long r, int tar){
        ans = 0;
        while(l <= r){
            long mid = (l+r) / 2;
            if(cal(mid) >= tar){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
    }
    public long solution(int n, int[] times) {
        long answer = 0;
        long mx = -1;
        mtimes = new int[times.length];
        for(int i=0;i<times.length;i++){
            mx = Math.max(times[0],mx);
            mtimes[i] = times[i];
        }
        bin(0l,mx*n,n);
        return ans;
    }
}