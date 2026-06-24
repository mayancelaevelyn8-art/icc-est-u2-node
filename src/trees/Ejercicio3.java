package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import node.Node;

public class Ejercicio3 {

    public List<List<Node<Integer>>> listLevels(Node<Integer> root) {
        List<List<Node<Integer>>> resultado = new ArrayList<>();
        if (root == null) return resultado;

        Queue<Node<Integer>> cola = new LinkedList<>();
        cola.add(root);

        while (!cola.isEmpty()) {
            int size = cola.size();
            List<Node<Integer>> nivel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node<Integer> actual = cola.poll();
                nivel.add(actual);
                if (actual.getLeft() != null) cola.add(actual.getLeft());
                if (actual.getRight() != null) cola.add(actual.getRight());
            }
            resultado.add(nivel);
        }
        return resultado;
    }

    public void printLevels(Node<Integer> root) {
        List<List<Node<Integer>>> niveles = listLevels(root);
        for (List<Node<Integer>> nivel : niveles) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nivel.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(nivel.get(i).getValue());
            }
            System.out.println(sb.toString());
        }
    }
}