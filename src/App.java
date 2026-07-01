import java.util.List;
import java.util.Random;
import java.util.Set;
import collections.maps.Maps;
import collections.sets.Sets;
import estructura.graphs.Graph;
import models.Contacto;
import models.Person;
import trees.BinaryTree;
import trees.Ejercicio1;
import trees.Ejercicio2;
import trees.Ejercicio3;
import trees.Ejercicio4;
import trees.IntTree;
import node.Node;

public abstract class App {
    public static void main(String[] args) throws Exception {
        runIntTree();
        runPersonTree();
        runIntComparativaPesos();
        runEjercicio1();
        runEjercicio2();
        runEjercicio3();
        runEjercicio4();
        runSets();
        runMaps();
        runGraph();
    }

    private static void runGraph(){
        Graph<String> grafo = new Graph<>();
        grafo.add("A");
        grafo.add("B");
        grafo.add("C");
        grafo.add("D");
        grafo.add("J");
        
        grafo.addEdge("J", "D");
        grafo.addEdge("C", "D");
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("B", "D");
        grafo.addEdge("C", "D");
        grafo.addEdge("D", "J");
        
        System.out.println("pp");
        grafo.printGraph();

    }

    private static void runMaps() {
        Maps maps = new Maps();
        maps.construriHasMap();
    }

    public static void runEjercicio1(){
        Ejercicio1 ejercicio1 = new Ejercicio1();
        int [] numeros = {5, 3, 7, 2, 4, 6, 8};
        ejercicio1.insert(numeros);
    }

    public static void runEjercicio2(){
        Ejercicio2 ejercicio2 = new Ejercicio2();
        BinaryTree<Integer> tree = new BinaryTree<>();
        int [] numeros = {4, 2, 7, 1, 3, 6, 9};
        for (int n : numeros) {
        tree.insert(n);
    }
    ejercicio2.invert(tree.getRoot());
}  
    public static void runEjercicio3() {
       BinaryTree<Integer> tree = new BinaryTree<>();
        int[] numeros = {4, 2, 7, 1, 3, 6, 9};
           for (int n : numeros) tree.insert(n);

    Ejercicio3 ejercicio3 = new Ejercicio3();
    List<List<Node<Integer>>> niveles = ejercicio3.listLevels(tree.getRoot());

    for (List<Node<Integer>> nivel : niveles) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel.size(); i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(nivel.get(i).getValue());
        }
        System.out.println(sb.toString());
    }
}
public static void runEjercicio4() {
    BinaryTree<Integer> tree = new BinaryTree<>();
    int[] numeros = {4, 2, 1, 8, 3, 7};
    for (int n : numeros) tree.insert(n);

    Ejercicio4 ejercicio4 = new Ejercicio4();
    System.out.println("Altura maxima: " + ejercicio4.maxDepth(tree.getRoot()));
}

    private static void runPersonTree() {
        BinaryTree<Person> personTree = new BinaryTree<>();
        personTree.insert(new Person("Alice", 30));
        personTree.insert(new Person("Bob", 25));
        personTree.insert(new Person("Diego", 35));   
        personTree.insert(new Person("Rafael", 30));
        personTree.insert(new Person("Ana", 35));
        personTree.inOrder();
        System.out.println();
        System.out.println();
    }
    private static void runIntComparativaPesos() {
        IntTree tree = new IntTree();
        Random random = new Random();

        final int TOTAL_NODOS = 50_000;
        final int MIN = 1;
        final int MAX = 50_000;

        // Insertar 50 000 números aleatorios entre 1 y 50 000
        for (int i = 0; i < TOTAL_NODOS; i++) {
            int value = random.nextInt(MAX - MIN + 1) + MIN;
            tree.insert(value);
        }

        // Medir peso con variable acumulada
        long inicioPesoVariable = System.nanoTime();

        int pesoVariable = tree.getPeso();

        long finPesoVariable = System.nanoTime();

        double tiempoPesoVariableMs = (finPesoVariable - inicioPesoVariable) / 1_000_000.0;

        // Medir peso recursivo
        long inicioPesoRecursivo = System.nanoTime();

        int pesoRecursivo = tree.peso();

        long finPesoRecursivo = System.nanoTime();

        double tiempoPesoRecursivoMs = (finPesoRecursivo - inicioPesoRecursivo) / 1_000_000.0;

        // Resultados
        System.out.println("Cantidad de nodos insertados: " + TOTAL_NODOS);
        System.out.println("Peso usando variable: " + pesoVariable);
        System.out.println("Peso usando recursion: " + pesoRecursivo);

        System.out.println();

        System.out.println("Tiempo getPeso(): "
                + tiempoPesoVariableMs + " ms");

        System.out.println("Tiempo pesoRecursivo(): "
                + tiempoPesoRecursivoMs + " ms");
    }

    private static void runIntTree() {
        IntTree arbolNumeros = new IntTree(); /// CLASE ARBOL

        // Node<Integer> node3 = new Node<>(30);
        // Node<Integer> node4 = new Node<>(40);
        // Node<Integer> node5 = new Node<>(50);

        // Node<Integer> root = arbolNumeros.getRoot();

        // root.setLeft(node2);
        // root.setRight(node3);

        // node2.setLeft(node4);
        // node4.setRight(node5);

        //// ERROR GENERA CLICLOS
        // node5.setLeft(root);

        arbolNumeros.insert(10);
        arbolNumeros.insert(5);
        arbolNumeros.insert(3);
        arbolNumeros.insert(8); /// INORDER 3, 5, 8, 10, 15, 20
        arbolNumeros.insert(20); /// POSTORDER 3 8 5 15 20 10
        arbolNumeros.insert(15); // ANCHURA O NIVELES: 10 5 20 3 8 15

        System.out.println(  "pre Order");
        arbolNumeros.preOrder();

        System.out.println(  "Pos Order");
        arbolNumeros.posOrder();

        System.out.println( " in Order");
        arbolNumeros.inOrder();

        System.out.println("por Niveles");
        arbolNumeros.porNiveles();
    }

    private static void runSets() {
    Sets sets = new Sets();

    //Primera implementacion
    System.out.println("HashSets");
    Set<String> hashSet = sets.construirHashSet();
    System.out.println(hashSet);
    System.out.println("Tamanio: " + hashSet.size());
    System.out.println(hashSet.contains("F"));

    //Segunda  implementacion        
    System.out.println("LinkedHashSet");
    Set<String> linkedHashSet = sets.construirLinkedHashSet();
    System.out.println(linkedHashSet);
    System.out.println("Tamanio: " + linkedHashSet.size());
    System.out.println(linkedHashSet.contains("F"));

    //Tercera  implementacion   
    System.out.println("TreeSet");
    Set<String> treeSet = sets.construirTreeSet();
    System.out.println(treeSet);
    System.out.println("Tamanio: " + treeSet.size());
    System.out.println(treeSet.contains("F"));

    //Cuarta implementacion
    System.out.println("TreeSet");
    Set<Contacto> tCSet = sets.construirTreeSetConComparador();
    System.out.println(tCSet);
    System.out.println("Tamanio: " + tCSet.size());
               

    }
 
}
