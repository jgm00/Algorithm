import java.util.*;
import java.io.*;

class Solution {
    static int[] arr;
    static int[] vis;
    static int MyN, cnt;
    static void dfs(int k, int[] number){
        if(k == 3){
            int sm = 0;
            for(int i=0;i<3;i++){
                sm += number[arr[i]];
            }
            if(sm == 0){
                cnt += 1;
            }
            return;
        }
        int st = k-1;
        if(k == 0){
            st = 0;            
        }
        for(int i=arr[st];i<MyN;i++){
            if(vis[i] != 0) continue;
            arr[k] = i;
            vis[i] = 1;
            dfs(k+1,number);
            vis[i] = 0;
        }
    }
    public int solution(int[] number) {
        int answer = 0;
        MyN = number.length;
        arr = new int[3];
        vis = new int[MyN];
        dfs(0,number);
        return cnt;
    }
}