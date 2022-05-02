# Day 10:
# Question:
# Implement a job scheduler which takes a function f and an integer n, and calls f
# after n milliseconds

# Answer:
# Direct implementation, we use time.sleep(x) which will delay the program by x seconds,
# we delay the program by n/1000 seconds then run the function f

import time

def printer():
    print("Cool!")

def adder():
    a = 12
    b = 13
    print(a+b)

def jobScheduler(f,n):
    timeInSeconds = n/1000
    time.sleep(timeInSeconds)
    f()

jobScheduler(adder,2000)