class Solution {
    public int[] solution(int[] numbers) {
        int idx =0;
        int[] answer = new int[numbers.length];
        for(int k : numbers){
            answer[idx++] = k*2;
        }
        return answer;
    }
}