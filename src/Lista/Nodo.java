/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import java.util.function.Predicate;

/**
 *
 * @author santiago
 */
class Nodo<T> {
    private T dato;
    private Nodo siguiente;
    public Nodo(T dato){
        setDato(dato);
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    public boolean existeSiguiente() {
        return this.siguiente!=null;    
    }
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Nodo<T> add(T dato)throws Exception{
        if(existeSiguiente())
            getSiguiente().add(dato);
        else
            setSiguiente(crearNodo(dato));
        return this;
    }
    public Nodo<T> remove(T dato) throws Exception{
        if(getDato().equals(dato))
            return getSiguiente();
        if(existeSiguiente())
            setSiguiente(getSiguiente().remove(dato));
        else
            throw new Exception("No existe el elemento buscado");
        return this;
    }
    public Nodo<T> remove (int index){
        if(index == 0)
            return getSiguiente();
        setSiguiente(getSiguiente().remove(index-1));
        return this;
    }
    public T get(int index){
        if(index==0){
            return getDato();
        }
        return (T) getSiguiente().get(index-1);
    }
    public void getIf(Predicate<T> p,Lista l){
        if(p.test(getDato()))
            l.add(getDato());
        if(existeSiguiente())
            getSiguiente().getIf(p,l);
    }
    public boolean existe(T dato){
        if(getDato().equals(dato))
            return true;
        if(existeSiguiente())
            return getSiguiente().existe(dato);
        return false;
    }
    public int  indexOf(T dato) throws Exception{
        if(getDato().equals(dato))
            return 0;
        if(existeSiguiente())
            return 1 + getSiguiente().indexOf(dato);
        throw new Exception("No existe el elemento");
    }
    @Override
    public String toString(){
        String str = getDato().toString();
        if(existeSiguiente())
            str = str +","+getSiguiente();
        return str;
    }
    public String toString(String separador){
        String str = getDato().toString();
        if(existeSiguiente())
            str = str +separador+getSiguiente().toString(separador);
        return str;
    }
    public  Nodo crearNodo(T dato){
        return new Nodo<>(dato);
    }


}
