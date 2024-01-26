num = int(input("Enter a number: "))

def isPrime(num):
    if num % 2 == 0:
        return False
    else:
        return True

print(f"Is your number a prime number? Answer: {isPrime(num)}.")
