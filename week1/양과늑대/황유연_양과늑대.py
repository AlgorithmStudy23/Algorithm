def solution(info, edges):
    visited = [0] * len(info)
    visited[0] = 1
    answer = []

    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return
        for i in range(len(edges)):
            parent = edges[i][0]
            child = edges[i][1]
            is_wolf = info[child]
            if visited[parent] and not visited[child]:
                visited[child] = 1
                dfs(sheep + (is_wolf == 0), wolf + (is_wolf == 1))
                visited[child] = 0

    dfs(1, 0)
    return max(answer)
