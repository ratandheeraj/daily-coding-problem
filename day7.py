# Day7:
# Question:
# Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it 
# can be decoded.
# For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
# You can assume that the messages are decodable. For example, '001' is not allowed.

# Answer:
# We will first check the length of s, if it's length is or less than one, 
# one letter can be possible, so return 1

# We will check if the first 2 characters are less than value 26, if yes, a character can be created, so we 
# will use recursion to count further values. 

# Same like before, but we will check first the first character, then recursion


def countEncodings(s):
    if len(s) <= 1:
        return 1 

    total = 0
    if int(s[:2]) <= 26:
        total += countEncodings(s[2:])

    total += countEncodings(s[1:])
    return total

# Time Complexity: O(2^n)
# Space Complexity: O(mn)