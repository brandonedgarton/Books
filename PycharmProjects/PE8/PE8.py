food_charge = int(input("How much did you pay for food?"))
tip = .18 * food_charge
sales_tax = 0.07 * food_charge
total = food_charge + tip + sales_tax


print(f"Sales Tax: ${sales_tax: .2f}")
print(f"Tip Amount: ${tip: .2f}")
print(f"Total Amount Spent: ${total: ,.2f}")