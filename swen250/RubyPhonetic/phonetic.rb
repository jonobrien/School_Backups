# Convert to/from phonetic alphabet
# Jon O'Brien

class Phonetic

  Letters = [
             ['A', 'ALPHA'],
             ['B', 'BRAVO'],
             ['C', 'CHARLIE'],
             ['D', 'DELTA'],
             ['E', 'ECHO'],
             ['F', 'FOXTROT'],
             ['G', 'GOLF'],
             ['H', 'HOTEL'],
             ['I', 'INDIA'],
             ['J', 'JULIET'],
             ['K', 'KILO'],
             ['L', 'LIMA'],
             ['M', 'MIKE'],
             ['N', 'NOVEMBER'],
             ['O', 'OSCAR'],
             ['P', 'PAPA'],
             ['Q', 'QUEBEC'],
             ['R', 'ROMEO'],
             ['S', 'SIERRA'],
             ['T', 'TANGO'],
             ['U', 'UNIFORM'],
             ['V', 'VICTOR'],
             ['W', 'WHISKEY'],
             ['X', 'XRAY'],
             ['Y', 'YANKEE'],
             ['Z', 'ZULU'],
             ]

  # Translate a word to its phonetic alphabet equivalent
  
  def self.to_phonetic(word)
    individual = []
    keysAA = []
    valuesAA = []
    newString = ""
    Letters.each do |keys, values|
        keysAA.push(keys)
        valuesAA.push(values)
    end
    individual = word.upcase.chomp.split("")
    individual.each do |words|
            for ix in 0..(keysAA.size()-1)
                if words == keysAA[ix]
                   newString += valuesAA[ix] + " "
                end
            end
         end
    newString.strip!
    
    #puts newString
    return newString
    end

  # Translate a sequence of phonetic alphabet code words 
  # to their alphabetic equivalent
  def self.from_phonetic(str)
    str.chomp!
    strArray = []
    strArray = str.upcase.split(" ")
    valuesAA = []
    keysAA = []
    
    word = ""
    Letters.each do |keys, values|
        keysAA.push(keys)
        valuesAA.push(values)
    end
    
    strArray.each do |letters|
        for ix in 0..(valuesAA.size()-1)
            if letters == valuesAA[ix]
                word += keysAA[ix]
            end
        end
    end
    word.strip!
    #puts word
    return word
    
end

  # If the line starts with A2P, call to_phonetic on the rest of the substring
  # If the line starts with P2A, call from_phonetic on the rest of the substring
  # Otherwise, return nothing.
  def self.translate(line)
    #line.split(/ +/)
    if line[0..3] == "A2P "
        #puts line
        return Phonetic.to_phonetic(line[4..-1])
    end
    if line[0..3] == "P2A "
        #puts ("P2A line: #{line}")
        return Phonetic.from_phonetic(line[4..-1])
    end
    
  end



# This is ruby idiom that allows us to use both unit testing and command line processing
# This gets run with ruby phonetic.rb
# Does not get run when we use unit testing, e.g. ruby phonetic_test.rb
if __FILE__ == $PROGRAM_NAME
  $stdin.each do |line|
    Phonetic.translate(line)
  end
end

end

