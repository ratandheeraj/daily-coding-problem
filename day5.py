# Day5
# Question:
# cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element 
# of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
# Given this implementation of cons:
# def cons(a, b):
#     def pair(f):
#         return f(a, b)
#     return pair
# Implement car and cdr.

# Answer:
# Answer is straight forward, get the function as argument, 
# and then perform the lambda function to get the answer

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
def car(pair):
    return pair(lambda a, b: a)

def cdr(pair):
    return pair(lambda a, b: b)

print(cdr(cons(3,4)))

# Time complexity = O(1)
# Space complexity = O(1)