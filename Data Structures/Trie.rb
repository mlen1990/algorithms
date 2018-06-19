require 'json'

class Trie

	def initialize
		@root = Hash["count" => 0, "children" => Hash.new]
	end

	def insert(word)
		node = @root
		word.split("").each do |char|
			if not node["children"].key?(char)
				node["children"][char] = Hash["count" => 0, "children" => Hash.new]
			end
			node["count"] += 1
			node = node["children"][char]
		end
		node["count"] += 1
	end

	def match_prefix(prefix)
		node = @root
		prefix.split("").each do |char|
			if not node["children"].key?(char)
				return 0
			end
			node = node["children"][char]
		end
		return node["count"]
	end

	def print_root
		puts JSON.pretty_generate(@root)
	end
end

trie = Trie.new
trie.insert("word")
trie.insert("word")
trie.insert("wordd")
trie.insert("about")
trie.insert("able")

puts trie.match_prefix("wordd")

# trie.print_root