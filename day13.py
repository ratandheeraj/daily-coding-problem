# Question:
# Given an integer k and a string s, find the length of the longest substring that contains at most k 
# distinct characters.

# For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

# Answer:
# Bruteforce approah
# We will try to generate all possible substrings and see which has more length and return it

def longestSubstring(s, k):
    answer = 0
    n = len(s)
    # generating all possible substrings
    for i in range(n):
        for j in range(i + 1, n + 1):
            substring = s[i:j]
            # checking if possible substring is the answer
            if len(set(substring)) <= k and len(substring) > answer:
                answer = len(substring)
    return answer

print(longestSubstring("abcba",2))

# Time Complexity: O(n^2)
# Space Complexity: O(n^2)