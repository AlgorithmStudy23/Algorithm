def check_key(res, relation, keys):
    # 유일성 체크 전 최소성 체크를 하여 시간을 단축
    if not is_minimal(res, keys.copy()):
        return False
    tmp = []
    for row in relation:
        tmp_row = []
        for i in range(len(res)):
            tmp_row.append(row[res[i]])
        if tmp_row not in tmp:
            tmp.append(tmp_row)
    if len(tmp) == len(relation):
        if res not in keys:
            keys.append(res)

# 파이썬 내장 함수를 사용하는 방법
# def is_minimal(res, keys):
#     for key in keys:
#         if set(key).issubset(res):
#             return False
#     return True


def is_minimal(res, keys):

    if len(keys) == 0:
        return True

    # 키를 하나씩 가져와 res의 요소와 몇개가 겹치나 확인한다. 
    # 겹치는 갯수가 키의 길이 이상이면 최소가 아니라고 판단한다.
    for k in keys:
        cnt = 0
        for p in res:
            if cnt >= len(k):
                return False
            if p in k:
                cnt += 1
        if cnt >= len(k):
            return False
    return True


def dfs(idx, n, res, relation, keys):
    if len(res) == n:
        check_key(res.copy(), relation, keys) # 주의
        return
    for i in range(idx, len(relation[0])):
        if i not in res:
            res.append(i)
            dfs(i + 1, n, res, relation, keys)
            res.pop()


def solution(relation):
    keys = []
    for i in range(1, len(relation[0]) + 1):
        dfs(0, i, [], relation, keys)
    return len(keys)

