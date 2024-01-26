fat_grams = float(input("Enter your fat grams consumed in a day: "))

carb_grams = float(input("Enter your carbohydrates consumed in a day: "))

cals_from_fat = fat_grams * 9

cals_from_carbs = carb_grams * 4

print(f"Calories from fat: {cals_from_fat: .2f}")
print(f"Calories from carbohydrates: {cals_from_carbs: .2f}")


