class Solution {
    static int[] num = new int[3];
    static int cal(int k, char op){
        if(op == 'S'){
            k = k;
        }else if(op == 'D'){
            k = k * k;
        }else if(op == 'T'){
            k = k * k * k;
        }
        return k;
    }
    public int solution(String dartResult) {
        int answer = 0;
        int idx = 0;
        for(int i = 0; i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            if('0' <= c && c <='9'){
                int numb = c - '0';
                if(i != 0){
                    if(dartResult.charAt(i-1) == '1' && numb ==0){
                        continue;
                    }
                }
                char op = dartResult.charAt(i+1);
                if('0' <= op && op <='9'){
                    numb = 10;
                    op = dartResult.charAt(i+2);
                }
                int k = cal(numb,op);
                num[idx] = k;
                char nxop;
                if(numb == 10){
                    nxop = dartResult.charAt(Math.min(dartResult.length()-1,i+3));
                }else{
                    nxop =  dartResult.charAt(Math.min(dartResult.length()-1,i+2));
                }
                if(nxop == '*'){
                    if(idx != 0){
                        num[idx-1] *= 2;
                    }
                    num[idx] *= 2;
                }
                if(nxop == '#'){
                    num[idx]*= -1;
                }
                idx += 1;
            }
        }
        for(int i=0;i<3;i++){
            answer += num[i];
        }
        return answer;
    }
}