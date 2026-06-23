package trees;
import java.util.LinkedList;
import java.util.Queue;
import node.Node;

// Clase que representa un árbol binario de enteros
public class IntTree {

    private Node<Integer> root;
    private int peso;

    /// Constructor SIEMPRE inicializa LAS VARIABLES (ROOT)
    public IntTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> node) {
        root = node;
    }

    public void setRoot(Integer value) {
        Node<Integer> node = new Node<Integer>(value);
        root = node;
    }

    public void insert(Integer value) { // 10
        Node<Integer> node = new Node<Integer>(value);
        root = insertRecursivo(root, node);
    }
    public int getPeso() {
        return peso;
    }

    public void insert(Node<Integer> value) { // 10
        root = insertRecursivo(root, value);
    }

    // recursivo para insertar valores ARBOL BINARIO
    private Node<Integer> insertRecursivo(Node<Integer> actual, Node<Integer> nodeInsertar) {
        if (actual == null) {
            return nodeInsertar;
        }

        // validar si es mayoy o nenor y decidir si lo ingerso a la der o izq
        if (actual.getValue() > nodeInsertar.getValue()) {
            actual.setLeft(insertRecursivo(actual.getLeft(), nodeInsertar));
        } else {
            actual.setRight(insertRecursivo(actual.getRight(), nodeInsertar));
        }

        return actual;
    }

    public void preOrder() {
        preOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        System.out.print(actual + " ");
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    public void posOrder() {
        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());
        System.out.print(actual + " ");

    }

    public void porNiveles() {
        porNiveles1();
    }
  // inorder
    public void inOrder() {
        inOrderRecursivo(root);
    }
    private void inOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        inOrderRecursivo(actual.getLeft());
        System.out.print(actual + " ");
        inOrderRecursivo(actual.getRight());
    }
    // niveles
    public void porNiveles1() {
    if (isEmpty())
        return;
    Queue<Node<Integer>> cola = new LinkedList<>();
    cola.add(root);

    while (!cola.isEmpty()) {
        Node<Integer> actual = cola.poll();
        System.out.print(actual + " ");
        if (actual.getLeft() != null)
            cola.add(actual.getLeft());
        if (actual.getRight() != null)
            cola.add(actual.getRight());
    }
    System.out.println();
}
    // altura
    public int altura() {
        return alturaRecursivo(root);
    }

    private int alturaRecursivo(Node<Integer> actual) {
        if (actual == null)
            return 0;
        int leftHeight = alturaRecursivo(actual.getLeft());
        int rightHeight = alturaRecursivo(actual.getRight());
        return Math.max(leftHeight, rightHeight + 1);
    }
    //peso
    public int peso() {
        return pesoRecursivo(root);
    }
    private int pesoRecursivo(Node<Integer> actual){
        if (actual == null)
            return 0;
        int leftPeso = pesoRecursivo(actual.getLeft());
        int rightPeso = pesoRecursivo(actual.getRight());
        return leftPeso + rightPeso + 1;
    } 
}