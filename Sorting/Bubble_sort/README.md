# Bubble sort

Bubble sort consists of n rounds. On each round, the algorithm iterates
through the elements of the array. Whenever two consecutive elements are found
that are not in correct order, the algorithm swaps them.

## Analysis
### Time complexity 
Best case: `O(n)`
- When the list is already sorted

Worst case: `O(n^2)`
- When the list is in reverse order

### Space complexity
: `O(1)`
- Only one single additional memory space is required, e.g a temp variable