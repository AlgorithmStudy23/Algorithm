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
            if (N<=((6*i+6)*i/2)+1) {
                System.out.println(i+1);
                return;
            }
        }
    }
}
