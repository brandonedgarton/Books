num = int(input("Enter a nonnegative number: "))
total = 1
for n in range(1, num + 1):
    total *= n
    print(f"The factoral of {num} is {total}")