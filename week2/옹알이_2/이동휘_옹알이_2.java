package week2.옹알이_2;

import java.util.HashMap;
import java.util.Stack;

public class 이동휘_옹알이_2 {

    public int solution(String[] babbling) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aya", 1);
        map.put("ye", 2);
        map.put("woo", 3);
        map.put("ma", 4);

        int res = 0;
        loop:
        for(String s : babbling) {
            int len = s.length();
            int idx = 0;
            int hi = 0;
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            while(idx < len) {
                int cur = 0;
                if(s.charAt(idx) == 'a' || s.charAt(idx) == 'w') {
                    hi = idx + 3;
                } else {
                    hi = idx + 2;
                }
                if(hi > len) continue loop;
                cur = map.getOrDefault(s.substring(idx, hi), 0);
                if(cur != 0 && cur != stack.peek()) {
                    stack.add(cur);
                } else {
                    continue loop;
                }
                idx = hi;
            }
            res++;
        }
        return res;
    }
}
