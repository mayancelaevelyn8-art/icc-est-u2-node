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
# Informe: Ejercicio 3 y 4

## Ejercicio 3 — Listar Niveles en Listas Enlazadas

```java
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
```

Recorrer el arbol por niveles cada iteracion, los agrega a una lista, y encola sus hijos. Devuelve una lista de listas, una por nivel.

---

## Ejercicio 4 — Calcular Profundidad Maxima

```java
public int maxDepth(Node<Integer> root) {
    if (root == null) return 0;
    int left = maxDepth(root.getLeft());
    int right = maxDepth(root.getRight());
    return Math.max(left, right) + 1;
}
```

Calcula la rama izquierda y derecha de cada nodo, la profundidad maxima corresponde al camino mas largo desde la raiz hasta una hoja.


