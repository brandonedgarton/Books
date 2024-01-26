first_file = open(firstfile.txt, r)
second_file = open(secondfile.txt, r)

lines1 = first_file.readline()
lines2 = first_file.readline()

first_file.close()
second_file.close()

unique_words1 = UniqueWords(lines1)
unique_words2 = UniqueWords(lines2)

print("Unique words in <<<firstfile.txt>>> are below.")
print(unique_words1)

print("Unique words in <<<secondfile.txt>>> are below.")
print(unique_words2)

print(f"List of words that are in both files: {unique_words1.intersection(unique_words2)}")

print(f"List of words that are in the first file and not the second file: {unique_words1.difference(unique_words2)}")

print(f"List of words that are in the second file and not the first file: {unique_words2.difference(unique_words1)}")

print(f"List of words that are in either file but not both files: {unique_words1.symmetric_difference(unique_words2)}")

def UniqueWords(lines):
    unique_words = set()
    for line in lines:
        for word in line.split():
            unique_words.add(word)
    return unique_words

