package week4.우주신과의_교감;

import java.io.*;
import java.util.*;

public class 이동휘_우주신과의_교감 {

    static class Node implements Comparable<Node> {
        int s, e;
        double c;
        public Node(int s, int e, double c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
        @Override
        public int compareTo(Node o) {
            return Double.compare(c, o.c);
        }

    }
    static int[] parents;
    static ArrayList<Node> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] loc = new int[N+1][2];
        graph = new ArrayList<>(N*N/2);
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            loc[i][0] = x; loc[i][1] = y;
            for (int j = i-1; j > 0; j--) {
                double distX = (x - loc[j][0]);
                double distY = (y - loc[j][1]);
                double dist = Math.sqrt((distX*distX) + (distY*distY));
                graph.add(new Node(i, j, dist));
            }
            parents[i] = i;
        }
        graph.sort(Node::compareTo);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        double cost = 0;
        for (Node cur : graph) {
            if (union(cur.s, cur.e)) {
                cost += cur.c;
            }
        }
        System.out.printf("%.2f", cost);
    }
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return false;
        parents[B] = A;
        return true;
    }
    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}