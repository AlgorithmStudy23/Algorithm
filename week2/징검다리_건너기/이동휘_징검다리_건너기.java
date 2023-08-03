package week2.징검다리_건너기;

import java.util.ArrayList;

public class 이동휘_징검다리_건너기 {

    public int solution(int[] stones, int k) {
        int len = stones.length;
        ArrayList<int[]> arr = new ArrayList<>(len);
        for(int i = 0; i < len; i++) {
            arr.add(new int[]{stones[i], i});
        }
        arr.sort((o1, o2) -> o1[0] - o2[0]);

        int n = 0;
        int cnt = 0;
        for(int[] cur : arr) {
            n += cur[0] - n;
            cnt++;
            if(cnt < k) {
                continue;
            }
            int i = cur[1]+1;
            int j = cur[1]-1;
            while(i < len && stones[i] <= n) {
                i++;
            }
            while(j >= 0 && stones[j] <= n) {
                j--;
            }
            if(i - j - 1 >= k) {
                break;
            }
        }

        return n;
    }
}
