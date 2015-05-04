# Currency Calculator

  # Currency conversion rates for one USD
  RATES = Hash[
             'GBP' => 1.674,
			 'CAN' => 0.861,
			 'CHF' => 1.137,
			 'EUR' => 1.38,
			 'SEK' => 0.156,		
			 'USD' => 1.0
             ]


#keys = []
#values = []
#RATES.each do |keys, values|
#    keys.push(keys)
#    values.push(values)
#end#do loop
#puts "keys; #{keys}"
#puts "values; #{values}"

# Given a currency code and floating point units of that currency,
# return the equivalent USD as a floating point value.
def convert( currency_code, value )
keys = []
values = []
RATES.each do |keys, values|
    keys.push(keys)
    values.push(values)
  end#do loop

calculated = 0.0
    if currency_code == keys[0]
        calculated = value * values[0]
    elsif currency_code == keys[1]
        calculated = value * values[1]
    elsif currency_code == keys[2]
        calculated = value * values[2]
    elsif currency_code == keys[3]
        calculated = value * values[3]
    elsif currency_code == keys[4]
        calculated = value * values[4]
    elsif currency_code == keys[5]
        calculated = value * values[5]
    elsif currency_code == keys[6]
        calculated = value * values[6]
    end
return calculated
end#convert
# Return the floating point result of the given operation ('+'/'-') 
# using the two floating point value parameters. 
def compute( operator, value_1, value_2 ) 
	
	return 0.0	 # place holder
end#compute

# Given an input string in CSV format, return an array
# of values.
def parse_line( line )
	array = []
    array2 = []
    array = line.chomp.split(',')
    count = 0
    array.each do |index|
        farray[count] = index
        count +=1
    end
#puts array2
    return array2
end#parse

# This is a Ruby idiom that allows us to use both unit testing and command line processing
# This gets run with ruby currency.rb
# Does not get run when we use unit testing, e.g. ruby currency_test.rb

# For each line of CSV input:
#	- parse the input line into appropriate fields
#	- convert the currencies to USD
#   - perform the computation requested
#   - output the result as "Result = xx.xx USD"
#		where xx.xx is USD rounded to the nearest cent

if __FILE__ == $PROGRAM_NAME
  $stdin.each do |line|
    puts line
    Currency.Parse_line(line)
		
  end
end




