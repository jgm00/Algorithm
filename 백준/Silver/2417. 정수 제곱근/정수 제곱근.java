import java.io.*;
import java.util.*;

public class Main
{
    static Long N;
static boolean check(Long k){
    if (k > 0 && k > N / k) return true; // overflow 피하면서 k*k > N 체크
    return k * k >= N;
}

    static Long bin_s(Long tar){
        if(tar == 0) return 0L;
        Long l = 1L; Long r = (Long) (1L <<32);
        Long idx = r;
        while(l <= r){
            Long mid = (l + r) / 2;
            if(check(mid)){
                idx = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return idx;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        System.out.println(bin_s(N));
	}
}