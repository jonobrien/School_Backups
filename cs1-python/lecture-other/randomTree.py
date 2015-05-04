from turtle import *
import random
speed(0)
def drawTree(length, Segments):
	if(Segments <=1 or length<10):
		circle(2)
		return
	b = random.randint(int(length/2), length+1)
	a = random.randint(1, 45)
	forward(b)
	left(a)
	drawTree(b, Segments-1)
	right(2*a)
	drawTree(b, Segments-1)
	left(a)
	back(b)

left(90)
up()
back(300)
down()
drawTree(int(input("length?")), int(input("Segments?")))
a=input("enter=close")
bye()
