class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = s.charAt(0);
        int acnt = 0;
        int bcnt = 0;
        int flag = 0;
        for(int i=0;i<s.length();i++){
            if(c == s.charAt(i)){
                acnt += 1;
            }else{
                bcnt += 1;
            }
            if(acnt == bcnt){
                answer += 1;
                if(i+1 == s.length()){
                    flag = 1;
                    continue;
                }
                c = s.charAt(i+1);
                acnt = 0; bcnt = 0;
            }
        }
        if(flag != 1){
            answer += 1;
        }
        return answer;
    }
}