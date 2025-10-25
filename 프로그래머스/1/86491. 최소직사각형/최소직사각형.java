import java.util.*;
import java.io.*;

class Solution {
    static int mxw = -1;
    static int mxh = -1;
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        for(int i=0;i<sizes.length;i++){
            mxw = Math.max(mxw,sizes[i][0]);
            mxh = Math.max(mxh,sizes[i][1]);
        }
        return mxh*mxw;
    }
}