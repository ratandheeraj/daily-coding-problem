# Question:
# You run an e-commerce website and want to record the last N order ids in a log. 
# Implement a data structure to accomplish this, with the following API:

# record(order_id): adds the order_id to the log
# get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N. 

# You should be as efficient with time and space as possible.

# Answer:
# The perfect data structure to implement this is "circular buffer"
# We will use a "circular buffer" to store the values and index to hold the last location of buffer.

# For record(orderId) API:
# for suppose if n = 5, and 1,2,3,4,5 are added into the buffer
# buffer is now full  -> [1,2,3,4,5]
# If we wish to add 6, instead of deleting 1 and shifting the elements, we can change the index to 0
# and insert (rewrite) 6 there
# buffer becomes -> [6,2,3,4,5] . We did not waste time shifting elements which take O(n) time. 

# For get_last(i) API:
# we will return index - i, if i <= index value in log
# otherwise we will return, (index - i + n) % n value in log 

class Log:
    def __init__(self,n):
        self.recordLog = [0] * n
        self.n = n
        self.index = 0
    
    def record(self,orderId):
        self.recordLog[self.index] = orderId
        self.index = (self.index+1) % self.n
    
    def get_last(self,i):
        if i <= self.index:
            return self.recordLog[self.index - i]

        return self.recordLog[(self.index - i + self.n) % self.n]

log = Log(5)
log.record(14)
log.record(1)
log.record(12)
log.record(11)
log.record(15)
log.record(16)
log.record(6)
log.record(9)

print(log.get_last(3))

# Time Complexity: O(1)
# Space Complexity: O(n)