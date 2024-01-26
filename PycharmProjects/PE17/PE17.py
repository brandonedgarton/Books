
print("Reboot the computer and try to connect.")

response1 = input("Did that fix the problem? ")

if response1 == "yes":
    print("Problem solved!")
elif response1 == "no":
    print("Reboot the router and try to connect.")

response2 = input("Did that fix the problem? ")
if response2 == "yes":
    print("Problem solved!")
elif response2 == "no":
    print("Make sure the cables between the /"
            "router & modem are plugged in firmly.")

response3 = input("Did that fix the problem? ")
if response3 == "yes":
    print("Problem solved!")
elif response3 == "no":
    print("Move the router to a new location/"
             " and try to connect.")

response4 = input("Did that fix the problem? ")
if response4 == "yes":
    print("Problem solved!")
elif response4 == "no":
    print("Get a new router.")