import java.io.*;
import java.util.*;

public class Main {
	static int w, h, p, q, t;
	static int[] dx = { 1, -1, 1, -1 };
	static int[] dy = { 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());
		int tx = t  % (2 * w);
		int dx = p;
		int dirx = 1;
		while(tx -- > 0) {
			if(dx == w) {
				dirx = -1;
			} else if(dx == 0) {
				dirx = 1;
			}
			dx += dirx;
		}
		int ty = t  % (2 * h);
		int dy = q;
		int diry = 1;
		while(ty -- > 0) {
			if(dy == h) {
				diry = -1;
			} else if(dy == 0) {
				diry = 1;
			}
			dy += diry;
		}
		System.out.println(dx + " " + dy);
	}
}