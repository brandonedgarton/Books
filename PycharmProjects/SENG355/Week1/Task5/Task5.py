print("Welcome to my real estate average price calculator!")

neighborhood = input("Enter the neighborhood name: ")
numOfProperties = input("Enter the number of properties you want to calculate: ")

x = 1
total = 0
while x <= int(numOfProperties):
    answer = input("Would you like to add the price of one more house? (y for yes or n for no)")
    if answer == "y":
        housePrice = input("Enter house price: ")
        total += int(housePrice)
    x += 1

avgHousePrice = total / int(numOfProperties)
print("The average house price in the " + neighborhood + " neighborhood is $" + str(avgHousePrice))

print("Thanks for using the App!")

