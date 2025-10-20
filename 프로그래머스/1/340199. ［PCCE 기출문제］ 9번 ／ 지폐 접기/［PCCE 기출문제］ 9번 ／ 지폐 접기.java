import java.util.*;
import java.io.*;

class Solution {
    static int mxwal, mnwal, mxbil, mnbil;
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        while(true){
            if(bill[0]<bill[1]){
                if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) break;
                bill[1] /= 2;
            }else{
                if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) break;
                bill[0] /= 2;
            }
            answer += 1;
        }
        return answer;
    }
}