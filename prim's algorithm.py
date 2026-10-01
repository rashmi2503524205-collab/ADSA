INF = float("inf")

def min_key(key, mst_set, n):
    min_val = INF
    min_index = -1

    for v in range(n):
        if not mst_set[v] and key[v] < min_val:
            min_val = key[v]
            min_index = v

    return min_index


def prim_mst(graph, n):
    parent = [-1] * n        # stores the constructed MST
    key = [INF] * n          # smallest edge weight connecting each vertex to the MST
    mst_set = [False] * n    # vertices already included in the MST

    key[0] = 0               # start from vertex 0 (root, parent = -1)

    for _ in range(n - 1):
        # pick the minimum key vertex not yet in the MST
        u = min_key(key, mst_set, n)
        if u == -1:          # remaining vertices unreachable (disconnected graph)
            break

        mst_set[u] = True

        # update key and parent of adjacent vertices of u
        for v in range(n):
            if graph[u][v] and not mst_set[v] and graph[u][v] < key[v]:
                parent[v] = u
                key[v] = graph[u][v]

    # print the MST
    print("Edge \tWeight")
    for i in range(1, n):
        if parent[i] != -1:
            print(f"{parent[i]} - {i} \t{graph[i][parent[i]]}")


# Example
graph = [
    [0, 2, 0, 6, 0],
    [2, 0, 3, 8, 5],
    [0, 3, 0, 0, 7],
    [6, 8, 0, 0, 9],
    [0, 5, 7, 9, 0],
]

prim_mst(graph, 5)