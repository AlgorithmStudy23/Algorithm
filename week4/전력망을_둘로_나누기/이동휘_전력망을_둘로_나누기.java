package week4.전력망을_둘로_나누기;

public class 이동휘_전력망을_둘로_나누기 {

    static boolean[][] link;
    static int n, cnt;

    public int solution(int N, int[][] wires) {
        n = N;
        link = new boolean[n+1][n+1];
        for(int[] i : wires) {
            link[i[0]][i[1]] = true;
            link[i[1]][i[0]] = true;
        }

        int res = 100;
        for(int[] i : wires) {
            link[i[0]][i[1]] = false;
            link[i[1]][i[0]] = false;
            cnt = 0;
            dfs(i[0]);
            res = Math.min(Math.abs(n - cnt - cnt), res);
            link[i[0]][i[1]] = true;
            link[i[1]][i[0]] = true;
        }
        return res;
    }
    static void dfs(int cur) {
        cnt++;
        for(int i = 1; i <= n; i++) {
            if(i == cur) continue;
            if(link[cur][i]) {
                link[i][cur] = false;
                dfs(i);
                link[i][cur] = true;
            }
        }
    }
}
