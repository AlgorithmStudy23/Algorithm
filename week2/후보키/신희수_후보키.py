from itertools import combinations

def candidateKey(relation, columns):
    uniqueSet = set()
    for row in relation:
        unique = tuple(row[col] for col in columns)
        if unique in uniqueSet:
            return False
        uniqueSet.add(unique)
    return True

def sol(relation):
    colNum = len(relation[0])
    rowNum = len(relation)
    candidateKeyList = []

    for i in range(1, colNum + 1): #조합을 이용하여 후보키인지 확인하기
        for columns in combinations(range(colNum), i):
            if candidateKey(relation, columns):
                candidateKeyList.append(columns)