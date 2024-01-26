import math

def is_prime(num):
    if num % 2 == 0:
        return False
    else:
        return True


for num in range(2, 100):
    if is_prime(num) == True:
        print(num)
