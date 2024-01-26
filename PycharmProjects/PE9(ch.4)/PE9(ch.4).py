
total = 0
print("Ocean Level\t\tRise Per Year")
print("------------------------------")
for rise in range(1,26):
    total += 1.6
    print(f"\t{rise}\t\t\t{total:.1f} millimeters")
