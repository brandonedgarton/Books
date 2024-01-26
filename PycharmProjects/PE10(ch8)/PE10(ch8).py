new_string = input("Enter string: ")

char_list = []
frequency = []

for ch in new_string.lower():
    if ch.isalnum():
        if ch not in char_list:
            char_list.append(ch)
            frequency.append(1)

        elif ch in char_list:
            index = char_list.index(ch)
            frequency[index] += 1

most_frequent = char_list[frequency.index(max(frequency))]

print(f"Most Frequent Character: {most_frequent}")

