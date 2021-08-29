# Graphs

## Terminology
A `path` leads from node a to node b through edges of the graph.  
The `lenght` of a path is the number of edges in it.  
A path is a `cycle` if the first and last node are the same.  
A path is `simple` is each node appears at most once.  
A graph is `connected` is there is a path between any 2 nodes.  
The connected parts of the graph are called `compnents`.  
A `tree` is a connected graph with n nodes and n-1 edges.  
A `graph` is connected is the edges can only be traversed in one direction.  
`Weight` of an edge is its length.  
In a `weighted` graph, each eadge is assigned a weight.  
Two nodes are `adjacent` if there is an edge between them.  
The `degree` of a node is the number of adjacent nodes.  
A graph is `regular` if the degree if every node is a constant d.  
A graph is `complete` is each node has degree n-1 where n is the total number of nodes.  
In a directed graph, the `indegree` of a node is the number of edges that end at the node and `outdegree` is the number of edges that start at the node.  
A graph is `simple` if no edges start and end on the same node and there are no multiple edges between 2 nodes.  
In a `coloring` of a graph, each node is assigned a color such that no adjacent nodes have the same color.  
`Vertex coloring`, given m colors find a way to color the vertices of a graph such that no 2 adjacent vertices are colored the same.  
`Edge coloring`, no vertex is adjacent to 2 edges of same color.  
`Chromatic number`, smallest number of colors needed to color a graph G.  
A graph is `bipartite` if it is possible to color it using only 2 colors.  

## Graph representation
There are several ways to represent graphs in algorithms. The choice of a data
structure depends on the size of the graph and the way the algorithm processes
it. 
### Adjacency list representation
Each node x in the graph is assigned an adjacency list that contains nodes which there is an edge from x. For weighted graphs, for each node a, the adjacency list will store the pair (b,w) where b is the node which there is an edge to and w is the weight of the edge.

`Pros`:
- Efficient to find nodes to move to from a given node.
- Saves space O(|V|+|E|), in worst case its O(n^2)
- Adding a vertex is easy.  

`Cons`:
- It is inefficient to search for edges

### Adjacency matrix representation
The matrix is represented through a 2-dimensional array where each value adj[a][b] indicated whether ther is an edge between the nodes a and b. For a weighted graph, the implementation can be extended so the value stores the weight of the edge if it exists.

`Pros`: 
- Representation is easier to follow and implement. 
- Search of an edge can be done in O(1) time
- Removing an edge takes O(1) time.  

`Cons`:
- Uses more space O(n^2). This is regardless of how many edges the graph has.
- Adding a vertex takes O(n^2) time

### Edge list representation
The edge list representation stores all edges of the graph is some order. The implementation stores pairs (a,b) where a and b are adjacent nodes in a list. If the graph is weighted, the implementation can be extended to also store tuples (a,b,w) where w is the weight of the edge.

This is a convenient way to represent a graph if the algorithm processes all edges of the graph and it is not needed to find edges that start at a given node.

## Graph Traversal
Graph traversal algorithms can be used to check many properties of a graph. The properties inlude:
- `Connectivity`, a graph is connected if there is a path between any 2 nodes of a graph.
- `Cycles`, a graph contains a cycle if the algorithm comes across a visited node (excluding the previous node in the path).
- `Bipartiteness`, color the starting node blue and its neighbours red and its neighbours blue and so on. If 2 adjacent nodes have the same color, the graph is not bipartite

. We can also check if a graph contains a cycle by looking out for visited nodes (excluding the previous node in the path).
### Depth-first search (DFS)
DFS follows a single path as long as it finds new nodes. After this, it returns to the previous nodes to further traverse through unvisited nodes. The algorithm keeps track of the visited nodes so that it only processes each node once.  
`Time complexity`: O(|V|+|E|)  
`Space complexity`: O(|V|)   

### Breadth-first search (BFS)
BFS visits nodes in increasing order of their distance to the starting node. This allows us calculate the distance of all nodes from the starting node. The algorithm goes through nodes one level another. The first search explores nodes whose distance from the stating node is 1, then 2 and so on. The process continues until all nodes have been visited.  
`Time complexity`: O(|V|+|E|)  
`Space complexity`: O(|V|)  

## Shortest path 
For an unweighted graph, the weight of each edge is 1 and we can use the breadth-first search algorithm to find a shortest path. For weighted graphs, we can use the following algorithms. 
### Bellman-Ford algorithm
Finds shortest paths from the starting node to all other nodes. The algorithm can process all kinds of graphs, provided that the graph does not contain a cycle with negative length. If the graph contains a negative cycle, the algorithm can detect this.  

The algorithm keeps track of distances from the starting node to all nodes of the graph. Initially, the distance to the starting node is 0 and the distance to all other nodes in infinite. The algorithm reduces the distances by finding edges that shorten the paths until it is not possible to reduce any distance.

The algorithm can also be used to check if the graph contains a negative cycle. To do so, run the algorithm n times and if any values decrease on the last round, the graph contains a negative cycle. This test will suffice for any starting node in the whole graph.