import sys


# input = sys.stdin.readline


def check_line(line):
    arr = []
    arr.append(line[:3])
    arr.append(line[3:6])
    arr.append(line[6:9])
    # print(arr)

    # 가로 체크
    for x in arr:
        if x == 'XXX' or x == 'OOO':
            return True
    # 세로 체크
    for i in range(3):
        x = arr[i][0] + arr[i][1] + arr[i][2]
        if x == 'XXX' or x == 'OOO':
            return True
    # 대각선 체크
    x = arr[0][0] + arr[1][1] + arr[2][2]
    if x == 'XXX' or x == 'OOO':
        return True
    x = arr[-1][0] + arr[1][1] + arr[0][2]
    if x == 'XXX' or x == 'OOO':
        return True
    return False


while True:
    line = input()
    o = 0
    x = 0
    # print(line)
    if line == 'end':
        break
    for ox in line:
        if ox == 'O':
            o += 1
        elif ox == 'X':
            x += 1
    if not (o == x or x == o + 1):  # X 먼저 시작, 조건
        print("invalid")
        continue
    if check_line(line):
        print("valid")
        continue

    print("invalid")

