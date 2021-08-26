# Graphs

#### Terminology
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
In a `coloring` of a graph, each node is assigned a color such that no adjacent nodes have the same color.  
A graph is `bipartite` if it is possible to color it using only 2 colors.  
A graph is `simple` if no edges start and end on the same node and there are no multiple edges between 2 nodes.  

### Graph representation
There are several ways to represent graphs in algorithms. The choice of a data
structure depends on the size of the graph and the way the algorithm processes
it. 
#### Adjacency list representation
Each node x in the graph is assigned an adjacency list that contains nodes which there is an edge from x. For weighted graphs, for each node a, the adjacency list will store the pair (b,w) where b is the node which there is an edge to and w is the weight of the edge.

The advantage of the adjacency list is that it is efficient to find nodes which we can move to. This can be easily achieved through a loop that goes through all nodes in the adjacency list of any paticular node.

#### Adjacency matrix representation
The matrix is represented through a 2-dimensional array where each value adj[a][b] indicated whether ther is an edge between the nodes a and b. For a weighted graph, the implementation can be extended so the value stores the weight of the edge if it exists.

The limitation of the adjacency matrix is that the matrix contains n sqaured elements where (usually) most values will be 0. Thus, it is not efficient for large graphs.

#### Edge list representation
The edge list representation stores all edges of the graph is some order. The implementation stores pairs (a,b) where a and b are adjacent nodes in a list. If the graph is weighted, the implementation can be extended to also store triplets (a,b,w) where w is the weight of the edge.

This is a convenient way to represent a graph if the algorithm processes all edges of the graph and it is not needed to find edges that start at a given node.
