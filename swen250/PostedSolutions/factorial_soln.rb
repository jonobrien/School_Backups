# factorial(n) is defined as n*n-1*n-2..2 for n > 0
# factorial(n) is 1 for n=0
# Let's raise an exception if factorial is negative
# Let's raise an exception if factorial is anything but an integer

def factorial(n)
  raise ArgumentError, "Non-negative numbers only!" unless n.is_a? Numeric and n >= 0
  total = 1
  for i in 2..n
    total = total * i
  end
  return total
end
