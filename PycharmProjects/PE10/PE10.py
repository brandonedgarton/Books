cookies = input("How many cookies do you want to make?")

single_batch = 48
double_batch = 96
triple_batch = 144
quadruple_batch = 192

if int(cookies) <= single_batch:
    print("You will need: 1.5 cups of sugar, 1 cup of butter, "
          "and 2.75 cups of flour.")
elif int(cookies) > single_batch and int(cookies) <= double_batch:
    print("You will need: 3 cups of sugar, 2 cup of butter, "
          "and 3.50 cups of flour.")
elif int(cookies) > double_batch and int(cookies) <= triple_batch:
    print("You will need: 4.5 cups of sugar, 3 cup of butter, "
          "and 8.25 cups of flour.")
elif int(cookies) > triple_batch and int(cookies) <= quadruple_batch:
    print("You will need: 6 cups of sugar, 4 cup of butter, "
          "and 11 cups of flour.")
elif int(cookies) > quadruple_batch:
    print("To many cookies will give you cavities!")