n = int(input("Enter number of files: "))

length = []
for i in range(n):
    length.append(int(input(f"Enter length of file {i + 1}: ")))

# Sort the files in ascending order
for i in range(n - 1):
    for j in range(i + 1, n):
        if length[i] > length[j]:
            temp = length[i]
            length[i] = length[j]
            length[j] = temp

total = 0
retrieval = 0

# Calculate total retrieval time
for i in range(n):
    retrieval = retrieval + length[i]
    total = total + retrieval

average = total / n

print("Optimal order:", length)
print("Total Retrieval Time:", total)
print("Average Retrieval Time:", average)