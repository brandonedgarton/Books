from turtle import Turtle, Screen

NUMBER_SQUARES = 8
SQUARE_SIZE = 40
BOARD_SIZE = SQUARE_SIZE * NUMBER_SQUARES
BORDER_FRACTION = 1.025  # add a slight edge to board

STAMP_SIZE = 20  # size of turtle square image

turtle = Turtle(shape='square', visible=False)
turtle.shapesize(BOARD_SIZE / STAMP_SIZE * BORDER_FRACTION)
turtle.color('black')
turtle.stamp()

turtle.shapesize(SQUARE_SIZE / STAMP_SIZE)
turtle.color('white')
turtle.penup()

for y in range(-NUMBER_SQUARES//2, NUMBER_SQUARES//2):
    parity = y % 2 == 0

    for x in range(-NUMBER_SQUARES//2, NUMBER_SQUARES//2):
        if parity:
            turtle.goto(x * SQUARE_SIZE + SQUARE_SIZE//2, y * SQUARE_SIZE + SQUARE_SIZE//2)
            turtle.stamp()

        parity = not parity

Screen().exitonclick()