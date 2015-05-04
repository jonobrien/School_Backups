# factorial(n) is defined as n*n-1*n-2..1 for n > 0
# factorial(n) is 1 for n=0
# Let's raise an exception if factorial is negative
# Let's raise an exception if factorial is anything but an integer

def factorial(n)
  # Write the factorial code here per the activity

 #another implementation with rangefinding,each
# (2 .. n - 1).each {|i| n *= i}
# n

#implemented with an if statement
    if !(n.is_a? Integer)
        raise ArgumentError.new("string")  #("Error! This input is incorrect, must be a positive integer.")
    end
    if n == 0
        return 1
    end

    if n < 0
        raise ArgumentError.new("string") #("Error! This input is incorrect, must be a positive integer.")
    end
    
    if n > 0
       return  n * factorial(n - 1)
    end
end
