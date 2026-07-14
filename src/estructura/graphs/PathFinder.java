package estructura.graphs;


//Interface =>
// no contine logic
// define me

public interface PathFinder<T> {
    PathResult<T> find(Graph<T> graph, T start, T end);
}
