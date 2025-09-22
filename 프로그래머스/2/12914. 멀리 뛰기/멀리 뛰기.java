class Solution {
    static long[] num;
    public long solution(int n) {
        long answer = 0;
        num = new long[n+1];
        if(n==1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        num[1] = 1;
        num[2] = 2;
        for(int i=3;i<=n;i++){
            num[i] = num[i-1] + num[i-2];
            num[i] %= 1234567;
        }
        return num[n];
    }
}