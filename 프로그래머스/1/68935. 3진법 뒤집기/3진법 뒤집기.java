class Solution {
    static String cal(int k){
        StringBuilder sb = new StringBuilder();
        while(k > 0 ){
            sb.append(k%3);
            k/=3;
        }
        return sb.toString();
    }
    static int toTen(String s){
        int ans = 0;
        for(int i = s.length()-1; i>=0; i--){
            ans += ((int) Math.pow(3,(s.length()-1-i))) * (s.charAt(i) - '0');
        }
        return ans;
    }
    public int solution(int n) {
        int answer = 0;
        answer = toTen(cal(n));
        return answer;
    }
}