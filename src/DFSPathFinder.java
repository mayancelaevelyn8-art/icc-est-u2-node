

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import estructura.graphs.Graph;
import estructura.graphs.PathFinder;
import estructura.graphs.PathResult;
import node.Node;

public class DFSPathFinder<T> implements PathFinder<T> {
    
    @Override
    public PathResult<T> find(Graph<T> graph, T start, T end) {
        List<Node<T>> visited = new ArrayList<>();
        List<Node<T>> path = new ArrayList<>();
        Set<T> visitedValues = new HashSet<>();

        boolean encontrado = dfs(graph, start, end, visited, path, visitedValues);
        if (!encontrado) {
            path.clear();
        }
        return new PathResult<>(new ArrayList<>(visited), path);
    }

    private boolean dfs(Graph<T> graph, T start, T end, 
        List<Node<T>> visited,
        List<Node<T>> path,
        Set<T> visitedValues) {
        
        if (visitedValues.contains(start)) {
            return false;
        }
        
        visitedValues.add(start);
        Node<T> nStart = new Node<>(start);
        visited.add(nStart);
        path.add(nStart);
        
        if(start.equals(end)){
            return true;
        }

        for(Node<T> vecino: graph.getVecinos(start)){
            if(!visitedValues.contains(vecino.getValue())){
                boolean encon = dfs(graph, vecino.getValue(), end, visited, path, visitedValues);
                if(encon){
                    return true;
                }
            }
        }
        
        path.remove(path.size() - 1);
        return false;
    }
}