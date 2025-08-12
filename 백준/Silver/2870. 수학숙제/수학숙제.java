import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static String s;
    static ArrayList<String> nums = new ArrayList<>();

    static String normalize(String x) {
        int i = 0;
        while (i < x.length() && x.charAt(i) == '0') i++;
        if (i == x.length()) return "0";
        return x.substring(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            s = br.readLine();
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if ('0' <= c && c <= '9') {
                    tmp.append(c);                 
                } else {
                    if (tmp.length() > 0) {        
                        nums.add(normalize(tmp.toString()));
                        tmp.setLength(0);
                    }
                }
            }
            if (tmp.length() > 0) {             
                nums.add(normalize(tmp.toString()));
            }
        }

        Collections.sort(nums, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        StringBuilder out = new StringBuilder();
        for (String x : nums) out.append(x).append('\n');
        System.out.print(out.toString());
    }
}
