
import turtle

SPEED = .5
NUM_LINES = 50
START_LENGTH = 1
END_LENGTH = 500
STEP = 10
ANGLE = 90

turtle.speed(SPEED)

for length in range(START_LENGTH, END_LENGTH, STEP):
    turtle.forward(length)
    turtle.left(ANGLE)
turtle.done()