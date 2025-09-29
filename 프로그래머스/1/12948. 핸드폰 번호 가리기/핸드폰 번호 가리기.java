class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int sz = phone_number.length();
        for(int i=0;i<sz-4;i++){
            answer += "*";
        }
        answer += phone_number.substring(sz-4);
        return answer;
    }
}