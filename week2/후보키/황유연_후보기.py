def check_key(res, relation, keys):
    tmp = []
    for row in relation:
        tmp_row = []
        for i in range(len(res)):
            # if row[res[i]] not in tmp:
            tmp_row.append(row[res[i]])

        if tmp_row not in tmp:
            tmp.append(tmp_row)
    # print(tmp)
    if len(tmp) == len(relation) and res not in keys and is_minimal(res, keys.copy()):
        print(res)
        keys.append(res)


def is_minimal(res, keys):
    cnt = 0
    if len(keys) == 0:
        return True
    for k in keys:
        for p in res:
            if cnt >= len(k):
                return False
                break
            if p in k:
                cnt += 1
    return True


def dfs(idx, n, res, relation, keys):
    if len(res) == n:
        check_key(res.copy(), relation, keys)
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
