INF = 9999

n = int(input("Enter number of vertices: "))

print("Enter adjacency matrix row by row (use", INF, "for INF, 0 on diagonal):")
graph = []
for i in range(n):
    row = input().split()
    for j in range(n):
        row[j] = int(row[j])
    graph.append(row)

# Initialize distance matrix
dist = []
for i in range(n):
    row = []
    for j in range(n):
        row.append(graph[i][j])
    dist.append(row)

# Find all-pairs shortest paths
for k in range(n):
    for i in range(n):
        for j in range(n):
            if dist[i][k] != INF and dist[k][j] != INF:
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

# Display shortest distance matrix
print("\nShortest distance matrix:")
for i in range(n):
    for j in range(n):
        if dist[i][j] == INF:
            print("INF", end="\t")
        else:
            print(dist[i][j], end="\t")
    print()