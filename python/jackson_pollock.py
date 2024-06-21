import turtle
import random
'''
start with a list of turtles
make an infinate loop
in the loop:
for each turtle:
-> change color
-> turn it a random direction between 30 deg and -30 deg
-> go forward
'''

turtles = [turtle.Turtle() for _ in range(10)]
colors = ["red", "orange", "yellow", "green", "blue", "indigo", "violet"]
for i, t in enumerate(turtles):
    t.penup()
    t.goto(random.randint(-300, 300), random.randint(-300, 300))
    t.pendown()

def step(t):
    t.right(random.randint(-30, 30))
    t.color(colors[random.randrange(0, len(colors))])
    t.forward(10)
    if t.xcor() > 300 or t.xcor() < -300 or t.ycor() > 300 or t.ycor() < -300:
        t.right(180)
        t.forward(10)

def square(t):
    for _ in range(4):
        t.forward(100)
        t.right(90)

while True:
    for t in turtles:
        step(t)
        if random.random() < 0.1:
            square(t)
