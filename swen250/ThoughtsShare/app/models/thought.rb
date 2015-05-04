class Thought < ActiveRecord::Base
  belongs_to :thinker
  has_many :thumbs
  validates :thought, length: {minimum: 5, maximum: 154}, allow_blank: false #defines min/max length
  validates :thought, :uniqueness => true #every different thought has a unique thinker(author)
end
