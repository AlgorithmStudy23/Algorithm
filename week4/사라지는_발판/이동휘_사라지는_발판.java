package week4.사라지는_발판;


public class 이동휘_사라지는_발판 {

    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C;

    public int solution(int[][] Board, int[] aloc, int[] bloc) {
        R = Board.length;
        C = Board[0].length;
        board = Board;

        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
    static int dfs(int x1, int y1, int x2, int y2) {

        if(board[x1][y1] == 0) return 0;
        int ans = 0;

        for(int i = 0; i < 4; i++) {
            int x = x1 += dx[i];
            int y = y1 += dy[i];

            if(x >= 0 && x < R && y >= 0 && y < C && board[x][y] == 1) {
                board[x1][y1] = 0;
                int val = dfs(x2, y2, x, y) + 1;
                board[x1][y1] = 1;

                if(ans % 2 == 0 && val % 2 == 1) {
                    ans = val;
                } else if(ans % 2 == 0 && val % 2 == 0) {
                    ans = Math.max(ans, val);
                } else if(ans % 2 == 1 && val % 2 == 1) {
                    ans = Math.min(ans, val);
                }
            }

        }
        return ans;
    }
}