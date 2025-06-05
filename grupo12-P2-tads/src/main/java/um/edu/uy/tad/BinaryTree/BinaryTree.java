package um.edu.uy.tad.BinaryTree;
import um.edu.uy.p4.tadsAuxiliares.ArrayList.*;
import um.edu.uy.p4.tadsAuxiliares.Queue.*;
import um.edu.uy.p4.tadsAuxiliares.*;
import um.edu.uy.p4.tadsAuxiliares.stack.*;



public class BinaryTree <K extends Comparable<K>,T> implements MyTree<K,T> {

    private BinaryNode<K,T> root;

    public BinaryNode<K, T> getRoot() {
        return root;
    }

    public BinaryNode<K, T> findNodo(K key, BinaryNode<K, T> Nodo) {

        if (Nodo == null) {
            return null;
        }
        if(Nodo.getKey().equals(key)){
            return Nodo;
        }
        if (Nodo.getLeftChild() != null) {

            BinaryNode<K, T> leftChildTemp = this.findNodo(key, Nodo.getLeftChild());
            if(leftChildTemp != null){
                return leftChildTemp;
            }
        }
        if (Nodo.getRightChild() != null) {
            BinaryNode<K, T> rightChildTemp = this.findNodo(key, Nodo.getRightChild());
            if(rightChildTemp != null){
                return rightChildTemp;
            }
        }

        return null;
    }

    @Override
    public T find(K key, BinaryNode<K, T> Nodo) {
        BinaryNode<K,T> aux = findNodo(key, Nodo);

        if(aux != null){
            return aux.getData();
        }
        throw new IllegalArgumentException("No se encontro el nodo con la clave: " + key);
    }

    @Override
    public void insert(K key, T data, K parentKey) { //ARREGLAR SIN PARENT KEY

        BinaryNode<K,T> newNodo = new BinaryNode<>(key,data,null, null);

        if (root == null) {
            root = newNodo;
            return;
        }

        BinaryNode<K,T> padre = findNodo(parentKey,root);
        if(padre != null){
            if(padre.getLeftChild() == null){
                padre.setLeftChild(newNodo);
            } else if(padre.getRightChild() == null){
                padre.setRightChild(newNodo);
            } else {
                throw new ExistingChilds("Ya tiene dos hijos");
            }
        } else {
            throw new IllegalArgumentException("El nodo padre no se ha encontrado");
        }


    }

    @Override
    public void delete(K key) throws ArbolVacio {
        if (root == null) {
            throw new ArbolVacio("El árbol está vacío");
        }

        root = deleteRecursivo(root, key); //hago que arranque desde la raiz
    }

    private BinaryNode<K, T> deleteRecursivo(BinaryNode<K, T> nodo, K key) {

        if (nodo == null) {
            return null;
        }


        if (nodo.getKey().equals(key)) {

            if (nodo.getLeftChild() == null && nodo.getRightChild() == null) {  //hoja
                return null;
            }

            //Nodo con un solo hijo
            if (nodo.getLeftChild() == null) {
                return nodo.getRightChild();
            }
            if (nodo.getRightChild() == null) {
                return nodo.getLeftChild();
            }

            // si tienesoa hijos
            //Subo el arbol de la izquierda y le voy agregando el hijo mas a la derecha que encuentro
            BinaryNode<K, T> SubTreeIzq = nodo.getLeftChild();
            BinaryNode<K, T> masALaDerecha = SubTreeIzq;

            while (masALaDerecha.getRightChild() != null) {
                masALaDerecha = masALaDerecha.getRightChild();
            }

            masALaDerecha.setRightChild(nodo.getRightChild());
            return SubTreeIzq;
        }

        // Sigo recorriendo
        nodo.setLeftChild(deleteRecursivo(nodo.getLeftChild(), key));
        nodo.setRightChild(deleteRecursivo(nodo.getRightChild(), key));

        return nodo;
    }


    @Override
    public int size(BinaryNode<K,T> nodo) {

        if (nodo == null ){
            return 0;
        }

        int  sizeLeft = size(nodo.getLeftChild());
         int sizeRight = size(nodo.getRightChild());

        return 1 + sizeLeft + sizeRight;
    }



    @Override
    public int countLeaf(BinaryNode<K,T> nodo) {

        if(nodo ==null){
            return 0;
        }

        if(nodo.getLeftChild() == null && nodo.getRightChild() == null){
            return 1;
        }

        int leafLeft = countLeaf(nodo.getLeftChild());
        int leafRight = countLeaf(nodo.getRightChild());

        return leafRight + leafLeft;

    }

    @Override
    public int countCompleteElements(BinaryNode<K,T> nodo) {

        if (nodo == null){
            return 0;
        }

        int LeftSubElements = countCompleteElements(nodo.getLeftChild());
        int RightSubElements = countCompleteElements(nodo.getRightChild());

        if(nodo.getRightChild() != null && nodo.getLeftChild() != null){
            return 1 + LeftSubElements + RightSubElements;
        }

            return  LeftSubElements + RightSubElements;

    }




