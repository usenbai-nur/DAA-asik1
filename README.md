Assignment 1

This repository contains the implementation and analysis of several "divide-and-conquer algorithms", created as part of the "Design and Analysis of Algorithms" course.  

The project focuses on:
- Writing safe recursive implementations.  
- Controlling recursion depth and memory allocations.  
- Collecting performance metrics (runtime, recursion depth, allocations, comparisons).  
- Comparing theoretical complexity analysis with empirical measurements.  
- Maintaining a clean Git history to track the development process.  

---

Implemented Algorithms

1. **MergeSort**  
   - Uses linear merging with a reusable buffer.  
   - Includes a cutoff to switch to insertion sort for small arrays.  
   - Theoretical complexity: Θ(n log n) (Master Theorem, Case 2).  

2. **QuickSort**  
   - Implements a randomized pivot.  
   - Always recurses into the smaller partition first to keep the stack bounded.  
   - Expected complexity: Θ(n log n).  

3. **Deterministic Select (Median of Medians)**  
   - Groups by 5 elements and recursively finds a pivot.  
   - Guarantees O(n) worst-case runtime.  
   - Only recurses into the partition containing the k-th element.  

4. **Closest Pair of Points (2D)**  
   - Uses divide-and-conquer: split by x-coordinate, check the “strip” by y-order.  
   - Runs in O(n log n).  
   - Compared against a naive O(n²) solution for small n.  

---

 Project Structure
src/
algorithms/
ClosestPair.java
DeterministicSelect.java
Main.java
MergeSort.java
Metrics.java
QuickSort.java

---

## Commit Storyline
The repository follows a clear commit workflow:  

- **Initial setup**: created base project structure and algorithm classes.  
- **Implementation phase**: added MergeSort, QuickSort, DeterministicSelect, and ClosestPair.  
- **Metrics system**: introduced runtime/depth counters and CSV output.  
- **Debugging and optimization**: improved implementations and fixed edge cases.  
- **Final stage**: benchmark results exported to `results.csv`.  

This workflow reflects an incremental approach to development, following assignment requirements.  

---

## Example Results
algorithmName;runTime;counter;depth;allocation
MergeSort;56800;24;3;5
QuickSort;18300;7;3;5
DeterministicSelect;3189900;5;0;5
ClosestPair;1140000;1;0;3

