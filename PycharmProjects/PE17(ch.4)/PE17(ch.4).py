
import turtle
STARTING_STEP = 45
ANGLE = 135
NUM_LINES = 8
LENGTH = 200
SPEED = .6

turtle.hideturtle()
turtle.speed(SPEED)
turtle.left(STARTING_STEP)

for count in range(NUM_LINES):
    turtle.forward(LENGTH)
    turtle.left(ANGLE)