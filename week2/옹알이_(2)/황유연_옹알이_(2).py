def solution(babbling):
    answer = 0
    li = ["aya", "ye", "woo", "ma"]
    li2 = ["ayaaya", "yeye", "woowoo", "mama"]

    for word in babbling:

        flag = False  # 반복단어 들어갈 시 넘김
        for k in li2:
            if k in word:
                flag = True
                break
        if flag:
            continue

        while True:

            if word.strip() == '':
                answer += 1
                break
            cnt = 0
            for x in li:
                if x in word:
                    cnt += 1
                    word = word.replace(x, " ")
                    break
            if cnt == 0:
                break
    return answer

