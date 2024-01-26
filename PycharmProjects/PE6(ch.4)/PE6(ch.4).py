
print()
print("Celsius\tFahrenheit")
print("------------------")
for celsius in range(21):
    fahrenheit = (9 / 5 * celsius) + 32
    print(f"{celsius}\t\t{fahrenheit:.1f}")