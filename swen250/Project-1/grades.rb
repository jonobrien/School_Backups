require_relative 'grades_util'

# grades.rb Ruby Script
#
# Read the first row (column names) and second row (grade weights).
# If the weights don't sum up to 100, print an error message and exit.
# Otherwise print the column headers with their weights (empty weights simply don't print)
#
# For each student line, print the header and column for each field in the line.
# The field could be identifying information (if the weight is blank) or numeric (if the
# weight is non-negative). Grades can be numeric or letter (with optional +/-)
# Also prints final weighted numeric grade and letter grade.
#
# At end, prints a summary showing the number students for each letter grade and
# the class GPA.
#
# Create the hash for counting the number of occurrences of each letter grade.

lettercount = Hash.new(0)   # default count is 0.

# Use get_CSV_line() to get the header and weight lines.
# Each line should be "chomped" to eliminate the end of line character(s).
# Create arrays for the headers and weights by splitting on commas.

array2d = []
headers = []
weights = []

lineNum = 0
while line = gets
    fields = get_CSV_line(line)#get_CSV_line()
    array2d[lineNum] = fields
    lineNum += 1 
end
headers = array2d[0]#makes the individual arrays from the 2d-array
weights = array2d[1]

#calculates the total weights
weightsSum = sum_weights(headers, weights)

#begins output prints
puts "Summary information for grades file"
puts ""

#for each header, print the header and, if present, its weight.
for index in 0..(headers.length-1)
    if weights[index] == "" #last
        puts "#{headers[index]} #{weights[index]}"
    else
        puts "#{headers[index]} #{weights[index]}%"
    end
end

#Use sum__weights() to check if the weights do not sum to 100, output the error message:
# "Weights add up to #{sum}, not 100" - where sum is the sum of input weights
sum = sum_weights(headers, weights)
if sum != 100
    puts ""
    abort "Weights add up to #{sum}, not 100"
end

# Get each of the remaining lines, representing grade information for an individual student.
# Print the header for each column and whatever is in that column on the student grade line.
# Compute contribution of each weighted field to the overall grade using compute_grade(),
# remember to skip fields that do not have weights associated with them.
# Convert the numeric grade to a letter grade using numeric_to_letter().
# Output the final numeric and letter grade for that student and update the 
# lettercount hash that is keeping track of the number of occurrences of each letter grade
# for the class.
for line in 2..array2d.length-1
numbers = 0.0
    puts "" #spacing for students
    
    for word in 0..(headers.length-1)
        puts "#{headers[word]}: #{array2d[line][word]}"
        
        if array2d[line][word].to_i.to_s == array2d[line][word] #integer
            numbers += compute_grade(weights[word], array2d[line][word])
        
        else  #letter
            if array2d[line][word][0].match(/a|b|c|d|f|A|B|C|D|F/)
                lowercase = array2d[line][word].upcase
                    numbers += compute_grade(weights[word], lowercase)
                #end
            end
        end
    end
    letterGrade = numeric_to_letter(numbers)
    lettercount[letterGrade] +=1
    numbers = numbers.truncate
    puts "Final Numeric Grade = #{numbers} Letter =  #{letterGrade}"
end

# Now print the summary information - the number of students at each letter grade level
puts print_summary(lettercount) 

#FINISHED!

