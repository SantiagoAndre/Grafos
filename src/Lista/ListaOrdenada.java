
package Lista;


public class ListaOrdenada extends Lista<Comparable> {

    public ListaOrdenada() {
 
    }

    @Override
    public void crearInicio(Comparable dato){
        setInicio(new NodoListaOrdenada(dato));
    }
}
