require_relative 'currency' 
require 'test/unit'          

class CurrencyTest < Test::Unit::TestCase 

  ### Add your tests here ###

  # assert_in_delta() is used to compare two floating point
  # values within a tolerance, or delta, to account for potential
  # rounding errors when performing floating point computations.
  
  def test_conversion_1
	assert_in_delta 58.59, convert( 'GBP', 35.0 ), 0.01
  end
  
  def test_conversion_2
	assert_in_delta 1.722, convert( 'CAN', 2.0 ), 0.01
  end
  
end
