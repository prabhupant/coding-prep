import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

public class TopologicalSort<T>{

    public Deque<Vertex<T>> topSort(Graph<T> graph){
        //we use deque as a stack because Stack class in java is a subclass of vector, so it exposes it elements by providing us index access functionalities. And also, it doesn't have an interface, so we are stuck at one concrete class
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for(Vertex<T> vertex : graph.getAllVertex()){
            if(visited.contains(vertex)){
                continue;
            }
            topSortUtil(vertex, stack, visited);
        }
        return stack;
    }

    private void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited){
        visited.add(vertex);
        for(Vertex<T> childVertex : vertex.getAdjacentVertexes()){
            if(visited.contains(childVertex)){
                continue;
            }
            topSortUtil(childVertex, stack, visited);
        }
        stack.offerFirst(vertex);
        //we have used stack.offerFirst() in place of stack.addFirst() because when an addition fails, .addFirst() throws an exception while .offerFirst() return false
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        TopologicalSort<Integer> sort = new TopologicalSort<Integer>();
        Deque<Vertex<Integer>> result = sort.topSort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}
