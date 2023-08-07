package week3.알고스팟;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이동휘_알고스팟 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(n, m, board));
    }
    static int bfs(int n, int m, char[][] board) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.add(new int[]{0, 0});
        int cnt = 0;
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                q2.add(q.remove());
            }

            while (!q2.isEmpty()) {
                int[] cur = q2.remove();
                if (cur[0] == n-1 && cur[1] == m-1) {
                    return cnt;
                }

                for (int i = 0; i < 4; i++) {
                    cur[0] += dx[i]; cur[1] += dy[i];

                    if (cur[0] >= 0 && cur[0] < n && cur[1] >= 0 && cur[1] < m) {
                        if (board[cur[0]][cur[1]] == '0') {
                            q2.add(new int[]{cur[0], cur[1]});
                        } else if (board[cur[0]][cur[1]] == '1') {
                            q.add(new int[]{cur[0], cur[1]});
                        }
                        board[cur[0]][cur[1]] = '2';
                    }
                    cur[0] -= dx[i]; cur[1] -= dy[i];
                }
            }
            cnt++;
        }

        return cnt;
    }
}
