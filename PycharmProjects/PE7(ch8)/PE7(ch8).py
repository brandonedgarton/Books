infile = open(text.txt, "r")

readlines = infile.read().splitlines()

upper_num = 0
lower_num = 0
digits_num = 0
whitespace_num = 0

for line in readlines:
    for ch in line:
        if ch.isupper():
            upper_num += 1
        elif ch.islower():
            lower_num += 1
        elif ch.isdigit():
            digits_num += 1
        elif ch.isspace():
            whitespace_num += 1

print(f"Uppercase letters in file: {upper_num}")
print(f"Lowercase letters in file: {lower_num}")
print(f"Digits in file: {digits_num}")
print(f"Whitespace characters in file: {whitespace_num}")
