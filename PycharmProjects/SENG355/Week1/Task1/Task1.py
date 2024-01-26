velociraptor = .05
stegosaurus = .10
triceratops = .15
tRex = .30
brachiosaurus = .50

membershipCategory = input("Enter your airline club membership category(uppercase for first letter of each name only):")
ticketPrice = input("Enter the price of your ticket:")

if membershipCategory == "Velociraptor":
    print("Your discount is 5%")
    discount = float(ticketPrice) * velociraptor
    print("You saved $" + str(discount) + "!")
elif membershipCategory == "Stegosaurus":
    print("Your discount is 10%")
    discount = float(ticketPrice) * stegosaurus
    print("You saved $" + str(discount) + "!")
elif membershipCategory == "Triceratops":
    print("Your discount is 15%")
    discount = float(ticketPrice) * triceratops
    print("You saved $" + str(discount) + "!")
elif membershipCategory == "T Rex":
    print("Your discount is 30%")
    discount = float(ticketPrice) * tRex
    print("You saved $" + str(discount) + "!")
elif membershipCategory == "Brachiosaurus":
    print("Your discount is 50%")
    discount = float(ticketPrice) * brachiosaurus
    print("You saved $" + str(discount) + "!")