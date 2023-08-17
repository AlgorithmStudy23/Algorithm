package week4.타임머신;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 이동휘_타임머신 {

    static class Node {
        int s, e, c;
        public Node(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }

    static final int INF = 1 << 28;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Node> graph = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Node(s, e, c));
        }

        long[] dist = bellmanford(n, graph);
        if (dist.length == 0) {
            bw.write("-1");

        } else {
            for (int i = 1; i < n; i++) {
                bw.write(String.valueOf((dist[i] == INF) ? -1 : dist[i]));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    static long[] bellmanford(int n, LinkedList<Node> graph) {
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int i = 0; i < n; i++) {
            for (Node o : graph) {
                if (dist[o.s] < INF && dist[o.e] > dist[o.s] + o.c) {
                    dist[o.e] = dist[o.s] + o.c;
                    if (i == n-1) return new long[0];
                }
            }
        }
        return dist;
    }
}
