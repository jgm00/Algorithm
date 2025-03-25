import java.util.*;
import java.io.*;

public class Main {
    static int N, Q;
    static TreeSet<Integer> hongik = new TreeSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (k == 1) {
                hongik.add(i + 1);
            }
        }
        
        int dohyun = 1; // 도현이 시작 위치
        
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            
            if (op == 1) {
                int k = Integer.parseInt(st.nextToken());
                if (hongik.contains(k)) {
                    hongik.remove(k);
                } else {
                    hongik.add(k);
                }
            } else if (op == 2) {
                int x = Integer.parseInt(st.nextToken());
                dohyun = ((dohyun - 1 + x) % N) + 1; 
            } else if (op == 3) {
                if (hongik.isEmpty()) {
                    System.out.println("-1");
                } else {
                    Integer next = hongik.ceiling(dohyun);
                    if (next == null) {

                        next = hongik.first();
                        System.out.println(N - dohyun + next);
                    } else {

                        System.out.println(next - dohyun);
                    }
                }
            }
        }
    }
}