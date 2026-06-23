package trees;

import node.Node;

public class Ejercicio2 {
    public Node<Integer> invert(Node<Integer> root){
        System.out.println("Arbol original:");
        printTree(root);
        invertRecursively(root);
        System.out.println("Arbol invertido:");
        printTree(root);
        return root;
    }

    private void invertRecursively(Node<Integer> actual){
        if (actual == null) return;
        Node<Integer> temp = actual.getLeft();
        actual.setLeft(actual.getRight());
        actual.setRight(temp);
        invertRecursively(actual.getLeft());
        invertRecursively(actual.getRight());
    }

    public void printTree(Node<Integer> root){
        System.out.println("Imprimiendo el arbol:");
        printTreeRecursivo(root, 0);
    }

    private void printTreeRecursivo(Node<Integer> actual, int nivel){
        if (actual == null) return;
        printTreeRecursivo(actual.getRight(), nivel + 1);
        System.out.println("  ".repeat(nivel) + actual.getValue());
        printTreeRecursivo(actual.getLeft(), nivel + 1);
    }
}