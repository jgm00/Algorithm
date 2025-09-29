class Solution {
    static int cal(int x){
        int sm = 0;
        while(x > 0){
            sm += (x%10);
            x /= 10;
        }
        return sm;
    }
    public boolean solution(int x) {
        boolean answer = true;
        if(x % cal(x) != 0){
            answer = false;
        }
        return answer;
    }
}