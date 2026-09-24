MAX = 100
queue = [0] * MAX
front = -1
rear = -1
visited = [0] * MAX


def enqueue(vertex):
    global front, rear
    if rear == MAX - 1:
        return  # Queue full
    if front == -1:
        front = 0
    rear += 1
    queue[rear] = vertex


def dequeue():
    global front, rear
    if front == -1:
        return -1  # Queue empty
    vertex = queue[front]
    if front >= rear:
        front = -1
        rear = -1
    else:
        front += 1
    return vertex


def bfs(graph, start_vertex, vertices):
    for i in range(vertices):
        visited[i] = 0

    enqueue(start_vertex)
    visited[start_vertex] = 1

    print("BFS Traversal:", end=" ")

    while front != -1:
        current_vertex = dequeue()
        print(current_vertex, end=" ")

        for i in range(vertices):
            if graph[current_vertex][i] == 1 and visited[i] == 0:
                enqueue(i)
                visited[i] = 1
    print()


def main():
    vertices = int(input("Enter number of vertices: "))
    graph = [[0] * MAX for _ in range(MAX)]

    print("Enter adjacency matrix:")
    for i in range(vertices):
        row = input().split()
        for j in range(vertices):
            graph[i][j] = int(row[j])

    start_vertex = int(input("Enter start vertex: "))

    bfs(graph, start_vertex, vertices)


if __name__ == "__main__":
    main()