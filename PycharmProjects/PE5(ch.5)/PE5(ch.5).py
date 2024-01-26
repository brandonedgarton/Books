

property_value = float(input("Enter the value of your property: "))

assessment_value = property_value * .6

property_tax = (assessment_value / 100) * .72

print(f"Assessment Value: {assessment_value}")
print(f"Property Tax: {property_tax: .2f}")
