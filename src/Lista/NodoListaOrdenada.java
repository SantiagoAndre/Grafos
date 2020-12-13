
package Lista;

public class NodoListaOrdenada extends Nodo<Comparable>{
    
    public NodoListaOrdenada(Comparable dato) {
        super(dato);
    }

 
    @Override
    public Nodo<Comparable> add(Comparable dato) throws Exception{
        int comparacion=getDato().compareTo(dato);
        if(comparacion>=0 ){
            Nodo nuevo = crearNodo(dato);
            nuevo.setSiguiente(this);
            return nuevo;
        }
        
        if(existeSiguiente()){
            Nodo siguiente = getSiguiente();
            setSiguiente(siguiente.add(dato));
        }else
            setSiguiente(crearNodo(dato));
        return this;            
    }
    @Override
    public Nodo crearNodo(Comparable dato){
        return new NodoListaOrdenada(dato);
    }
}
