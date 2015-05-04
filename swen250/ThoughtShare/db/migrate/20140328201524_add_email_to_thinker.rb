class AddEmailToThinker < ActiveRecord::Migration
  def self.up
     add_column :thinkers, :email, :string
	 #adds a column of emails that each thinker has, defines as a string.
  end

  def self.down
     remove_column :thinkers, :email
	 #removes a column of emails for the thinkers.
  end
  
end
