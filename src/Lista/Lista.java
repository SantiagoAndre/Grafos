/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import java.lang.reflect.Method;
import java.util.function.Predicate;



/**
 *
 * @author santiago
 */
public class Lista<T> {
    private Nodo<T> inicio;
    private int tamano=0;

    public Lista(Lista otraLista) {
        for(int i = 0; i< otraLista.getTamano();i++){
            this.add((T) otraLista.get(i));
        }
    }
    public Lista() {

    }
    private boolean existeInicio() {
        return getInicio()!= null;
    }
    public Nodo<T> getInicio() {
        return inicio;
    }

    /**
     *
     * @param inicio
     */
    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }
    public void crearInicio(T dato){
        setInicio(new Nodo<>(dato));
    }
    public boolean esVacia(){
        return !existeInicio();
    }
    public boolean add(T dato){
        try {
            if(existeInicio())
                setInicio(getInicio().add(dato));
            else
                crearInicio(dato);
            tamano++;         
            return true;
        } catch (Exception ex) {
            return false;
        }        
    }
    public void addAll(Lista l){
        Nodo nodo = l.getInicio();
        while(nodo!= null){
            add((T) nodo.getDato());
            nodo = nodo.getSiguiente();
        }
    }
    public boolean remove(T dato){
         try {
            if(existeInicio()){         
                setInicio(getInicio().remove(dato));
                tamano--;
               return true;
           }else
               return false;
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean remove(int index){
       try {
           if(index <0 || index>= tamano)
               return false;
           if(existeInicio()){         
               setInicio(getInicio().remove(index));
               return true;
           }else
               return false;
       } catch (Exception ex) {
           return false;
       }
    }
    public T get(int index){
        if(existeInicio())
            return getInicio().get(index);
        else
            return null;
    }
    public Lista<T> getIf(Predicate<T> p){
        Lista<T> lista = new Lista();
        if(existeInicio()){
            getInicio().getIf(p,lista);
        }
        return lista;
    }
    public boolean existe(T dato){
        if(existeInicio())
            return getInicio().existe(dato);
        return false;
    }
    public int indexOf(T dato){
        try {
            if(existeInicio())
                return getInicio().indexOf(dato);
            return -1;
        } catch (Exception ex) {
            return -1;
        }
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    @Override
    public String toString(){
        return toString(",");
    }
    public String toString(String separador,String extremoIzq,String extremoDer){
        String str;
        if(existeInicio())
            str = getInicio().toString(separador);
        else
            str="";
        return  extremoIzq+ str + extremoDer ;
    }
    public String toString(String separador){
        return toString(separador,"[","]");
    }
    public void forEach(Object objeto,Method metodo, Object[] parametros) throws Exception{
        Object[] parametroExtra = {getInicio().getDato()};
        Object[] par= new Object[parametros.length+1];
        System.arraycopy(parametros,0,par, 0, parametros.length);
        Nodo<T> nodo = getInicio();
        while(nodo!= null){
            par[par.length-1] = nodo.getDato();
            metodo.invoke(objeto, par);
            nodo= nodo.getSiguiente();
        }
    }
}