    public MiLista<K> preOrder(BinaryNode<K,T> nodo) {
        MiLista<K> nodosVisitados = new MiArrayList<>();
        if (nodo == null){
            return nodosVisitados;
        }

        nodosVisitados.add(nodo.getKey());
        MiLista<K> preLeft = preOrder(nodo.getLeftChild());
        for (int i = 0; i < preLeft.size(); i++) {
            nodosVisitados.add(preLeft.get(i));
        }

        MiLista<K> preRight = preOrder(nodo.getRightChild());
        for (int i = 0; i < preRight.size(); i++) {
            nodosVisitados.add(preRight.get(i));
        }

        return nodosVisitados;
    }


    public MiLista<K> InOrder(BinaryNode<K,T> nodo) {
        MiLista<K> nodosVisitados = new MiArrayList<>();

        if (nodo == null){
            return nodosVisitados;
        }

        MiLista<K> inLeft = InOrder(nodo.getLeftChild());
        for (int i = 0; i < inLeft.size(); i++) {
            nodosVisitados.add(inLeft.get(i));
        }

        nodosVisitados.add(nodo.getKey());

        MiLista<K> inRight = InOrder(nodo.getRightChild());
        for (int i = 0; i < inRight.size(); i++) {
            nodosVisitados.add(inRight.get(i));
        }

        return nodosVisitados;
    }


    public MiLista<K> postOrder(BinaryNode<K,T> nodo) {
        MiLista<K> nodosVisitados = new MiArrayList<>();

        if (nodo == null){
            return nodosVisitados;
        }

        MiLista<K> postLeft = postOrder(nodo.getLeftChild());
        for (int i = 0; i < postLeft.size(); i++) {
            nodosVisitados.add(postLeft.get(i));
        }

        MiLista<K> postRight = postOrder(nodo.getRightChild());
        for (int i = 0; i < postRight.size(); i++) {
            nodosVisitados.add(postRight.get(i));
        }

        nodosVisitados.add(nodo.getKey());

        return nodosVisitados;
    }

    @Override
    public MiLista<K> recorridoPorNivel(BinaryNode<K,T> nodoRaiz) {
        MiLista<K> clavesVisitadas = new MiArrayList<>();

        if (nodoRaiz == null) {
            return clavesVisitadas;
        }

        MyQueue<BinaryNode<K,T>> cola = new Queue<BinaryNode<K, T>>() {
        };
        cola.enqueue(nodoRaiz);

        while (!cola.isEmpty()) {
            BinaryNode<K,T> actual = cola.dequeue();
            clavesVisitadas.add(actual.getKey());

            if (actual.getLeftChild() != null) {
                cola.enqueue(actual.getLeftChild());
            }

            if (actual.getRightChild() != null) {
                cola.enqueue(actual.getRightChild());
            }
        }

        return clavesVisitadas;
    }



    public void loadPostFijaExpression(String sPostFija) {

        MyStack<BinaryNode<K, T>> stackPosFijo = new Stack<>();
        String[] caracteres = sPostFija.trim().split("\\s+");

        for (String caracter : caracteres) {
            if (esNumero(caracter)) {
                BinaryNode<K, T> nodoNumero = new BinaryNode<>((K) caracter, null, null, null);
                stackPosFijo.push(nodoNumero);
            } else {
                if (stackPosFijo.size() < 2) {
                    throw new IllegalArgumentException("Expresión postfija mal formada. No hay suficientes operandos para el operador: " + caracter);
                }

                try {
                    BinaryNode<K, T> hijoRight = stackPosFijo.pop();
                    BinaryNode<K, T> hijoLeft = stackPosFijo.pop();
                    BinaryNode<K, T> simboloPadre = new BinaryNode<>((K) caracter, null, hijoLeft, hijoRight);
                    stackPosFijo.push(simboloPadre);
                } catch (EmptyStackException e) {
                    throw new IllegalArgumentException("Error inesperado al hacer pop en la pila.", e);
                }
            }
        }

        if (stackPosFijo.size() != 1) {
            throw new IllegalArgumentException("Expresión postfija mal formada. El resultado no es un árbol válido.");
        }

        try {
            root = stackPosFijo.pop();
        } catch (EmptyStackException e) {
            throw new IllegalArgumentException("Error inesperado al sacar la raíz del árbol.", e);
        }
    }



    //funcion auxiliar reciclada de practico 2
    public boolean esNumero(String numero){

        try {
            Integer.parseInt(numero);  // Intenta convertir la cadena a un número
            return true;
        } catch (NumberFormatException e) {
            return false;  // Si lanza una excepción, no es un número
        }

    }






}
