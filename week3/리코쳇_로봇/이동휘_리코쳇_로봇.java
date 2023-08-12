package week3.리코쳇_로봇;

import java.util.Queue;
import java.util.LinkedList;


public class 이동휘_리코쳇_로봇 {

    static char[][] board;
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public int solution(String[] Board) {
        R = Board.length; C = Board[0].length();
        board = new char[R][C];
        int r = 0, c = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                char cur = Board[i].charAt(j);
                board[i][j] = cur;
                if(cur == 'R') {
                    r = i; c = j;
                }
            }
        }

        return bfs(r, c);
    }
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        q.add(new int[]{x, y});
        boolean[][] visit = new boolean[R][C];
        visit[x][y] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            while(!q.isEmpty()) {
                q2.add(q.remove());
            }
            cnt++;

            while(!q2.isEmpty()) {
                int[] cur = q2.remove();
                int r = cur[0], c = cur[1];
                for(int i = 0; i < 4; i++) {
                    while(r + dx[i] < R && r + dx[i] >= 0 &&
                            c + dy[i] < C && c + dy[i] >= 0 &&
                            board[r+dx[i]][c+dy[i]] != 'D') {

                        r += dx[i]; c += dy[i];
                    }
                    if(board[r][c] == 'D') {
                        r -= dx[i]; c -= dy[i];
                    }
                    if(!visit[r][c]) {
                        if(board[r][c] == 'G') {
                            return cnt;
                        }
                        visit[r][c] = true;
                        q.add(new int[]{r, c});
                    }
                    r = cur[0]; c = cur[1];
                }
            }
        }
        return -1;
    }
}
