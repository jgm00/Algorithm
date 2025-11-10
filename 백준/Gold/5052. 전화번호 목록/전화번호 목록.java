import java.util.*;
import java.io.*;

public class Main {
    static int t,n, flag;
    static String bs, num;
    static String[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            flag = 0;
            nums = new String[n];
            for(int i=0;i<n;i++){
                num = br.readLine();
                nums[i] = num;
            }
            Arrays.sort(nums);
            for(int i=1;i<n;i++){
                if(nums[i].startsWith(nums[i-1])){
                    flag = 1;
                }
            }
            if(flag == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

