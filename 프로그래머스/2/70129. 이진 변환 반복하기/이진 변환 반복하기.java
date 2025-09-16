class Solution {
    static int ans = 0;
    static String func(int k){
        String str = "";
        while(k > 0){
            str += (k%2);
            k /= 2;
        }
        return str;
    }
    static int reze(String s){
        String ns = "";
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if(c != '0'){
                ns += c;
            }else{
                ans +=1;
            }
        }
        int k = ns.length();
        return k;
    }
    public int[] solution(String s) {
        int idx = 0;
        while(true){
            int k = reze(s);
            idx+=1;
            String str = func(k);
            if(str.equals("1")) break;
            s = str;
        }
        int[] answer = new int[2];
        answer[0] = idx;
        answer[1] = ans;
        return answer;
    }
}