class Car:
    def __init__(self, year_model, make, speed = 0):
        self.year_model = year_model
        self.make = make
        self.speed = speed

    def accelerate(self):
        self.speed = self.speed + 5

    def brake(self):
        self.speed = self.speed - 5

    def get_speed(self):
        print("Current Speed:", self.speed)


new_car = car.Car("2022" , "Subaru", 10)

for i in range(5):
    if (i == 0):
        print("Car accelerating \n")
    else:
        print("Car accelerating again \n")

for i in range(5):
    if (i == 0):
        print("Car braking \n")
    else:
        print("Car braking again \n")

print("Current Speed: ", self.speed)