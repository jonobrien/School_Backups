require_relative 'git_metrics'
require 'test/unit'
require 'date'
class TestGitMetrics < Test::Unit::TestCase

  def test_commit_example
  	assert_equal 2, num_commits(["commit abc", "commit 123"]), "Should have counted two commits"
  end

  def test_dates_with_three_days
  	exp = [ "Date:  Sun Jan 26 21:25:22 2014 -0600", \
  			"Date:  Sun Jan 23 21:25:22 2014 -0600", \
  			"Date:  Sun Jan 25 21:25:22 2014 -0600"]
    assert_equal 3, days_of_development(exp), "Should have been a 3 days difference"
  end

  #Add here
  def test_same_author
    assert_equal 1, num_developers(["Author: Jon", "Author: Jon"]), "Should have counted one author."
  end

  def test_diff_authors_with_repeat
    assert_equal 3, num_developers(["Author: Jon", "Author: Bob", "Author: Jon", "Author: Fred"]), "Should have counted three authors."
  end

  def test_commit_uppercase
    assert_equal 2, num_commits(["Commit abc", "cOmMiT 123", "commit bca", "commit 321"]), "Should have counted two commits."
  end

  def test_commit_many
    assert_equal 5, num_commits(["commit abc", "commit 123", "commit 321", "commit cba", "commit 1337"]), "Should have counted  5 commits."
  end


  def test_date_ordered
    exp = [ "Date: Sun Jan 25 21:25:22 2014 -0600", \
            "Date: Sun Jan 26 21:25:22 2014 -0600", \
            "Date: Sun Jan 27 21:25:22 2014 -0600"]
    assert_equal 2, days_of_development(exp), "Should have been 2 days difference."
  end

  def test_date_reversed
    exp = [ "Date: Sun Jan 27 21:25:22 2014 -0600", \
            "Date: Sun Jan 26 21:25:22 2014 -0600", \
            "Date: Sun Jan 25 21:25:22 2014 -0600"]
    assert_equal 2, days_of_development(exp), "Should have been 2 days difference."

  end






end
