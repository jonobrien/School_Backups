class Thinker < ActiveRecord::Base
  has_many :follows, :foreign_key => "follower_id", :class_name => "Follow"
  has_many :followed, :foreign_key => "followee_id", :class_name => "Follow"
  has_many :thoughts
  has_many :thumbs
  
  
  validates :name, length: {minimum: 1, maximum: 35}, allow_blank: false #defines min/max length
  #supposed to have unique thinker text
  validates :name, :uniqueness => true  
  #every different thought has a unique thinker(author)
  validates :name, :format => { :with => /^[a-zA-Z]{1}[a-zA-Z0-9' -]+$/ }
  #The name can only include upper-case letters, lower-case letters, numbers, 
  #spaces, hyphens, and apostraphes. The name must start with an upper-case or lower-case letter
  
  #URL validation
  validates :url, :format => { :with => URI::regexp(%w(http https)) } #ensures URLs start with either HTTP or HTTPS 
  validates :url, :uniqueness => true  #ensures unique URLs for each thinker
  validates :url, length: {minimum: 1, maximum: 120}, allow_blank: false #defines max length, no min length required
  #Email validation
  validates :email, :format => { :with => /\A[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]+\z/ } #restricts char. types
  #validation for email as well
  
end

