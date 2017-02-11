
package Principal;

public class Nodo {
    private Integer elemento;
    private Nodo siguiente;

    @Override
    public String toString() {
        return "Nodo{" + "elemento=" + elemento + ", siguiente=" + siguiente + '}';
    }

    public Nodo(Integer elemento) {
        this.elemento = elemento;
        siguiente = null;
    }

    public Integer getElemento() {
        return elemento;
    }

    public void setElemento(Integer elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
