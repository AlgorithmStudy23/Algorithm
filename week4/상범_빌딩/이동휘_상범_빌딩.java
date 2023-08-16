package week4.상범_빌딩;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이동휘_상범_빌딩 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0) break;
            char[][][] board = new char[L][R][C];
            int[] s = new int[3];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    board[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        if (board[i][j][k] == 'S') {
                            board[i][j][k] = '#';
                            s = new int[]{i, j, k};
                        }
                    }
                }
                br.readLine();
            }
            int res = bfs(s, L, R, C, board);
            if (res < 0) {
                bw.write("Trapped!");
            } else {
                bw.write("Escaped in " + res + " minute(s).");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int[] s, int l, int r, int c, char[][][] board) {
        int[] dx = new int[]{1, 0, -1, 0, 0, 0};
        int[] dy = new int[]{0, -1, 0, 1, 0, 0};
        int[] dz = new int[]{0, 0, 0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.add(s);
        int time = 0;
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                q2.add(q.remove());
            }
            time++;
            while (!q2.isEmpty()) {
                int[] cur = q2.remove();

                for (int i = 0; i < 6; i++) {
                    cur[0] += dz[i]; cur[1] += dx[i]; cur[2] += dy[i];
                    if (cur[0] < l && cur[1] < r && cur[2] < c && cur[0] >= 0 && cur[1] >= 0 && cur[2] >= 0 && board[cur[0]][cur[1]][cur[2]] != '#') {
                        if (board[cur[0]][cur[1]][cur[2]] == 'E') {
                            return time;
                        }
                        board[cur[0]][cur[1]][cur[2]] = '#';
                        q.add(new int[]{cur[0], cur[1], cur[2]});
                    }
                    cur[0] -= dz[i]; cur[1] -= dx[i]; cur[2] -= dy[i];
                }
            }
        }
        return -1;
    }
}
