X = input("Enter first string: ")
Y = input("Enter second string: ")

m = len(X)
n = len(Y)

# dp[i][j] = length of LCS of X[0..i-1] and Y[0..j-1]
dp = []
for i in range(m + 1):
    row = []
    for j in range(n + 1):
        row.append(0)
    dp.append(row)

# Fill the table
for i in range(1, m + 1):
    for j in range(1, n + 1):
        if X[i - 1] == Y[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            if dp[i - 1][j] >= dp[i][j - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = dp[i][j - 1]

print("\nLength of LCS:", dp[m][n])

# Reconstruct the actual subsequence
i = m
j = n
result = []

while i > 0 and j > 0:
    if X[i - 1] == Y[j - 1]:
        result.insert(0, X[i - 1])
        i = i - 1
        j = j - 1
    elif dp[i - 1][j] >= dp[i][j - 1]:
        i = i - 1
    else:
        j = j - 1

print("LCS:", "".join(result))
