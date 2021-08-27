package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * This is an adjacency list implementation of a graph. Instead of storing the vertices in an ArrayList, I have stored int vertices and edges 
 * HashMap allowing for a generic implementation of a graph. Both DFS and BFS algorithms are tested here.
 */
@SuppressWarnings("unchecked")
public class Graph<T>{
    private HashMap<T, ArrayList<T>> graph;

    public Graph(){
        this.graph = new HashMap<T, ArrayList<T>>();
    }

    // adds a new node to the hashmap
    public void addVertex(T vertex){
        graph.put(vertex, new ArrayList<T>());
    }

    // checks whether the node exists in the hashmap or not
    public boolean search(T vertex){
        return graph.containsKey(vertex);
    }

    // removes a node from the graph
    public ArrayList<T> removeNode(T vertex){
        return graph.remove(vertex);
    }

    // returns the list of edges of the given vertex
    public ArrayList<T> getEdges(T vertex){
        return graph.get(vertex);
    }

    // adds an edge in the graph
    public void addEdge(T startVertex, T endVertex){
        if(!graph.containsKey(startVertex)){addVertex(startVertex);}
        if(!graph.containsKey(endVertex)){addVertex(endVertex);}
        graph.get(startVertex).add(endVertex);
    }

    // counts the number of edges in the graph
    public int countEdges(){
        int count = 0;
        for(T v : graph.keySet()) count += graph.get(v).size();
        return count;
    }

    // counts the number of vertices in the graph
    public int countVertices(){
        return graph.size();
    }

    // DFS
    public static void dfs(int v, int[] visited, Graph graph){
        if(visited[v-1] == 1){
            return;
        }
        System.out.print(v + " -> ");
        visited[v-1] = 1;
        ArrayList<Integer> list = graph.getEdges(Integer.valueOf(v));
        for(Integer vertex : list){
            dfs(vertex.intValue(), visited, graph);
        }
    }

    public static void main(String[] args){
        // intialise a graph
        Graph<Integer> graph = new Graph();
        int n = 6;
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 1);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);

        System.out.println("Adjaceny list representation");
        for(int i = 1; i <= n; i++){
            ArrayList<Integer> list = graph.getEdges(Integer.valueOf(i));
            System.out.println(i + ": " + list.toString());
        }
        System.out.println("Vertices: " + graph.countVertices() + "\nEdges: " + graph.countEdges());
        
        // DFS
        System.out.print("DFS Path: ");
        int[] visited = new int[n];
        int startVertex = 1;
        dfs(startVertex, visited, graph);
        System.out.println("");

        // BFS
        System.out.print("BFS path: ");
        visited = new int[n];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] distance = new int[n];
        visited[startVertex-1] = 1;
        distance[startVertex-1] = 0;
        queue.addLast(startVertex);
        while(!queue.isEmpty()) {
            Integer v = queue.removeFirst();
            System.out.print(v.intValue() + " -> ");
            for(Integer vertices : graph.getEdges(v)){
                if(visited[vertices.intValue()-1] == 1) continue;
                visited[vertices.intValue()-1] = 1;
                distance[vertices.intValue()-1] = distance[v.intValue()-1]+1;
                queue.addLast(vertices);
            }
        }
        System.out.println("");
    }
    
}