#!/usr/bin/env ruby

exit if ARGV.empty?

# Returns the fullwidth version of a character.
# If no fullwidth version exists, returns the character.
def widen(c)
  c += 65248 if c.between? 33, 126 # character w/ fullwidth equivalent
  c.chr Encoding::UTF_8
end

puts ARGV.join(' ').codepoints.map { |c| widen c }.join
