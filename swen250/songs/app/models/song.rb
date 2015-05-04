class Song < ActiveRecord::Base
	validates :year, {:numericality => true, :presence => true}
#validates year, numericality: true, presence: true
#year and presence are symbols, mapping to a unique number
belongs_to :author
	end
