require_relative 'phonetic'
require 'test/unit'

class PhoneticTest < Test::Unit::TestCase

  def test_rit_to_phonetic
    assert_equal 'ROMEO INDIA TANGO', Phonetic.to_phonetic('RIT')
  end

  def test_line_rit_to_phonetic
    assert_equal 'ROMEO INDIA TANGO', Phonetic.translate('A2P RIT')
  end


  def test_abc_to_phonetic
    assert_equal 'ALPHA BRAVO CHARLIE', Phonetic.translate('A2P ABC')
  end

  def test_rit_from_phonetic
    assert_equal 'RIT', Phonetic.translate('P2A ROMEO INDIA TANGO')
  end

  def test_multiple_words_from_phonetic
    assert_equal 'RITABC', Phonetic.translate('P2A ROMEO INDIA TANGO ALPHA BRAVO CHARLIE')
  end

end
