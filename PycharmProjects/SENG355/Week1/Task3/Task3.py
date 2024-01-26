firstName = input("Enter your first name: ")

fictCharName = input("Enter your favorite fictional character's name: ")

name_first_letter = firstName[0]
fictName_first_letter = fictCharName[0]

if len(firstName) == len(fictCharName) and firstName[0] == fictCharName[0]:
    print("Same first letter and length is the same, coincidence? I think not!")
elif len(firstName) == len(fictCharName):
    print("Length is the same, coincidence? I think not!")
elif firstName[0] == fictCharName[0]:
    print("Same first letter, coincidence? I think not!")
else:
    print("NOT the same first letter and length is NOT the same!")
