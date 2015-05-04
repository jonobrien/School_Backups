# grades_util.rb Rubiy Script
#
# Support methods used by grades.rb for reading CSV gradebook files
# and producing reports
#

##### TRANSLATION HASH FOR LETTER GRADES TO NUMERIC #####

LETTER_TO_NUMERIC = {
  "A+" => 98, "A" => 95, "A-" => 92,
  "B+" => 88, "B" => 85, "B-" => 82,
  "C+" => 78, "C" => 75, "C-" => 72,
  "D+" => 68, "D" => 65, "D-" => 62,
  "F+" => 55, "F" => 40, "F-" => 25,
}

##### TRANSLATION OF LETTER GRADES TO QUALITY POINTS #####

QUALITY_POINTS = { 'A' => 4, 'B' => 3, 'C' => 2, 'D' => 1, 'F' => 0 }


# sum_weights( headers, weights)
#	headers = array of header strings (1st line of input)
#	weights = array of weights strings (2nd line of input)
# returns integer value equal to the sum of all weights
#
# Method to sum up the weights in the weight line. 
# Skips over empty fields.
def sum_weights(headers, weights)
weightsSum = 0
#puts "headers: #{headers}"
#puts "weights: #{weights}"
weights.each do |index|
    if index != "" #ignore empty fields
        weightsSum += (index.to_i)
    end
end
#puts "weightsSum:  #{weightsSum}"
#if weightsSum != 100
#    raise ArgumentError.new("Weights add up to #{weightsSum}, not 100")
#    end
    
return weightsSum
end#end


# numeric_to_letter(numeric)
#	numeric =  integer value to convert to a whole letter grade
# return letter grade as a string
#
# Method to convert a raw numeric grade to a whole letter A - F.
# A (90-100), B (80-89), C (70-79), D (60-69), F (<60)
def numeric_to_letter(numeric)
    if numeric < 101 and numeric > 89
        numeric = "A"
    elsif numeric < 90 and numeric > 79
        numeric = "B"
    elsif numeric < 80 and numeric > 69
        numeric = "C"
    elsif numeric < 70 and numeric > 59
        numeric = "D"
    elsif numeric < 60
        numeric = "F"
    end
#
#
return numeric
end#end


# get_CSV_line(line)
#	line = string of one line of input
# returns array of strings representing fields in that line
# Get a CSV line for the header line, weight lines or field line
# Each line should be "chomped" to eliminate the end of line character(s).
# Create arrays for the headers, weights and fields by splitting on commas.
def get_CSV_line( line )
array = []
fArray= []
array = line.chomp.split(',')
count = 0
array.each() do |index|
    fArray[count] = index
    count += 1
    end
return fArray
end#end


# compute_grade(weight,field)
# 	weight = string value representing weight of the graded item
#   field = string value representing value of graded item in numeric or letter grade format
# returns floating point grade value
#
# Compute a numeric grade given the weight of the grade and either a numeric 
# score or letter score in the field. 
def compute_grade(weight,field)
weight = weight.to_f
grade = 0.0
number = 0
newWeight = 0.0
newWeight = weight/100
if  field.to_i.to_s == field || field.to_f.to_s == field #number
    grade = field.to_f * newWeight
else #letter
    num = LETTER_TO_NUMERIC[field.upcase]
    grade = num.to_f * newWeight
end
return grade.round(2)
end #end


# print_summary(lettercount)  - !!! DO NOT MODIFY !!!
#	lettercount = hashsa of letter grades => count of number of students
# Prints summary information. First the count of the number of students for each
# letter grade and then the class GPA.

def print_summary(lettercount)
  qualty_points = 0
  grade_count = 0

  ['A', 'B', 'C', 'D', 'F'].each do | letter |
    puts "#{letter} = #{lettercount[letter]}"
    qualty_points += QUALITY_POINTS[letter] * lettercount[letter]
    grade_count += lettercount[letter]
  end

  printf "Class GPA = %1.2f", qualty_points.to_f / grade_count.to_f
  puts
end

