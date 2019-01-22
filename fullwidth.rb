#!/usr/bin/env ruby

require 'clipboard'

exit if ARGV.empty?

COPY = ARGV[0] == '-c'
ARGV.shift if COPY
OUT = COPY ? Clipboard.method(:copy) : Kernel.method(:puts)

# Returns the fullwidth version of a character.
# If no fullwidth version exists, returns the character.
def widen_char(c)
  c += 65248 if c.between? 33, 126 # character w/ fullwidth equivalent
  c.chr Encoding::UTF_8
end

OUT.call ARGV.join(' ').codepoints.map { |c| widen_char c }.join
