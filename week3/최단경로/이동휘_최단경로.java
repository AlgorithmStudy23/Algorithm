package week3.최단경로;

import java.io.*;
import java.util.*;

public class 이동휘_최단경로 {

    static final int INF = (1 << 28);
    static ArrayList<LinkedList<Node>> graph;
    static class Node implements Comparable<Node> {
        int e, cost;
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new LinkedList<>());
        }
        int k = Integer.parseInt(br.readLine())-1;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        int[] res = dijkstra(k, V);

        for(int i : res) {
            bw.write((i >= INF) ? "INF" : String.valueOf(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int[] dijkstra(int k, int V) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        pq.add(new Node(k, 0));
        Arrays.fill(dist, INF);
        dist[k] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.remove();

            if (cur.cost > dist[cur.e]) {
                continue;
            }

            for (Node n : graph.get(cur.e)) {
                if (dist[n.e] > dist[cur.e] + n.cost) {
                    dist[n.e] = dist[cur.e] + n.cost;
                    pq.add(new Node(n.e, dist[n.e]));
                }
            }
        }

        return dist;
    }
}
