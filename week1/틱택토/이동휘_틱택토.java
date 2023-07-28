package week1.틱택토;

import java.io.*;

public class 이동휘_틱택토 {
    static int end;
    static boolean flag;
    static char[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            target = br.readLine().toCharArray();
            if (target[0] == 'e') {
                bw.flush();
                bw.close();
                return;
            }
            end = 9;
            int xCnt = 0;
            int oCnt = 0;
            for (char c : target) {
                if (c == '.') {
                    end--;
                } else if (c == 'X') {
                    xCnt++;
                } else {
                    oCnt++;
                }
            }
            if (xCnt >= oCnt+2 || oCnt > xCnt) {
                bw.write("invalid");
                bw.newLine();
                continue;
            }

            flag = false;
            if (end != 9 && !check(target)) {
                bw.write("invalid");
                bw.newLine();
                continue;
            }

            dfs('X', 0, new char[9]);

            if (flag) {
                bw.write("valid");
            } else {
                bw.write("invalid");
            }
            bw.newLine();
        }
    }
    static void dfs(char cur, int num, char[] arr) {
        if (num == end) {
            flag = true;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (target[i] == cur && arr[i] != cur) {
                arr[i] = cur;
                num++;
                if (num != end && check(arr)) {
                    arr[i] = '.';
                    return;
                }
                dfs((cur == 'X') ? 'O' : 'X', num, arr);
                num--;
                arr[i] = '.';
            }
        }
    }
    static boolean check(char[] arr) {
        if ((arr[0] == 'X' || arr[0] == 'O')) {
            if ((arr[0] == arr[1] && arr[1] == arr[2]) || (arr[0] == arr[4] && arr[4] == arr[8])
            || (arr[0] == arr[3] && arr[3] == arr[6])) {
                return true;
            }
        }
        if ((arr[4] == 'X' || arr[4] == 'O')) {
            if ((arr[3] == arr[4] && arr[4] == arr[5]) || (arr[2] == arr[4] && arr[4] == arr[6])
            || (arr[1] == arr[4] && arr[4] == arr[7])) {

                return true;
            }
        }

        if ((arr[6] == 'X' || arr[6] == 'O')) {
            if ((arr[6] == arr[7] && arr[7] == arr[8])
            || (arr[2] == arr[5] && arr[5] == arr[8])) {
                return true;
            }
        }

        return false;
    }
}
