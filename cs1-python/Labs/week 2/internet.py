
import turtle
scale = 10
## Letter A
turtle.down ( )
# Point upwards to begin
turtle.left ( turtle.heading ( ) + 90 )
turtle.right ( 20 )
turtle.forward ( 10 * scale )
turtle.right ( 70 )
turtle.forward ( 1 * scale )
turtle.right ( 70 )
turtle.forward ( 10 * scale )
turtle.backward ( 5 * scale )
turtle.right ( 90 + 20 )
turtle.forward ( 5 * scale )
#Move to right of letter and over 1 * scale
turtle.up ( )
turtle.backward ( 5 * scale )
turtle.left ( 110 )
turtle.forward ( 2 * scale )
turtle.left ( 70 )
turtle.forward ( 1 * scale )
## Letter B
turtle.down ( )
# Point upwards to begin
turtle.left ( turtle.heading ( ) + 90 )
turtle.forward ( 10 * scale )
turtle.right ( 90 )
turtle.forward ( 4 * scale )
turtle.right ( 90 )
turtle.forward ( 4 * scale )
turtle.left ( 90 )
turtle.backward ( 1 * scale )
turtle.forward ( 2 * scale )
turtle.right ( 90 )
turtle.forward ( 6 * scale )
turtle.right ( 90 )
turtle.forward ( 5 * scale )
# Move to right of letter
turtle.up ( )
turtle.right ( 180 )
turtle.forward ( 6 * scale )
## Letter C
turtle.down ( )
# Point upwards to begin
turtle.left ( turtle.heading ( ) + 90 )
turtle.forward ( 10 * scale )
turtle.right ( 90 )
turtle.forward ( 4 * scale )
turtle.backward ( 4 * scale )
turtle.left ( 90 )
turtle.backward ( 10 * scale )
turtle.right ( 90 )
turtle.forward ( 4 * scale )
# Move to right of letter
turtle.up ( )
turtle.forward ( 1 * scale )
# Pause
input ( "Press any key to end." )
