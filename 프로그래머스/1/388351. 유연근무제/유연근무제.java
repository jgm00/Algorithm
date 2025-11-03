class Solution {
    static int sat, sun;
    static void check(int startday){
        sat = (6-startday+7)%7;
        sun = (sat+1)%7;
    }
    static boolean chk(int idx, int off,int[][] timelogs){
        for(int i=0;i<timelogs[idx].length;i++){
            if((sat != i) && (sun != i) && timelogs[idx][i] > off){
                return false;
            }
        }
        return true;
    }
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        check(startday);
        for(int i=0;i<schedules.length;i++){
            int h = (schedules[i] / 100) + ((schedules[i] % 100)+10)/60;
            int m = ((schedules[i] % 100)+10)%60;
            int off = h*100+m;
            answer += chk(i,off,timelogs) == true ? 1 : 0;
        }
        return answer;
    }
}