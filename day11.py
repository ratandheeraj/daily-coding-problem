# Question:
# Implement an autocomplete system. That is, given a query string s and a set of all possible query 
# strings, return all strings in the set that have s as a prefix.
# For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
# Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

# Class to create trie nodes
# Every node in a trie contains two variables, one to hold all children another to indicate whether its 
# the end of word or not



# Answer:
# We can use a "Trie" data structure to efficiently store and query the data

# A trie is a special type of tree, where every node is a character, the children will also be characters
# When we iterate from root to leaf nodes we will get a word.
#                 b
#               / | \
#             a   u   e 
#           /     |    \
#         t       t     l
#                         \
#                           l
# This is a example trie, we can see bat, but, bell words stored efficiently


# This class is used to create TrieNode, every node contains
# 1) children to contain the children nodes
# 2) end to represent whether the character is the end of the word
class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False

class Trie:
    # This will create the root of the trie
    def __init__(self):
        self.root = TrieNode()

    # Inserts the word in trie
    # Starts at root to check if the characters are present, if present it will go to that no, otherwise 
    # it will create a new childnode 
    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.end = True

    # It will search through all the nodes and return the possible words
    def walktrie(self,node,prefix,suggestions):
        if node.children:
            for char in node.children:
                suggestion_word = prefix + char
                if node.children[char].end:
                    suggestions.append(suggestion_word)
                self.walktrie(node.children[char],suggestion_word,suggestions)
        
    # It will check if the prefix exists in the words in the trie, if not returns empty list
    # If prefix exists, it will send the node to "walktrie" function to check for available words.
    def autocomplete(self, prefix):
        node = self.root
        suggestions = list()
        for char in prefix:
            if char in node.children:
                node = node.children[char]
            else:
                return suggestions
        #if prefix form a word of its own, it will also be a sugggestion
        if node.end:
            suggestions.append(prefix)
        self.walktrie(node, prefix, suggestions)
        return suggestions
            
trie = Trie()
words = ["dog","deal","deer","deaf","dig","cool","con","continue"]
for word in words:
    trie.insert(word)
x = trie.autocomplete("con")
print(x)


### Time Complexity for creating trie: O(W*L)
# where W -> no. of words
# L -> average length of word

### Time Complexity for autocomplete function: O(N)

### Space Complexity: O(N)
# where N -> no. of nodes