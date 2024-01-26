height = float(input("Enter your height in inches: "))
weight = float(input("Enter your weight in pounds: "))

bmi = (weight / (height * height)) * 703

if bmi < 18.5:
    print(f"Your BMI is {bmi: .1f}, you are under weight.")
if bmi >= 18.5 and bmi <= 25:
    print(f"Your BMI is {bmi: .1f}, your weight is optimal.")
if bmi > 25:
    print(f"Your BMI is {bmi: .1f}, you are overweight.")
