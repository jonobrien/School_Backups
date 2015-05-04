#! /usr/bin/env ruby
def mainFunc()
    bag = Hash
    collection = []
    sortedArray = []
    sorted = []
    $stdin.each do |lines| 
    sentence = lines.chomp.downcase.gsub(/[^a-z ]/i, "").split(/ +/)
    collection.push(sentence)
    bag = Hash.new(0)   #  { |hash, key| hash[key] = 0}
        collection.each do |cutSentences|
            cutSentences.each do |word|
                bag[word] +=1
            end
        end
    end
    
    #pritns the words on a new line per word
    #bag.each { |key, value| print key, ' = ', value, "\n" }

    #checks for instances of words that appear at least 2 times
    twoOcc = bag.select { |key, value| value >= 2}

    #prints the words that appear at least 2 times, one word per line
    #twoOcc.each { |key, value| print key, ' = ', value, "\n" }   
 
    #sorts through the elements in the key/value pairs
    sorted = twoOcc.sort{|key, value| value[1] <=> key[1]}.each { |elem|
        "#{elem[0]} = #{elem[1]}" }

    #puts sorted elements into a new array
    sorted.each do |key, value|
        sortedArray.push(key)
    end

    #find lengths of the words, and the longest
    wdLength = sortedArray.inject(0) do |lengths, word|
        lengths >= word.length ? lengths : word.length
    end
    
    wordLength = sortedArray.each do |word|
        longestNum = word
        if longestNum.size < word.size
            longestNum = word
        end
end
    sorted.each { |key, value| printf("%-15.15s%s\n",key,"*"*Integer(value))}

    #end

#should print the lengths of the words I think
#puts ("sortedArray:#{sortedArray}")
#puts ("sorted:#{sorted}")

#need to find out how to print the asterisks
#need to find out how to argV 

end
mainFunc()







    #according to instructions, this should print
    #each word on a separate line at this point.


    #letters = lines.downcase.gsub(/[^a-z]/, "")
    #spaces = letters.gsub(/[^s\, ""]/)
    #line_words = spaces.each{|word|puts "word: #{word}" }
    #string.chomp!
    #string.gsub!(/[^a-z ]/, "")
    #string.split(/ +/)
    #puts "word: #{words}"
    #prints each line
#File.open('totc.txt', 'r') do |f1|
#  while line = f1.gets
#    puts line
#  end
#
#line = gets
#puts "The line was #[line]"
#takes user input, after enter is pressed, will run code, but loops
#
#end

