
package um.edu.uy.tad.LinkedList;

public class ListaEnlazada<T extends Comparable<T>> implements Lista<T> {
    private Nodo<T> head;

    public ListaEnlazada() {
        this.head = null;
    }

    @Override
    public void add(T value) {
        Nodo<T> nuevo = new Nodo<>(value);
        if (head == null) {
            head = nuevo;
        } else {
            Nodo<T> actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    @Override
    public void remove(int posicion) {
        if (head == null || posicion < 0) {
            return;
        }
        if (posicion == 0) {
            head = head.getSiguiente();
            return;
        }

        Nodo<T> actual = head;
        int i = 0;
        while (actual.getSiguiente() != null && i < posicion - 1) {
            i++;
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() == null) {
            return;
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
    }

    @Override
    public T get(int posicion) {
        if (head == null || posicion < 0) {
            return null;
        }

        Nodo<T> actual = head;
        for (int i = 0; i < posicion; i++) {
            if (actual == null) {
                return null;
            }
            actual = actual.getSiguiente();
        }
        return actual.getValue();
    }
     
    public void ingresarConOrdenV2(T value){
        Nodo<T> nuevoNodo = new Nodo<>(value);

        if (head == null || value.compareTo(head.getValue()) < 0) { //si bien se podria "ordenar" con hashcode , la forma mas eficiente y que realmente ordena es con el CompareTo
            
            nuevoNodo.setSiguiente(head); // Insertar al principio
            head = nuevoNodo;
        } else {
            Nodo<T> actual = head;
            while (actual.getSiguiente() != null && value.compareTo(actual.getSiguiente().getValue()) > 0) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
    }

    public void visualizar(ListaEnlazada<Integer> P) {
        Nodo<T> nodoL = head;  // Nodo que recorre la lista L (de objetos)
        Nodo<Integer> nodoP = P.head; // Nodo que recorre la lista P (de índices)

        // Aca ararnco a recorrer ambas listas (funciona parecido a dos for, uno externo (lista L) y otro interno (lista P))
        while (nodoL != null && nodoP != null) {
            int indiceP = nodoP.getValue(); // Agarro el indice de P
            Nodo<T> actual = head;
            int contador = 0;

            // Encontrar el elemento en L correspondiente al índice de P
            while (actual != null && contador < indiceP) {
                actual = actual.getSiguiente();
                contador++;
            }

            // Si encontramos el índice en L, lo imprimimos
            if (actual != null) {
                System.out.println("Elemento en posición " + indiceP + ": " + actual.getValue());
            }

            nodoP = nodoP.getSiguiente(); // Avanzamos en la lista P
        }
    }


    //ejercicio9A

    public void intercambiar(T Object, int direccion){

        Nodo<T> actual = head;
        
        while (actual !=null && !actual.getValue().equals(Object)) {
            actual = actual.getSiguiente();
        }

        //si llego al ultimo y no lo encuentro
        if(actual == null){
            System.out.println("No se encontro el elemento");
        }

        if(direccion ==-1 && actual != head) {
            Nodo<T> anteriorNode = head;

            while(anteriorNode.getSiguiente() != actual){ //Lo hago asi ya que estas listas no tiene la direccion del nodo anterior
                anteriorNode = anteriorNode.getSiguiente();
            }
            
            T valorDelAnterior = anteriorNode.getValue();
            anteriorNode.setValue(actual.getValue());
            actual.setValue(valorDelAnterior);

        }else if(direccion ==1){
            
            Nodo<T> siguiente = actual.getSiguiente();
            T valorActual = actual.getValue();
            actual.setValue(siguiente.getValue());
            siguiente.setValue(valorActual);
 
        }

    }


    public ListaEnlazada<T> ejercicio10A( ListaEnlazada<T> otraLista){

        ListaEnlazada<T> resultado = new ListaEnlazada<>();
        Nodo<T> actual = this.head;
        
        while (actual != null) {
            Nodo<T> temp = otraLista.head;
           
            while (temp != null) { // Comparo con cada elemento de la otra lista
                if (actual.getValue().equals(temp.getValue())) {
                    resultado.add(actual.getValue()); //lo agrego
                    break;  // Si encontramos el elemento, salimos del bucle interno
                }
                temp = temp.getSiguiente();
            }
            actual = actual.getSiguiente();
        }

        return resultado;


    }

    public ListaEnlazada<T> ejercicio10B(ListaEnlazada<T> otraLista) { //chequear este de aca
        ListaEnlazada<T> resultado = new ListaEnlazada<>();
        Nodo<T> actual = this.head;

        
        while (actual != null) {// Recorremos la lista actual
            Nodo<T> temp = otraLista.head;
            boolean encontrado = false;
           
            while (temp != null) { // Comparas con cada elemento de la otra lista
                if (actual.getValue().equals(temp.getValue())) {
                    encontrado = true;  // Elemento encontrado en ambas listas, no lo tengo que agregar
                    break;
                }
                temp = temp.getSiguiente();
            }
            if (!encontrado) {
                resultado.add(actual.getValue());  // Agreg0 si no está en la otra lista
            }
            actual = actual.getSiguiente();
        }

        // Recorremos la otra lista para agregar los elementos que están solo en la otra lista
        actual = otraLista.head;
        while (actual != null) {
            Nodo<T> nodoAux = this.head;
            boolean encontrado = false;
            // Comparamos con cada elemento de la lista original
            while (nodoAux != null) {
                if (actual.getValue().equals(nodoAux.getValue())) {
                    encontrado = true;  // Elemento encontrado en ambas listas, no lo agregas
                    break;
                }
                nodoAux = nodoAux.getSiguiente();
            }
            if (!encontrado) {
                resultado.add(actual.getValue());  // Agregar si no está en la lista original
            }
            actual = actual.getSiguiente();
        }

        return resultado;
    }

    //ejercicio 11 

    public ListaEnlazada<T> crearNuevaLista() { //chequear este metodo!!!
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<>();
        Nodo<T> actual = this.head;

       
        while (actual != null) {
            // Asegurarse de que el valor sea mayor o igual a 0
            if (((Integer) actual.getValue()) >= 0) {
                nuevaLista.add(actual.getValue()); // Agregar el nodo a la nueva lista
            }
            actual = actual.getSiguiente();
        }

        return nuevaLista;  // Devolver la nueva lista
    }

    
    public void eliminarNodosPositivos() {
        
        if (head == null) {
            return;
        }

        // Eliminar nodos al principio de la lista (si son positivos)
        while (head != null && ((Integer) head.getValue()) >= 0) {
            head = head.getSiguiente();
        }

        // Eliminar nodos en el resto de la lista
        Nodo<T> actual = head;
        while (actual != null && actual.getSiguiente() != null) {
            if (((Integer) actual.getSiguiente().getValue()) >= 0) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());  // Eliminar el nodo siguiente
            } else {
                actual = actual.getSiguiente();  // Avanzar al siguiente nodo
            }
        }
    }

    
    public void imprimir() { //para la pruebaaa
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.getValue() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

}
