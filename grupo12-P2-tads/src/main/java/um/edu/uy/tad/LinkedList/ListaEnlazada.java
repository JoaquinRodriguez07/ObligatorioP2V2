package um.edu.uy.tad.LinkedList;

public class ListaEnlazada implements Lista {
    private Nodo primero;

    public ListaEnlazada() {
        this.primero = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void add(Object value) {
        Nodo nuevo = new Nodo(value);
        if (primero == null || ((Comparable) value).compareTo(primero.value) < 0) {
            nuevo.next = primero;
            primero = nuevo;
            return;
        }
        Nodo aux = primero;
        while (aux.next != null && ((Comparable) value).compareTo(aux.next.value) > 0) {
            aux = aux.next;
        }
        nuevo.next = aux.next;
        aux.next = nuevo;
    }

    public void remove(int position) {
        if (position == 0) {
            if (primero != null) {
                primero = primero.next;
            }
        } else {
            Nodo actual = primero;
            int i = 0;
            while (actual != null && i < position - 1) {
                actual = actual.next;
                i++;
            }
            if (actual != null && actual.next != null) {
                actual.next = actual.next.next;
            }
        }
    }

    public Object get(int position) {
        Nodo actual = primero;
        int i = 0;
        while (actual != null && i < position) {
            actual = actual.next;
            i++;
        }
        if (actual != null) {
            return actual.value;
        } else {
            return null;
        }
    }

    public void addFirst(Object value) {
        Nodo nodo = new Nodo(value);
        nodo.next = primero;
        primero = nodo;
    }

    public void addLast(Object value) {
        Nodo nodo = new Nodo(value);
        if (primero == null) {
            primero = nodo;
            return;
        }
        Nodo actual = primero;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nodo;
    }

    public void visualizar(ListaEnlazada posiciones) {
        Nodo actual = posiciones.getPrimero();
        while (actual != null) {
            int posicion = (int) actual.value;
            Object valor = this.get(posicion);
            System.out.println(valor);
            actual = actual.next;
        }
    }

    public void intercambiar(Object value, int posicion) {
        if (posicion != 1 && posicion != -1 && (primero == null || primero.next == null)) {
            return;
        }
        Nodo actual = primero;
        Nodo anterior = null;
        while (actual != null && !actual.value.equals(value)) {
            anterior = actual;
            actual = actual.next;
        }

        if (posicion == 1 && actual != null && actual.next != null) {
            Nodo siguiente = actual.next;
            if (anterior != null) {
                anterior.next = siguiente;
            } else {
                primero = siguiente;
            }
            actual.next = siguiente.next;
            siguiente.next = actual;
        }

        if (posicion == -1 && anterior != null) {
            Nodo preAnterior = null;
            Nodo temp = primero;
            while (temp != null && temp.next != anterior) {
                temp = temp.next;
            }
            preAnterior = temp;

            if (preAnterior != null) {
                preAnterior.next = actual;
            } else {
                primero = actual;
            }

            anterior.next = actual.next;
            actual.next = anterior;
        }
    }

    public boolean contiene(Object value) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.value.equals(value)) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    public ListaEnlazada interseccion(ListaEnlazada a) {
        ListaEnlazada r = new ListaEnlazada();
        Nodo actual = this.getPrimero();
        while (actual != null) {
            if (a.contiene(actual.value) && !r.contiene(actual.value)) {
                r.add(actual.value);
            }
            actual = actual.next;
        }
        return r;
    }

    public int size() {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }
}