# Counting sort
The algorithm creates a bookkeeping array, whose indices are elements of the
original array. The algorithm iterates through the original array and calculates
how many times each element appears in the array.

## Analysis
#### Time complexity
- `O(n)` in all 3 cases (worst, average and best). Construction of the bookkeeping array takes O(n) time. After this, the sorted
array can be created in O(n) time because the number of occurrences of each
element can be retrieved from the bookkeeping array.

#### Space complexity 
- `O(n)` as all elements need to be stored in a map

#### Advantages
- It is a fast and stable algorithm 

_Note: A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted._

#### Disadvantages 
- It is not suitable for sorting large data sets
