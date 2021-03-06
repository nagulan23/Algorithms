## Complexity

Time Complexity = O( E log E + E log V ) --> Sort edges + Disjoint set operation

## Input

First line contains number of vertex and edges and the following lines contain u, v, w

9 14  
0 1 4  
0 7 8  
1 7 11  
1 2 8  
2 8 2  
7 8 7  
7 6 1  
8 6 6  
6 5 2  
2 5 4  
2 3 7  
3 5 14  
3 4 9  
5 4 10  
![input](https://github.com/nagulan23/Algorithms/blob/main/Graphs/Cache%20for%20images/Screenshot%202020-12-28%20192224.png)

## Output

-------- Sorted Edges  
[6, 7, 1]  
[5, 6, 2]  
[2, 8, 2]  
[2, 5, 4]  
[0, 1, 4]  
[6, 8, 6]  
[2, 3, 7]  
[7, 8, 7]  
[1, 2, 8]  
[0, 7, 8]  
[3, 4, 9]  
[4, 5, 10]  
[1, 7, 11]  
[3, 5, 14]  
-------- Selected Edges  
[6, 7, 1]  
[5, 6, 2]  
[2, 8, 2]  
[2, 5, 4]  
[0, 1, 4]  
[2, 3, 7]  
[1, 2, 8]   
[3, 4, 9]  
Weight of MST = 37  
![output](https://github.com/nagulan23/Algorithms/blob/main/Graphs/Cache%20for%20images/Screenshot%202020-12-28%20192253.png)
