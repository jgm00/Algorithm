class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=s.length()-1; i>=0 ; i--){
            char c = s.charAt(i);
            if(c == '-'){
                answer *= -1;
                continue;
            }
            if(c == '+') continue;
            answer += (int) Math.pow(10,s.length()-1-i) * (c-'0');
        }
        return answer;
    }
}