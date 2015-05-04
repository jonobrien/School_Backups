# Script that obtains various git metrics from a basic git log file
require 'date'

# Given an array of git log lines, count the number of commits in the log
def num_commits(lines)


  commits = []
  num_commits = -1#-1 to account for indexing
    lines.each do |line|
        if line.start_with?("commit ")
            num_commits += 1
            commits[num_commits] = line
        end
    end
num_commits +=1#fix count for indexing
return (num_commits)
end #end


# Given an array of git log lines, count the number of different authors
#   (Don't double-count!)
def num_developers(lines)
authors = []
diff_authors = []
num_developers = 0
index = -1
count = 0
lines.each do |line|
    if line.start_with?("Author: ")
        index +=1
        authors[index] = line
    end
    end
#puts "authors: #{authors}"
diff_authors = authors.uniq!
#puts "diff_authors: #{diff_authors}"
num_developers = diff_authors.size()
return num_developers
end #end


# Given an array of Git log lines, compute the number of days this was in development
# Note: you cannot assume any order of commits (e.g. you cannot assume that the newest commit is first).
def days_of_development(lines)
dates = []
days_of_development = 0
index = -1
lines.each do |line|
    if line.start_with?("Date: ")
        dates.push(DateTime.parse(line[8..-1]))
        dates = dates.sort
        #puts dates
        first = dates[0]
        last = dates[-1]
        days_of_development = (last - first).to_i
    end
    end
return days_of_development
end #end
# This is ruby idiom that allows us to use both unit testing and command line processing
# Does not get run when we use unit testing, e.g. ruby phonetic_test.rb
# These commands will invoke this code with our test data: 
#    ruby git_metrics.rb < ruby-progressbar-short.txt
#    ruby git_metrics.rb < ruby-progressbar-full.txt
if __FILE__ == $PROGRAM_NAME
  lines = []
  $stdin.each { |line| lines << line }
  puts "Nunber of commits: #{num_commits lines}"
  puts "Number of developers: #{num_developers lines}"
  puts "Number of days in development: #{days_of_development lines}"
end #end
