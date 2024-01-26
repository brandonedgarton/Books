number = input("Enter a series of single-digit numbers with nothing seperating them.")
total = 0

for num in number:
    total += int(num)


print("The sum is", total)


