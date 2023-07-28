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
    xo = input().strip()
    if xo == "end":
        break
    else:
        xcount = 0
        ocount = 0
        start = 0
        xolist = [[0] * 3 for _ in range(3)] #3*3 배열

        for i in range(3):
            for j in range(3):
                xolist[i][j] = xo[start]
                if xo[start] == "X":
                    xcount += 1
                if xo[start] == "O":
                    ocount += 1
                start += 1

        if xcount > ocount+1 or ocount > xcount:
            print("invalid")
            continue

        if ocount + 1 == xcount: #X가 이겼을 때
            if win(xolist, "X") and not win(xolist, "O"):
                print("valid")
                continue
        if ocount == xcount: #O가 이겼을때
            if win(xolist, "O") and not win(xolist, "X"):
                print("valid")
                continue
        if xcount + ocount == 9 and not win(xolist, "O"): # 무승부 상태
            print("valid")
            continue

        print("invalid")
