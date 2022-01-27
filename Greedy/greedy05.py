def solution(n, costs):
    ans = 0
    costs.sort(key = lambda x: x[2]) # cost 기준으로 오름차순 정렬
    #[[0,1,1],[1,3,1],[0,2,2],[1,2,5],[2,3,8]]
    #costs[0],costs[1],costs[2] = 0 1 1 -> (0,1)
    routes = set({costs[0][0],costs[0][1]})
    ans+=costs[0][2]
    costs.pop(0)
    while len(routes)!=n:
        for cost in (costs):
            if cost[0] in routes and cost[1] in routes:
                continue
            if cost[0] in routes or cost[1] in routes:
                routes.update([cost[0], cost[1]])
                ans += cost[2]
                break
    return ans