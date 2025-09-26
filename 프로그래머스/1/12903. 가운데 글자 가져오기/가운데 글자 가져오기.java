class Solution {
    public String solution(String s) {
        String answer = "";
        int k = s.length();
        if(k % 2 == 1){
            answer += s.charAt(k/2);
        }else{
            answer += s.charAt(k/2-1);
            answer += s.charAt(k/2);
        }
        
        return answer;
    }
}