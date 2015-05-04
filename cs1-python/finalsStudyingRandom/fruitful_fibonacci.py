

def fib(n):
    """
    performs the fibonacci sequence which adds the two prvious terms together
    to make the third
    """
    if n == 1:
        return 1
    elif n ==0:
        return 0
    else:
        return fib(n-1) + fib(n-2)
print(fib(4))
