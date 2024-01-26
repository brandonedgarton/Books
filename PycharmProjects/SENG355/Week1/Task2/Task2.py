import random

numOfPplLivingInHouse = input("Hello! Welcome to the chore selector! Enter the number of people living in the house:")

print("Alright! today it is the turn of person " + str(random.randrange(1, int(numOfPplLivingInHouse)))
      + " to do the dishes!")