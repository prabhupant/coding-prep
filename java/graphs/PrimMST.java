import java.util.*;

public class PrimMST{

    public List<Edge<Integer>> primMST(Graph<Integer> graph){
        //binary heap + map data structure
        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
        
        //map of vertex to edge which gave minimum weight to this vertex
        Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();

        //stores the final result
        List<Edge<Integer>> result = new ArrayList<>();

        //insert all vertices with infinite value initially
        for(Vertex<Integer> v : graph.getAllVertex()){
            minHeap.add(Integer.MAX_VALUE, v);
        }

        //take any random vertex to start from
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();

        minHeap.decrease(startVertex, 0);

        //iterate till heap+map has elements in it
        while(!minHeap.empty()){
            //extract min value vertex from heap + map
            Vertex<Integer> current = minHeap.extractMin();

            //get the corresponding edge for this vertex if present and add it to the final result
            //this edge won't be present for the first vertex
            Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
            if(spanningTreeEdge != null){
                result.add(spanningTreeEdge);
            }

            //iterate through all the adjacent vertices
            for(Edge<Integer> edge : current.getEdge()){
                Vertex<Integer> adjacent = getVertexForEdge(current, edge);
                //check if adjacent vertex exist in heap + map and weight attached with this vertex is greater than this edge weight
                if(minHeap.containsData(adjacent) && minHeap.getWeight(adjacent) > edge.getWeight()){
                    //decrease the value of adjacent vertex to this edge wight
                    minHeap.decrease(adjacent, edge.getWeight());
                    //add vertex->edge mapping in the graph
                    vertexToEdge.put(adjacent, edge);
                }
            }
        }
        return result;
    }
    
    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(1,2,3);
        graph.addEdge(2,3,1);
        graph.addEdge(3,1,1);
        graph.addEdge(1,4,1);
        graph.addEdge(2,4,3);
        graph.addEdge(4,5,6);
        graph.addEdge(5,6,2);
        graph.addEdge(3,5,5);
        graph.addEdge(3,6,4);

        PrimMST prims = new PrimMST();
        Collections<Edge<Integer>> edges = prims.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
    }
}

