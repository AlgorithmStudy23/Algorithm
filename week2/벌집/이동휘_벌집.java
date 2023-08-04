package week2.벌집;

import java.io.*;

public class 이동휘_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; ;i++) {
            if (N==1) {
                System.out.println(1);
                return;
            }
            // a0 = 1, a1 = 7, a2 = 19, a3 = 37 ...
            // an = (6*n+6)*n/2 + 1 이고
            // ai가 N보다 커지는 지점이 N이 가능해 지는 범위 이다
            if (N<=((6*i+6)*i/2)+1) {
                System.out.println(i+1);
                return;
            }
        }
    }
}
