# Informe: Ejercicio 1 y 2

## Ejercicio 1 — Imprimir BST

```java
public void insert(int[] numeros) {
    BinaryTree<Integer> tree = new BinaryTree<>();
    for (int n : numeros) tree.insert(n);
    printTree(tree.getRoot());
}

private void printTreeRecursivo(Node<Integer> actual, int nivel) {
    if (actual == null) return;
    printTreeRecursivo(actual.getRight(), nivel + 1);
    System.out.println("  ".repeat(nivel) + actual.getValue());
    printTreeRecursivo(actual.getLeft(), nivel + 1);
}
```

Cada valor sigue el metodo: izquierda menores, derecha mayores, recorre primero la rama derecha, imprime segun su nivel, luego la rama izquierda.

---

## Ejercicio 2 — Invertir BST

```java
public Node<Integer> invert(Node<Integer> root) {
    System.out.println("Arbol original:"); printTree(root);
    invertRecursively(root);
    System.out.println("Arbol invertido:"); printTree(root);
    return root;
}

private void invertRecursively(Node<Integer> actual) {
    if (actual == null) return;
    Node<Integer> temp = actual.getLeft();
    actual.setLeft(actual.getRight());
    actual.setRight(temp);
    invertRecursively(actual.getLeft());
    invertRecursively(actual.getRight());
}
```

Del arbol original, intercambia el izquierdo y derecho de cada nodo. Imprime el arbol invertido. El arbol queda con los mayores a la izquierda y menores a la derecha.