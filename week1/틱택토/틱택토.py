from sys import stdin

input = stdin.readline


def check_line(line, t):
    # 가로 체크
    for i in range(0, 9, 3):  
        if line[i] == t and line[i] == line[i + 1] == line[i + 2]:
            return True

    # 세로 체크
    for i in range(3):  
        if line[i] == t and line[i] == line[i + 3] == line[i + 6]:
            return True

    # 대각선 체크
    if line[0] == t and line[0] == line[4] == line[8]:
        return True
    if line[2] == t and line[2] == line[4] == line[6]:
        return True

    return False


while True:
    line = input().strip()
    if line == 'end':
        break
    x_count = line.count('X')
    o_count = line.count('O')

    if x_count == o_count + 1 or x_count == o_count:
        typ1, typ2 = ('X', 'O') if x_count == o_count + 1 else ('O', 'X')
        # X가 이기면 typ1=X, typ2=O
        # O가 이기면 typ1=O, typ2=X

        exist_real_winner = check_line(line, typ1)
        exist_fake_winner = check_line(line, typ2)

        if exist_fake_winner:
            print('invalid')
        elif not exist_real_winner:
            if line.count('.') == 0:  # 이긴 사람은 없지만 게임판이 가득 찬 경우
                print('valid')
            else:  # 이긴 사람이 없고 게임판이 아직 차지 않은 경우
                print('invalid')
        else:
            print('valid')
    else:
        print('invalid')
