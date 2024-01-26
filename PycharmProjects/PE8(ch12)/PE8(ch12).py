def ackermann_func(m, n, s = "% s"):
    print(s % ("A(% d, % d)" % (m, n)))
    if m == 0:
        return n + 1
    if n == 0:
        return ackermann_func(m - 1, 1, s)
    n2 = ackermann_func(m, n - 1, s % ("A(% d, %% s)" % (m - 1)))
    return ackermann_func(m - 1, n2, s)

print("Enter a value of m and n: ", end=" ")
my_list = list(map(int, input().strip().split()))
answer = ackermann_func(my_list[0], my_list[1])
print("Ackermann Results")
print("Result: ", answer)
