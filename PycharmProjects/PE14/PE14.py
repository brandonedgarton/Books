
P = float(input("Enter amount of principal originally deposited into the account."))
r = float(input("Enter annual interest rate paid by the account as a percentage decimal."))
n = float(input("Enter the number of times per year interest is compounded."))
t = float(input("Enter the number of years the account will be left to earn interest."))

A = P * (1 + (r / n)) ** (n * t)

print(f"{A:.2f} will be in the account after {t} years.")