class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' '){
                answer += c;
                continue;
            }
            char offset = 0;
            if(Character.isUpperCase(c)){
                offset = 'A';
            }else{
                offset = 'a';
            }
            int pos = (c - offset + n) % ('Z' - 'A' + 1);
            char ans = (char) ((int) offset + pos);
            answer += ans;
        }
        return answer;
    }
}