import java.util.ArrayList;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /* ---------- INSERCIÓN ---------- */

    // CORRECCIÓN: se actualiza la raíz con el resultado del método recursivo
    public void insertNode(Node newNode) {
        root = insertRecursive(newNode, root);
    }

    // Parte C: las claves iguales (>=) se envían a la rama derecha para evitar pérdida de datos
    public Node insertRecursive(Node nodeToInsert, Node rootNode) {
        // condición de parada: punto de inserción encontrado
        if (rootNode == null)
            return nodeToInsert;

        // llamados recursivos
        if (nodeToInsert.getKey() < rootNode.getKey())
            rootNode.setLeft(insertRecursive(nodeToInsert, rootNode.getLeft()));
        else
            rootNode.setRight(insertRecursive(nodeToInsert, rootNode.getRight()));
        return rootNode;
    }

    /* ---------- BÚSQUEDA ---------- */

    public boolean searchNodeRecursive(int key, Node rootNode) {
        if (rootNode == null)
            return false;
        if (rootNode.getKey() == key)
            return true;
        if (rootNode.getKey() > key)
            return searchNodeRecursive(key, rootNode.getLeft());
        return searchNodeRecursive(key, rootNode.getRight());
    }

    /**
     * Parte A.1: retorna el NODO cuya clave coincide con 'key',
     * o null si no existe.
     */
    public Node buscarNodo(int key, Node rootNode) {
        if (rootNode == null || rootNode.getKey() == key)
            return rootNode;
        if (key < rootNode.getKey())
            return buscarNodo(key, rootNode.getLeft());
        return buscarNodo(key, rootNode.getRight());
    }

    /* ---------- RECORRIDOS (vistos en clase) ---------- */

    public void InOrder(Node root) {
        if (root == null)
            return;
        InOrder(root.getLeft());
        System.out.println("->" + root.getKey());
        InOrder(root.getRight());
    }

    public void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println("->" + root.getKey());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void posOrder(Node root) {
        if (root == null)
            return;
        posOrder(root.getLeft());
        posOrder(root.getRight());
        System.out.println("->" + root.getKey());
    }

    /* ---------- OPERACIONES COMPLETADAS ---------- */

    /**
     * Parte A.2: retorna la lista de llaves ordenada ascendentemente.
     */
    public ArrayList<Integer> getKeyList() {
        ArrayList<Integer> keyList = new ArrayList<>();
        fillKeyListInOrder(root, keyList);
        return keyList;
    }

    private void fillKeyListInOrder(Node current, ArrayList<Integer> keyList) {
        if (current == null)
            return;
        fillKeyListInOrder(current.getLeft(), keyList);
        keyList.add(current.getKey());
        fillKeyListInOrder(current.getRight(), keyList);
    }

    /**
     * Parte B - R1: retorna los clientes en orden ASCENDENTE de clave.
     */
    public ArrayList<Cliente> clientesAscendente() {
        ArrayList<Cliente> lista = new ArrayList<>();
        clientesAscendenteRec(root, lista);
        return lista;
    }

    private void clientesAscendenteRec(Node current, ArrayList<Cliente> lista) {
        if (current == null)
            return;
        clientesAscendenteRec(current.getLeft(), lista);
        lista.add((Cliente) current.getValue());
        clientesAscendenteRec(current.getRight(), lista);
    }

    /**
     * Parte B - R2: retorna, como máximo, los 'n' clientes con las
     * claves MÁS ALTAS, de mayor a menor, deteniéndose al reunir 'n'.
     */
    public ArrayList<Cliente> mayoresN(int n) {
        ArrayList<Cliente> lista = new ArrayList<>();
        if (n > 0) {
            mayoresNRec(root, n, lista);
        }
        return lista;
    }

    private void mayoresNRec(Node current, int n, ArrayList<Cliente> lista) {
        if (current == null || lista.size() >= n)
            return;
        mayoresNRec(current.getRight(), n, lista);
        if (lista.size() < n) {
            lista.add((Cliente) current.getValue());
            mayoresNRec(current.getLeft(), n, lista);
        }
    }

    /**
     * Parte B - R3: retorna los clientes cuya clave esté en [min, max],
     * en orden ascendente, podando ramas fuera del intervalo.
     */
    public ArrayList<Cliente> clientesEnRango(int min, int max) {
        ArrayList<Cliente> lista = new ArrayList<>();
        clientesEnRangoRec(root, min, max, lista);
        return lista;
    }

    private void clientesEnRangoRec(Node current, int min, int max, ArrayList<Cliente> lista) {
        if (current == null)
            return;
        if (current.getKey() > min) {
            clientesEnRangoRec(current.getLeft(), min, max, lista);
        }
        if (current.getKey() >= min && current.getKey() <= max) {
            lista.add((Cliente) current.getValue());
        }
        if (current.getKey() <= max) {
            clientesEnRangoRec(current.getRight(), min, max, lista);
        }
    }

    /**
     * Parte B - R5: retorna el cliente con la clave mínima (o null si
     * el árbol está vacío). No recorre todo el árbol: solo baja por la izquierda.
     */
    public Cliente minimo() {
        if (root == null)
            return null;
        return (Cliente) minimoRec(root).getValue();
    }

    private Node minimoRec(Node current) {
        if (current.getLeft() == null)
            return current;
        return minimoRec(current.getLeft());
    }

    /**
     * Parte B - R5: retorna el cliente con la clave máxima (o null si
     * el árbol está vacío). Solo baja por la derecha.
     */
    public Cliente maximo() {
        if (root == null)
            return null;
        return (Cliente) maximoRec(root).getValue();
    }

    private Node maximoRec(Node current) {
        if (current.getRight() == null)
            return current;
        return maximoRec(current.getRight());
    }

    /**
     * Parte D: retorna la altura del árbol. Convención: un árbol vacío
     * tiene altura -1 y un árbol con un solo nodo tiene altura 0.
     */
    public int altura(Node rootNode) {
        if (rootNode == null)
            return -1;
        int alturaIzq = altura(rootNode.getLeft());
        int alturaDer = altura(rootNode.getRight());
        return 1 + Math.max(alturaIzq, alturaDer);
    }
}
