row = int(input("Enter the length of the row, in feet:"))
end_post = int(input("Enter the amount of space used by an end-post assembly, in feet:"))
space = int(input("Enter the amount of space between the vines, in feet:"))

vines = (row - (2 * end_post)) / space

print(f"{vines} grapevines will fit in the row.")
