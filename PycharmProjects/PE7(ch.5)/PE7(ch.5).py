A_SEATS = 20
B_SEATS = 15
C_SEATS = 10

a_seats_sold = int(input("A seats sold: "))
b_seats_sold = int(input("B seats sold: "))
c_seats_sold = int(input("C seats sold: "))

a_seats_total = a_seats_sold * A_SEATS
b_seats_total = b_seats_sold * B_SEATS
c_seats_total = c_seats_sold * C_SEATS

ticket_sales = a_seats_total + b_seats_total + c_seats_total

print(f"Amount generated from tickets sold: ${ticket_sales}")
