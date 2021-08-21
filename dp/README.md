# Dynamic programming
Technique that combines the correctness of the complete search and the efficiency of greedy algorithms. It can be applied when the problem can be divided into overlapping sub-problems that can be solved independantly. Dynamic programming can be used:
- finding an optimal solution, aolution that is as large as possible or as small as possible
- counting the (total) number of solutions

The following are different ways to implement a solution using dynamic programming.
#### Recursive formulation
Formulate the problem recursively so that the solution to the problem can be calculated from solutions to smaller problems.

#### Using memoization
Effectively calculate values to the recursive calls using a loop instead. This is done through storing the values in an array for future use. 