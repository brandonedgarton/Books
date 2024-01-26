def list_sum(my_list):
    if len(my_list) == 1:
        return my_list[0]
    else:
        return my_list[0] + list_sum(my_list[1:])

print("Enter a list of numbers (seperated by a space): ", end=" ")

my_list = list(map(int, input().strip().split()))

answer = list_sum(my_list)

print("Sum of elements entered: ", answer)