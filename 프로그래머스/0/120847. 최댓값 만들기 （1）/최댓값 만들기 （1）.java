import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        answer = numbers[numbers.length-2] * numbers[numbers.length-1];
        return answer;
    }
}