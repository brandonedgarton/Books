color1 = input("Enter your 1st primary color")
color2 = input("Enter your 2nd primary color")

if color1 == "red" and color2 == "blue":
    print("Your secondary color is purple.")
elif color1 == "red" and color2 == "yellow":
    print("Your secondary color is orange.")
elif color1 == "blue" and color2 == "yellow":
    print("Your secondary color is orange.")

elif color1 == "yellow" and color2 == "blue":
    print("Your secondary color is orange.")
elif color1 == "yellow" and color2 == "red":
    print("Your secondary color is orange.")
elif color1 == "blue" and color2 == "red":
    print("Your secondary color is purple.")
else:
    print("Error, pick blue, red, or yellow only!")
