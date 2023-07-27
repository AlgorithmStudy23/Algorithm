import sys
N, K = map(int, input().split())
li = []

if K < 5:  # 최소 단어를 못배우면
    print(0)
    sys.exit()
antatica = 0
ans = 0
li = []
not_learned = set()
learned = ['a', 'n', 't', 'i', 'c']
for i in range(N):
    word = input()
    if len(word) == 8:  # 'antatica' 알고 있는 단어 제외
        antatica += 1
        continue
    mid = word[4:-4]
    tmp = set()
    for x in mid:
        if x not in learned:
            tmp.add(x)
            not_learned.add(x)
    li.append(tmp)

not_learned = list(not_learned)

def get_count(res):
    global ans
    cnt = 0
    for w in li:
        flag = True
        for l in w:
            if l not in res:
                flag = False
                break
        if flag:
            cnt += 1
    ans = max(ans, cnt)


def comb(cnt, idx, num_idx, res):
    global not_learned
    if cnt == idx:
        get_count(res)
        return
    if num_idx >= len(not_learned):
        return
    res[idx] = not_learned[num_idx]
    comb(cnt, idx + 1, num_idx + 1, res)
    comb(cnt, idx, num_idx + 1, res)
    


comb(K - 5, 0, 0, [0 for _ in range(K - 5)])
print(ans + antatica)
