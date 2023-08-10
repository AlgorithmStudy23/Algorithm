package week3.경주로_건설;

public class 이동휘_경주로_건설 {

    static int N;
    static final int INF = (1 << 28);
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static int[][][] check;

    public int solution(int[][] Board) {
        N = Board.length;
        board = Board;
        check = new int[N][N][4];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 4; k++) {
                    check[i][j][k] = INF;
                }
            }
        }
        dfs(0, 0, -500, -1);
        int res = INF;
        for(int i = 0; i < 4; i++) {
            res = Math.min(res, check[N-1][N-1][i]);
        }
        return res;
    }

    static void dfs(int x, int y, int cost, int dir) {
        if(dir >= 0) {
            if(check[x][y][dir] < cost) {
                return;
            }
            check[x][y][dir] = cost;
        }

        for(int i = 0; i < 4; i++) {
            x += dx[i]; y += dy[i];
            if(x < N && x >= 0 && y < N && y >= 0 && board[x][y] == 0) {
                dfs(x, y, (dir != i) ? cost + 600 : cost + 100, i);
            }
            x -= dx[i]; y -= dy[i];
        }
    }
}
