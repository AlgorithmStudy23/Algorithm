def win(xolist, XO):
    if xolist[0][0] == xolist[1][1] == xolist[2][2]== XO:
        return True
    if xolist[0][0] == xolist[1][0] == xolist[2][0]== XO:
        return True
    if xolist[0][0] == xolist[0][1] == xolist[0][2]== XO:
        return True

    if xolist[1][0] == xolist[1][1] == xolist[1][2]== XO:
        return True
    if xolist[2][0] == xolist[2][1] == xolist[2][2]== XO:
        return True
    if xolist[2][0] == xolist[1][1] == xolist[0][2]== XO:
        return True

    if xolist[0][1] == xolist[1][1] == xolist[2][1]== XO:
        return True
    if xolist[0][2] == xolist[1][2] == xolist[2][2]== XO:
        return True

    return False

while True:
    xolist = []
    for _ in range(3):
        xo = input().strip()
        if xo == "end":
            break
        # 3개씩 끊어서 리스트에 저장
        xolist.append([xo[i:i+3] for i in range(0, len(xo), 3)])

    if not xolist:  # xo_list가 비어있으면 "end"가 입력되어 더 이상 게임판 상태가 주어지지 않은 경우
        break

    for xo in xolist:
        xcount = 0
        ocount = 0

        for i in range(3):
            for j in range(3):
                if xo[i][j] == "X":
                    xcount += 1
                elif xo[i][j] == "O":
                    ocount += 1

        if xcount > ocount+1 or ocount > xcount:
            print("invalid")
            continue

        if ocount + 1 == xcount: #X가 이겼을 때
            if win(xo, "X") and not win(xo, "O"):
                print("valid")
                continue
        if ocount == xcount: #O가 이겼을때
            if win(xo, "O") and not win(xo, "X"):
                print("valid")
                continue
        if xcount + ocount == 9 and not win(xo, "O"): # 무승부 상태
            print("valid")
            continue

        print("invalid")
