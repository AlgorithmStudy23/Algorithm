package week3.성격_유형_검사하기;


public class 이동휘_성격_유형_검사하기 {

    public String solution(String[] survey, int[] choices) {
        int[] point = new int[4];
        int len = survey.length;
        for(int i = 0; i < len; i++) {
            char cur = survey[i].charAt(0);
            int choice = choices[i];
            if(choice == 4) continue;
            if (cur == 'R' || cur == 'T') {
                if(cur == 'R') {
                    if(choice < 4) {
                        point[0] += Math.abs(choice - 4);
                    } else {
                        point[0] -= (choice - 4);
                    }
                } else {
                    if(choice < 4) {
                        point[0] -= Math.abs(choice - 4);
                    } else {
                        point[0] += (choice - 4);
                    }
                }
                continue;
            }
            if (cur == 'C' || cur == 'F') {
                if(cur== 'C') {
                    if(choice < 4) {
                        point[1] += Math.abs(choice - 4);
                    } else {
                        point[1] -= (choice - 4);
                    }
                } else {
                    if(choice < 4) {
                        point[1] -= Math.abs(choice - 4);
                    } else {
                        point[1] += (choice - 4);
                    }
                }
                continue;
            }
            if (cur == 'J' || cur == 'M') {
                if(cur== 'J') {
                    if(choice < 4) {
                        point[2] += Math.abs(choice - 4);
                    } else {
                        point[2] -= (choice - 4);
                    }
                } else {
                    if(choice < 4) {
                        point[2] -= Math.abs(choice - 4);
                    } else {
                        point[2] += (choice - 4);
                    }
                }
                continue;
            }
            if (cur == 'A' || cur == 'N') {
                if(cur== 'A') {
                    if(choice < 4) {
                        point[3] += Math.abs(choice - 4);
                    } else {
                        point[3] -= (choice - 4);
                    }
                } else {
                    if(choice < 4) {
                        point[3] -= Math.abs(choice - 4);
                    } else {
                        point[3] += (choice - 4);
                    }
                }
            }
        }
        String ans = "";
        ans += (point[0] < 0) ? 'T' : 'R';
        ans += (point[1] < 0) ? 'F' : 'C';
        ans += (point[2] < 0) ? 'M' : 'J';
        ans += (point[3] < 0) ? 'N' : 'A';
        for(int i : point) {
            System.out.print(i + " ");
        }
        return ans;
    }
}
