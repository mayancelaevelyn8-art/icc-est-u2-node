

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import estructura.graphs.Graph;
import estructura.graphs.PathFinder;
import estructura.graphs.PathResult;
import node.Node;

public class BFSPathFinder<T> implements PathFinder<T> {
    
    @Override
    public PathResult<T> find(Graph<T> graph, T start, T end) {
        Queue<T> queue = new LinkedList<>();
        Set<T> visitados = new LinkedHashSet<>();
        Map<T, T> parent = new HashMap<>();
        List<Node<T>> visited = new ArrayList<>();

        queue.add(start);
        visitados.add(start);
        parent.put(start, null);
        
        while (!queue.isEmpty()){
            T current = queue.poll();
            visited.add(new Node<>(current));
            
            if(current.equals(end)){
                return new PathResult<>(visited, buildPath(parent, end));
            }
            
            for(Node<T> vecino: graph.getVecinos(current)){
                if(!visitados.contains(vecino.getValue())){
                    visitados.add(vecino.getValue());
                    parent.put(vecino.getValue(), current);
                    queue.add(vecino.getValue());
                }
            }
        }
        
        return new PathResult<>(visited, new ArrayList<>());
    }

    private List<Node<T>> buildPath(Map<T, T> parent, T end) {
        List<Node<T>> path = new ArrayList<>();
        T current = end;
        
        while(current != null){
            path.add(0, new Node<>(current));
            current = parent.get(current);
        }
        
        return path;
    }
}