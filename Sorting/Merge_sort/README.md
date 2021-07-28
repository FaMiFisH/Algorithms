# Merge Sort  

Based on recursion. Merge sort sorts a subarray array[a...b] as follows:
1. If a = b, do not do anything, because the subarray is already sorted.
2. Calculate the position of the middle element: k = floorFunction((a+b)/2).
3. Recursively sort the subarray array[a...k].
4. Recursively sort the subarray array[k+1...b].
5. Merge the sorted subarrays array[a...k] and array[k +1...b] into a sorted subarray array[a...b] 

The recursion consists of `O(log n)` levels, and processing each level takes `O(n)` time. Merging the subarrays array[a...k] and array[k+1...b] is possible in linear time, because they are already sorted.

## Analysis
#### Time complexity 
- `O(n*log n)` in all 3 cases (worst, average and best), the algorithm always divides the array in 2 halves and takes linear time to merge the 2 halves

#### Space complexity
- `O(n)`, requires additional amount of additional as the unsorted array 