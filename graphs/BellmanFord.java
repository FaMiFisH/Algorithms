package graphs;

/**
 * Problem:     Find shortest paths from the starting node to all other nodes.
 * Algorithm:   Each node in the graph is assigned a distance. The starting node is assigned 0 and all other nodes are assigned infinity.
 *              The algorithm searches for edges that reduce the distances starting from the starting node. 
 * Assumptions: The implemented algorithm assumes that the graph is stored as an edge list where eadges are stored as tuples of form (a,b,w), 
 *              meaning there is an edge from nodes a and b with weight w.
 * Evaluation:  
 */

public class BellmanFord{

    private final static int inf = 999999999;

    private static void algorithm(int startVertex, int[] vertices, Edge[] edges){
        for(Edge e : edges){
            int a = e.getStart();
            int b = e.getEnd();
            int w = e.getWeight();
            vertices[b-1] = min((vertices[a-1]+w), vertices[b-1]);
        }
    }

    private static int min(int a, int b){
        return (a < b ? a : b);
    }

    public static void main(String[] args) {
        // intialise the vertices
        int[] vertices = new int[5];
        for(int i = 0; i < vertices.length; i++) vertices[i] = inf;

        // intialise the edges
        Edge[] edges = new Edge[7];
        edges[0] = new Edge(1,2,5);
        edges[1] = new Edge(1,3,3);
        edges[2] = new Edge(1,4,7);
        edges[3] = new Edge(3,4,1);
        edges[4] = new Edge(2,4,3);
        edges[5] = new Edge(2,5,2);
        edges[6] = new Edge(4,5,2);

        // execute algorithm
        int startVertex = 1;
        vertices[startVertex-1] = 0;
        algorithm(startVertex, vertices, edges);

        // output 
        System.out.println("Starting vertix: " + startVertex);
        for(int i = 0; i < vertices.length; i++){
            System.out.println("Distance to vertex " + (i+1) + ": " + vertices[i]);
        }

        // negative cycle
        System.out.println("\nTesting for a negative cycle...");
        // intialise the vertices
        vertices = new int[4];
        for(int i = 0; i < vertices.length; i++) vertices[i] = inf;
        // initialise the edges
        edges = new Edge[6];
        edges[0] = new Edge(2,4,1);
        edges[1] = new Edge(2,3,2);
        edges[2] = new Edge(2,1,3);
        edges[3] = new Edge(1,3,5);
        edges[4] = new Edge(3,4,-7);
        edges[5] = new Edge(4,2,1);

        startVertex = 2;
        vertices[startVertex-1] = 0;
        int n = 5;
        int[] temp = new int[vertices.length];
        for(int i = 0; i <= n; i++){
            algorithm(startVertex, vertices, edges);
            if(i == n){
                for(int j = 0; j < vertices.length; j++){
                    if(vertices[j] < temp[j]){
                        System.out.println("The graph contains a negative cycle!");
                        return;
                    }
                }
            }
            for(int k = 0; k < vertices.length; k++) temp[k] = vertices[k];
        }
        

    }

}

class Edge{
    private int startNode;
    private int endNode;
    private int weight;

    public Edge(int a, int b, int w){
        this.startNode = a;
        this.endNode = b;
        this.weight = w;

    }

    public int getStart(){return startNode;}
    public int getEnd(){return endNode;}
    public int getWeight(){return weight;}
}
