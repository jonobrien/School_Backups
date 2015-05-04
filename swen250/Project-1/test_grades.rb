require_relative 'grades_util'
require 'test/unit'

# TetsGrades
#
# Unit test suite for testing grades_util.rb support methods:
#	compute_grade()
#	get_CSV_line()
#	numeric_to_letter()
#	sum_weights()

class TestGrades < Test::Unit::TestCase
   
  # Tests get_CSV_line to insure the entered input line
  # is correctly be parsed to an array of string words
  #
  def test_header_line
	headers = get_CSV_line("Name,ID,Grade")		# pass in an input string 
	assert_equal headers, ["Name","ID","Grade"] # return an array of header words
  end
  
  ####  YOUR ADDITIONAL UNIT TESTS START HERE  ####

  def test_weights_CSV
    weights = get_CSV_line(",,50,40,10")
    assert_equal weights, ["","","50","40","10"]
  end


  def test_sum_weights_100
    headers = ["Last","First","Exam","Homework","Attendance"]
    weights = ["","","50","40","10"]
    assert_equal sum_weights(headers,weights), 100
  end

  def test_sum_weights_200
    headers = ["Last","First","Exam","Homework","Attendance"]
    weights = ["","","50","90","60"]
    assert_equal sum_weights(headers,weights),200
  end


  def test_numeric_to_letter
    assert_equal numeric_to_letter(98),"A"
  end

  def test_numeric_to_letter_edge
    assert_equal numeric_to_letter(80), "B"
  end
 
  def test_numeric_to_letter_middle
    assert_equal numeric_to_letter(69), "D"
  end



  def test_compute_grade_num
    assert_equal compute_grade("30","50"), 15.00
  end

  def test_compute_grade_letter_upper
    assert_equal compute_grade("50","A"), 47.50
  end

  def test_compute_grade_lower
    assert_equal compute_grade("95","b"), 80.75
  end

  def test_compute_grade_symbol
    assert_equal compute_grade("30","a+"), 29.40
  end

end 
