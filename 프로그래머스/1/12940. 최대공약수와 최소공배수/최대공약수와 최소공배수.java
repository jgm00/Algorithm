class Solution {
    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
    static int lcm(int a, int b, int k){
        int sm = 1;
        sm *= a / k;
        sm *= b / k;
        sm *= k;
        return sm;
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int k = gcd(n,m);
        int p = lcm(n,m,k);
        answer[0] = k;
        answer[1] = p;
        return answer;
    }
}