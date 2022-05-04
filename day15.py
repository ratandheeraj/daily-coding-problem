# Question:
# Given a stream of elements too large to store in memory, 
# pick a random element from the stream with uniform probability.


# Answer:
# We will try to put some part of the huge stream in the memory, and randomly take one value and put in 
# arrayOfValues, then we will randomly select one value out of the arrayOfValues

import random

# Mimic the huge stream, returns a chunk of numbers
def createExampleInputStream():
    buffer = list()
    for i in range(100):
        randomValue = random.randint(0,10000)
        buffer.append(randomValue)
    return buffer

def pickRandomElement():
    arrayOfValues = list()
    for i in range(10000):
        buffer = createExampleInputStream()
        arrayOfValues.append(buffer[random.randint(0,99)])

    return arrayOfValues[random.randint(0,9999)]

print(pickRandomElement())

# Time Complexity: O(1)
# Space Complexity: O(1)