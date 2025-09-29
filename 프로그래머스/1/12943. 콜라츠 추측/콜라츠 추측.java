class Solution {
    public int solution(int num) {
        int answer = 0;
        long mynum = num;
        while(mynum != 1){
            if(answer >= 500){
                return -1;
            }
            if(mynum % 2 == 0){
                mynum /= 2;
            }else{
                mynum = mynum * 3 + 1;
            }
            answer += 1;
        }
        return answer;
    }
}