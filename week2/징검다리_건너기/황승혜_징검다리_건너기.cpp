#include <string>
#include <vector>
#include <iostream>

using namespace std;

// 초기 답안 ( 테케 9,10 실패, 효율성테스트 실패)
// 1. 반복문 O(n^2)
int solution(vector<int> stones, int k) {
    int answer = 0;
    int cnt = 0;
    while(true)
    {
        for(int i=0; i<stones.size(); i++)
        {
            if(stones[i]<=0)
                cnt++;
            else
            {
                stones[i]--;
                cnt = 0;
            }
            if(cnt>=k) return answer;
        }
        answer++;
    }
    return answer;
}

// 2. 이분탐색 O(nlogm)
int solution(vector<int> stones, int k) {
    int answer = 0;
    int begin = *min_element(stones.begin(), stones.end());
    int end = *max_element(stones.begin(), stones.end());
    int mid; // 사람수
    while(begin <= end)
    {
        mid = (begin+end)/2;
        int skip = 0;
        int max_cnt= 0;
        vector<int> v(stones);
        for(int i=0; i<v.size(); i++)
        {
            v[i] -= mid;
            if(v[i] < 0)
            {
                skip++;
            }else
                skip = 0;
            max_cnt = max(max_cnt, skip);
        }
        // 사람을 더 건너게 해도 됨
        if(max_cnt < k) // 건너뛴 돌의 개수가 k보다 작으므로
        {
            answer = max(answer, mid); //더 큰 값으로 교체
            begin = mid+1;
        }
        else // 더 작은 값을 찾아야 함
            end = mid-1;
    }
    return answer;
}