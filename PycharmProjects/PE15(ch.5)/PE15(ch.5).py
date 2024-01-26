score1 = float(input("Enter 1st score: "))
score2 = float(input("Enter 2nd score: "))
score3 = float(input("Enter 3rd score: "))
score4 = float(input("Enter 4th score: "))
score5 = float(input("Enter 5th score: "))

scores_total = score1 + score2 + score3 + score4 + score5

def calc_average(scores_total):
    return scores_total / 5

def determine_grade(grade):
    if grade >= 90 and grade <= 100:
        return "A"
    elif grade < 90 and grade >= 80:
        return "B"
    elif grade < 80 and grade >= 70:
        return "C"
    elif grade < 70 and grade >= 60:
        return "D"
    else:
        return "F"

grade = scores_total
ave = calc_average(scores_total)
letter_grade = determine_grade(grade)

print(f"Score 1: {determine_grade(score1)}")
print(f"Score 2: {determine_grade(score2)}")
print(f"Score 3: {determine_grade(score3)}")
print(f"Score 4: {determine_grade(score4)}")
print(f"Score 5: {determine_grade(score5)}")
print(f"Average: {calc_average(scores_total)}")



