#histogram for counting letter appearances

def histogram

    #create file, temporary string of charachers, and hash for final storage
    file = File.new("TomSawyer.txt","r")
    templetters = ''
    letters = Hash.new { |hash, key| hash[key] = 0 }
    
    #go through the file and read into the string while sanitizing text
    file.each_line do |line|

        line.chomp!
        line.downcase!

        templetters << line
    
    end

    #cut out anything left that is not a letter (everything is already lowercase)
    templetters.gsub!(/[^a-z]/, '')

    #transfer letters to hash while tallying them up
    templetters.split("").each do |char|
        letters[char] += 1
    end

    #setting the letter with the highest appearances in the text
    max = letters.max_by{|k,v| v}[1] * 1.0
    
    # The letter with the most appearances will 
    # have the maximum of 70 stars. All others will 
    # be set relative to this letter.
    #
    # Prints out the histogram as it does this.
    letters.sort.each do |item|
        num_of_stars_to_print = (item[1] / max * 70).round
        stars = ""
        for i in 1..num_of_stars_to_print
            stars << "*"
        end

        puts "#{item[0]} : #{stars}"

    end




end







