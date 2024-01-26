
quantity = int(input("Enter the number of packages purchased: "))
discount1 = .10
discount2 = .20
discount3 = .30
discount4 = .40
price = 99


if quantity <= 9:
    total = price * quantity
    print(f"Total: {total}")

if quantity >= 10 and quantity <= 19:
    saved = (price * quantity) * discount1
    total = (price * quantity) - saved
    print(f"Total: {total} \nAmount Saved: {saved}")

if quantity >= 20 and quantity <= 49:
    saved = (price * quantity) * discount2
    total = (price * quantity) - saved
    print(f"Total: {total} \nAmount Saved: {saved}")

if quantity >= 50 and quantity <= 99:
    saved = (price * quantity) * discount3
    total = (price * quantity) - saved
    print(f"Total: {total} \nAmount Saved: {saved}")

if quantity >= 100:
    saved = (price * quantity) * discount4
    total = (price * quantity) - saved
    print(f"Total: {total} \nAmount Saved: {saved}")

