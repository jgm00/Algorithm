import java.util.*;
import java.io.*;

public class Main
{
    static int x,y,w,h,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		ans = Math.min(h-y,y);
		ans = Math.min(ans, x);
		ans = Math.min(ans, w-x);
		System.out.println(ans);
	}
}