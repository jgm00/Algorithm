import java.util.*;
import java.io.*;

public class Main {
    static int N, M, X;
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Pair>[] adj;
    static int[] dist;
    static PriorityQueue<Pair> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[a].add(new Pair(b, d));
        }

        int[] distFromX = new int[N + 1];
        Arrays.fill(distFromX, Integer.MAX_VALUE);
        distFromX[X] = 0;
        pq = new PriorityQueue<>((o1, o2) -> o1.y - o2.y);
        pq.add(new Pair(X, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.y != distFromX[p.x]) continue;

            for (Pair e : adj[p.x]) {
                if (distFromX[p.x] + e.y < distFromX[e.x]) {
                    distFromX[e.x] = distFromX[p.x] + e.y;
                    pq.add(new Pair(e.x, distFromX[e.x]));
                }
            }
        }

        int maxDistance = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue; 

            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            pq.clear();
            pq.add(new Pair(i, 0));

            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                if (p.y != dist[p.x]) continue;

                for (Pair e : adj[p.x]) {
                    if (dist[p.x] + e.y < dist[e.x]) {
                        dist[e.x] = dist[p.x] + e.y;
                        pq.add(new Pair(e.x, dist[e.x]));
                    }
                }
            }

            maxDistance = Math.max(maxDistance, dist[X] + distFromX[i]);
        }

        System.out.println(maxDistance);
    }
}
