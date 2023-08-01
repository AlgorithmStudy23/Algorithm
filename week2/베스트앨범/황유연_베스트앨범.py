from collections import defaultdict


def solution(genres, plays):
    res = []
    gdict = defaultdict(list)
    for i in range(len(genres)):
        if genres[i] in gdict.keys():
            gdict[genres[i]][0] += plays[i]
            gdict[genres[i]][1].append([plays[i], i])
        else:
            gdict[genres[i]] = [plays[i], [[plays[i], i]]]
    order_list = sorted(gdict.items(), key=lambda x: -x[1][0])
    for k, _ in order_list:
        x = gdict[k][1]
        x.sort(key=lambda p: (-p[0], p[1]))
        if len(x) > 1:
            x = x[:2]
        for _, i in x:
            res.append(i)
    return res

