
## Input

First line contains number of vertex and edges and the following lines contain u, v, Is a Directed Graph?

4 6 true  
1 0 2  
0 1 3  
0 3 5  
1 3 8  
2 1 1  
3 2 2  
![input](https://github.com/nagulan23/Algorithms/blob/main/Graphs/Cache%20for%20images/Screenshot%202020-12-30%20200554.png)
## Output

Given graph:  
0	3	∞	5   
2	0	∞	8   
∞	1	0	∞  
∞	∞	2	0  
  
Shortest path between any two vertices:   
0	3	7	5  
2	0	9	7  
3	1	0	8  
5	3	2	0  
