import java.util.*;
import java.io.*;

class Solution {
    static HashSet<Integer> hset = new HashSet<>();
    public int solution(int[] elements) {
        int answer = 0;
        int sz = elements.length;
        for(int d = 1; d<=sz;d++){
            for(int j=0;j<sz;j++){
                int sm = 0;
                for(int k=j;k<j+d;k++){
                    sm += elements[(k%sz)];
                }
                hset.add(sm);
            }
        }
        return hset.size();
    }
}

