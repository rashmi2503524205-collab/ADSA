INF = float("inf")

def dijkstra(graph, source, n):
    distance = [INF] * n
    visited = [False] * n
    distance[source] = 0

    for _ in range(n):
        # find the unvisited vertex with the minimum distance
        u = -1
        for i in range(n):
            if not visited[i] and (u == -1 or distance[i] < distance[u]):
                u = i

        # no vertex left, or all remaining are unreachable
        if u == -1 or distance[u] == INF:
            break

        visited[u] = True

        # relax edges out of u
        for v in range(n):
            if not visited[v] and graph[u][v] != 0 and distance[u] + graph[u][v] < distance[v]:
                distance[v] = distance[u] + graph[u][v]

    return distance


# Example
graph = [
    [0, 4, 0, 0, 0, 0, 0, 8, 0],
    [4, 0, 8, 0, 0, 0, 0, 11, 0],
    [0, 8, 0, 7, 0, 4, 0, 0, 2],
    [0, 0, 7, 0, 9, 14, 0, 0, 0],
    [0, 0, 0, 9, 0, 10, 0, 0, 0],
    [0, 0, 4, 14, 10, 0, 2, 0, 0],
    [0, 0, 0, 0, 0, 2, 0, 1, 6],
    [8, 11, 0, 0, 0, 0, 1, 0, 7],
    [0, 0, 2, 0, 0, 0, 6, 7, 0],
]

print(dijkstra(graph, 0, 9))
# [0, 4, 12, 19, 21, 11, 9, 8, 14]