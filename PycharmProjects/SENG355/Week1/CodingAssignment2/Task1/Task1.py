n = int(input("Enter the number of days that we have snow data for: "))

snow_data = []

for i in range(1, n + 1):
    inches = int(input(f"How many inches for day {i}? "))
    snow_data.append(inches)

print("Snow data entry complete!")

choice = int(input("\nChoose the next feature\n"
                    "Enter 1 to show the day with maximum snow\n"
                    "Enter 2 to show the day with minimum snow\n"
                    "Enter 3 to show how many days had more snow than a chosen threshold\n"))

if choice == 1:
    max_day = snow_data.index(max(snow_data)) + 1
    max_inches = max(snow_data)
    print(f"Day {max_day} had the maximum amount of snow. It had {max_inches} inches!!")
elif choice == 2:
    min_day = snow_data.index(min(snow_data)) + 1
    min_inches = min(snow_data)
    print(f"Day {min_day} had the minimum amount of snow. It had {min_inches} inches!!")
elif choice == 3:
    k = int(input("Enter the threshold value: "))
    days_above_k = sum(inches > k for inches in snow_data)
    print(f"{days_above_k} days had more than {k} inches of snow.")
else:
    print("Invalid choice. Please choose a valid option.")
