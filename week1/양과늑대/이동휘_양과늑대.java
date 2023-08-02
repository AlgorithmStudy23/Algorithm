package week1.양과늑대;

import java.util.ArrayList;

public class 이동휘_양과늑대 {

    class Solution {

        static boolean[] visit;
        static ArrayList<ArrayList<Integer>> graph;
        static boolean[] visitable;
        static int[] info;
        static int n;

        public int solution(int[] Info, int[][] edges) {
            graph = new ArrayList<>();
            n = Info.length;
            info = Info;
            res = 0;

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] i : edges) {
                graph.get(i[0]).add(i[1]);
            }
            visit = new boolean[n];
            visitable = new boolean[n];
            visit[0] = true;
            dfs(0, 0, 0);
            return res;
        }

        static int res;

        static void dfs(int cur, int wolf, int sheep) {
            if (info[cur] == 0) {
                sheep++;
            } else {
                wolf++;
            }

            if (wolf == sheep) {
                return;
            }
            res = Math.max(res, sheep);

            for (int i : graph.get(cur)) {
                visitable[i] = true;
            }

            for (int i = 0; i < n; i++) {
                if (!visit[i] && visitable[i]) {
                    visit[i] = true;
                    dfs(i, wolf, sheep);
                    for (int j : graph.get(i)) {
                        visitable[j] = false;
                    }
                    visitable[i] = true;
                    visit[i] = false;
                }
            }

        }
    }
}
