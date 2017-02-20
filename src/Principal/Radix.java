
package Principal;

import Excepciones.ListaVaciaException;

public class Radix {
    private Lista lista;
    private Lista[] arreglo;

    public Radix(Lista lista, Lista[] arreglo) {
        this.lista = lista;
        this.arreglo = new Lista[10];
        for (int i = 0; i < 10; i++) {
            arreglo[i] = new Lista();
        }
    }
    
    private void agregarElemento (Integer elemento, Integer index){
        arreglo[index].insertarFinal(elemento);
    }
    
    private void unirListas(){
        for (int i = 0; i < 10; i++) {
            lista.agregar(arreglo[i]);
        }
    }
    
    public void darVuelta(Integer vuelta) throws ListaVaciaException{
        try {
            while(!lista.ListaVacia()){
                Integer elem = lista.sacarElemento();
                Integer idx = getDigito(elem, vuelta);
                agregarElemento(elem, idx);
            }
            unirListas();
        } catch (Exception e){
            throw new ListaVaciaException();
        }
    }

    //COMPONER
    private Integer getDigito(Integer elem, Integer vuelta) {
        return null;
    }
    
    public void ordenar() throws ListaVaciaException{
        Integer mayor = lista.getMayor();
        Integer vueltas = String.valueOf(mayor).length();
        for (int i = 0; i < 10; i++) {
            darVuelta(i + 1);
        }
    }
    
}
