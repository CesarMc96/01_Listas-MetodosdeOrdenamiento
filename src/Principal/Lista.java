package Principal;

import Excepciones.ElementoNoEncontradoException;

public class Lista {

    private Nodo inicio;
    private Integer contador;

    public Lista() {
        inicio = null;
        contador = 0;
    }

    public void insertarFinal(Integer elemento) {
        Nodo nuevo = new Nodo(elemento);

        if (ListaVacia()) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }

        sumarContador();
    }

    private boolean ListaVacia() {
        return inicio == null;
    }

    public void insertarPrincipio(Integer elemento) {
        Nodo nuevo = new Nodo(elemento);

        if (ListaVacia()) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        sumarContador();
    }

    public void recorrerLista() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.println(aux.getElemento());
            aux = aux.getSiguiente();
        }
    }

    public void insertarOrdenado(Integer elemento) {
        Nodo nuevo = new Nodo(elemento);

        if (ListaVacia()) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            Nodo anterior = null;

            while (aux != null && aux.getElemento() < elemento) {
                anterior = aux;
                aux = aux.getSiguiente();
            }

            if (anterior == null) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else {
                anterior.setSiguiente(nuevo);
                nuevo.setSiguiente(aux);
            }
        }
        sumarContador();
    }

    public boolean existeElemento(Integer elemento) {
        Nodo aux = inicio;

        while (aux != null && aux.getElemento() != elemento) {
            aux = aux.getSiguiente();
        }

        return aux != null;
    }

    public boolean estaOrdenada() {
        Nodo aux = inicio;
        boolean bandera = true;

        while (aux != null && bandera) {
            bandera = aux.getElemento() != null && aux.getElemento() <= aux.getSiguiente().getElemento();
            aux = aux.getSiguiente();
        }

        return aux != null;
    }

    public void ordenarBurbuja() {
        Nodo aux2 = inicio;
        Nodo aux1 = inicio;

        while (aux2 != null) {
            aux1 = aux2.getSiguiente();
            while (aux1 != null) {
                if (aux1.getElemento().compareTo(aux2.getElemento()) < 0) {
                    int temporal = aux2.getElemento();
                    aux2.setElemento(aux1.getElemento());
                    aux1.setElemento(temporal);
                }
                aux1 = aux1.getSiguiente();
            }
            aux2 = aux2.getSiguiente();
        }

    }

    public void sumarContador() {
        contador++;
    }

    public Integer totalElementos() {
        return contador;
    }

    public void eliminarInicio() {
        if (!ListaVacia()) {
            Nodo aux = inicio;
            inicio = inicio.getSiguiente();
            aux.setSiguiente(null);
        }
    }

    public void eliminarFinal() {
        Nodo aux = inicio;
        Nodo ant = null;

        while (aux != null && aux.getSiguiente() == null) {
            ant = aux;
            aux = aux.getSiguiente();
        }

        if (aux != null) {
            if (ant == null) {
                inicio = null;
            } else {
                ant.setSiguiente(null);
            }
        }
    }

    public void elementarElemento(Integer elemento) throws ElementoNoEncontradoException {
        Nodo aux = inicio;
        Nodo ant = null;

        while (aux != null && aux.getElemento() != elemento) {
            ant = aux;
            aux = aux.getSiguiente();
        }
        
        if(aux != null){
            throw new ElementoNoEncontradoException();
        } else if (ant == null) {
            inicio = inicio.getSiguiente();
            aux.setSiguiente(null);
        } else {
            ant.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(null);
        }
    }
    
    public void eliminarElementoRepetido(Integer elemento) throws ElementoNoEncontradoException{
        Nodo aux = inicio;
        Nodo ant = null;
        Boolean bandera = false;
        
        while(aux != null){
            if(aux.getElemento() == elemento){
                bandera = true;
                if(ant == null){
                    inicio = inicio.getSiguiente();
                    aux.setSiguiente(null);
                    aux = inicio;
                } else {
                    ant.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(null);
                    aux = ant.getSiguiente();
                }
            } else {
                ant = aux;
                aux = aux.getSiguiente();
            }
        }
        
        if(bandera){
            throw new ElementoNoEncontradoException();
        }
    }
}
