def solution(survey, choices):
    answer = ''
    dict = {}
    type = ["R","T","C","F","J","M","A","N"]
    for x in type:
        dict[x]=0
    for i in range(len(choices)):
        sc = choices[i]
        if sc>4:
            dict[survey[i][1]] = dict[survey[i][1]] + sc-4
        if sc<4:
            dict[survey[i][0]] = dict[survey[i][0]] + 3-sc+1
    
    if dict["R"] >= dict["T"]:
        answer+='R'
    else:
        answer+='T'
    if dict["C"] >= dict["F"]:
        answer+='C'
    else:
        answer+='F'
    if dict["J"] >= dict["M"]:
        answer+='J'
    else:
        answer+='M'
    if dict["A"] >= dict["N"]:
        answer+='A'
    else:
        answer+='N'
    
    return answer
