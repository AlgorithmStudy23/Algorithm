package week1.틱택토;

import java.io.*;

public class 이동휘_틱택토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String S = br.readLine();

            if (S.charAt(0) == 'e') {
                bw.flush();
                bw.close();
                return;
            }

            char[][] target = new char[3][3];
            target[0] = S.substring(0, 3).toCharArray();
            for (int i = 3; i <= 9; i += 3) {
                target[i/3 - 1] = S.substring(i-3, i).toCharArray();
            }

            int xCnt = 0;
            int oCnt = 0;
            for (char[] s : target) {
                for (char c : s) {
                    if (c == 'X') {
                        xCnt++;
                    } else if (c == 'O'){
                        oCnt++;
                    }
                }
            }

            if (xCnt > oCnt+1 || oCnt > xCnt) {
                bw.write("invalid");
                bw.newLine();
                continue;
            }

            int sum = oCnt + xCnt;
            boolean xCheck = check(target, 'X');
            boolean oCheck = check(target, 'O');
            boolean flag = false;

            if (sum == 9 && xCnt == oCnt + 1) {
                flag = !oCheck;
            } else {

                if (!oCheck && xCheck) {
                    flag = (xCnt == oCnt + 1);
                } else if (oCheck && !xCheck){
                    flag = (xCnt == oCnt);
                }
            }

            bw.write((flag) ? "valid" : "invalid");
            bw.newLine();
        }
    }
    static boolean check(char[][] arr, char cur) {
        for (int i = 0; i < 3; i++) {

            if (arr[i][0] == cur && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                return true;
            }

            if (arr[0][i] == cur && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                return true;
            }
        }

        if (arr[0][0] == cur && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
            return true;
        }

        if (arr[2][0] == cur && arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) {
            return true;
        }

        return false;
    }
}
