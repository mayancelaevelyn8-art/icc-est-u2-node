package estructura.graphs;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import node.Node;

public class Graph<T> {
    private Map<Node<T>, Set<Node<T>>> graph;

    public Graph() {
        this.graph = new LinkedHashMap<Node<T>, Set<Node<T>>>();
    }

    public void add(T data) {
        Node<T> node = new Node<T>(data);
        graph.putIfAbsent(node, new LinkedHashSet<Node<T>>());
    }

    private Node<T> findNode(T data) {
        for (Node<T> node : graph.keySet()) {
            if (node.getValue().equals(data)) {
                return node;
            }
        }
        return null;
    }

    public void addEdge(T v1, T v2) {
        add(v1);
        add(v2);
        Node<T> nv1 = findNode(v1);
        Node<T> nv2 = findNode(v2);
        graph.get(nv1).add(nv2);
        graph.get(nv2).add(nv1);
    }

    public void addEdgeUni(T v1, T v2) {
        add(v1);
        add(v2);
        Node<T> nv1 = findNode(v1);
        Node<T> nv2 = findNode(v2);
        graph.get(nv1).add(nv2);
    }

    public void printGraph() {
        for (Map.Entry<Node<T>, Set<Node<T>>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Node<T> conecciones : entry.getValue()) {
                System.out.print(conecciones + "");
            }
            System.out.println();
        }
    }
}