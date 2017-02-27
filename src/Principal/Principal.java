
package Principal;

public class Principal {
    public static void main(String[] args) {
        
        Lista l = new Lista();
        l.insertarFinal(15);
        l.insertarFinal(1);
        l.insertarFinal(22);
        l.insertarFinal(8);
        
        l.recorrerLista();

        System.out.println("*********************");
        
        l.ordenarQuicksort();
        //l.recorrerLista();
    }
}
