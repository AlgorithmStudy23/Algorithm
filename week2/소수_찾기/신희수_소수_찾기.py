#소수를 담을 집합
prime_set = set()

#소수 판별 함수
def isPrime(number):
    if number in (0, 1):
        return False

    #에라토스테네스의 체
    lim = int(number ** 0.5 + 1)
    for i in range(2, lim):
        if number % i == 0:
            return False

    return True


def makeCombinations(combination, others):
    #재귀
    if combination != "":
        if isPrime(int(combination)):
            prime_set.add(int(combination))
    
    #현재까지 만들어진 숫자에, 남아있는 숫자 중 하나씩을 붙여서 조합 생성
    for i in range(len(others)):
        makeCombinations(combination + others[i], others[:i] + others[i + 1:])


def solution(numbers):
    # 2
    makeCombinations("", numbers)

    answer = len(prime_set)
    return answer