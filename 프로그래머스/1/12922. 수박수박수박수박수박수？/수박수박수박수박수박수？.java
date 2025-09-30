class Solution {
    static char[] c = {'수','박'};
    public String solution(int n) {
        String answer = "";
        for(int i=0;i<n;i++){
            answer += (c[i%2]);
        }
        return answer;
    }
}