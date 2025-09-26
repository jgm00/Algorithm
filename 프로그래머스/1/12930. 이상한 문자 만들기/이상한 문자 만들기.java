class Solution {
    public String solution(String s) {
        int togle = 0;
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == ' '){
                togle = 0;
            }else{
                if(togle == 1){
                    c = Character.toLowerCase(c);
                }else{
                    c = Character.toUpperCase(c);
                }
                togle = 1 - togle;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}