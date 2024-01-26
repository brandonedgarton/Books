print("Welcome to my real estate average price calculator!")

neighborhood = input("Enter the neighborhood name: ")
numOfProperties = input("Enter the number of properties you want to calculate: ")

housePriceList = []

x = 1
total = 0

while x <= int(numOfProperties):
    answer = input("Would you like to add the price of one more house? (y for yes or n for no)")
    housePrice = input("Enter house price: ")
    if answer == "y":
        housePriceList.append(housePrice)
        total += int(housePrice)
    x += 1

avgHousePrice = total / int(numOfProperties)
Length = str(len(housePriceList))
#Sum = str(sum(housePriceList))
Max = str(max(housePriceList))
Min = str(min(housePriceList))

print("You have entered " + Length + " values, sum is $" + str(total) + ", max is $" + Max + ", min is $" + Min + ".")
print("The average house price in the " + neighborhood + " neighborhood is $" + str(avgHousePrice) + ".")

print("Thanks for using the App!")