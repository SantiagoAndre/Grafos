
package Lista;

public class ConjuntoOrdenado extends Lista<Comparable>{
    @Override
    public void crearInicio(Comparable dato){
        setInicio(new NodoConjuntoOrdenado(dato));
    }    
}
