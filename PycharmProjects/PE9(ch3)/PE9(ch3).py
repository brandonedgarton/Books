pocket = int(input("Enter a pocket number. "))

if pocket == 0:
    print("Your pocket is green.")

if pocket >= 1 and pocket <= 10:
    if pocket % 2 == 0:
        print("Your pocket color is black.")
    else:
        print("Your pocket color is red.")

if pocket >= 11 and pocket <= 18:
    if pocket % 2 == 0:
        print("Your pocket color is red.")
    else:
        print("Your pocket color is black.")

if pocket >= 19 and pocket <= 28:
    if pocket % 2 == 0:
        print("Your pocket color is black.")
    else:
        print("Your pocket color is red.")

if pocket >= 29 and pocket <= 36:
    if pocket % 2 == 0:
        print("Your pocket color is red.")
    else:
        print("Your pocket color is black.")

if pocket < 0 or pocket >= 36:
    print("Error! Pick a number between 0 and 36.")