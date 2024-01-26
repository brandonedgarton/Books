


organisms = int(input("Enter starting number of organisms: "))

aveDailyIncrease = float(input("Enter average daily population"
                               " increase (as percentage) : " ))
aveDailyIncrease = aveDailyIncrease / 100
numOfDays = int(input("Enter the number of days the organism will be"
                      " left to multiply: "))

print("Day Approximate\t\tPopulation")
print("-----------------------------")

for day in range(2, numOfDays + 1):
    increase = organisms * aveDailyIncrease
    organisms = organisms + increase
    print(day, "\t\t\t\t", organisms)