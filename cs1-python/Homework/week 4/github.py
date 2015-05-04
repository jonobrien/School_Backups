import math
 
PI = math.pi
 
def give_dots(R,r,r_,resolution=2*PI/1000,spins=5):
    
    def x(theta):
        return (R - r) * math.cos( theta ) + r_* math.cos( (R - r) / r * theta )
    
    def y(theta):
        return (R - r) * math.sin( theta ) - r_* math.sin( (R - r) / r * theta )
    
    theta = 0.0
    while theta < 2*PI*spins:
        yield (x(theta), y(theta))
        theta += resolution
 
 
if __name__=='__main__':
    
    from pylab import *
 
    dots = give_dots(4,1.98,1.1, spins=45)
 
    x,y = zip(*dots)
 
    plot(x,y)
    
    show()
